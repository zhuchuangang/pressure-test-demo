package com.songshu.pressure.test.demo.controller;

import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.songshu.pressure.test.demo.dto.UserDTO;
import com.songshu.pressure.test.demo.model.entiry.UserDO;
import com.songshu.pressure.test.demo.model.entry.LogEntry;
import com.songshu.pressure.test.demo.repository.LogRepository;
import com.songshu.pressure.test.demo.service.UserService;

/**
 * @author 鼠笑天
 * @date 2019/12/24
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogRepository logRepository;

    @PostMapping("/test/mysql/save")
    public String testMysqlSave(@RequestBody UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO, userDO);
        userService.save(userDO);
        LogEntry logEntry = new LogEntry();
        logEntry.setLog(userDO.toString());
        logRepository.save(logEntry);
        return "{\"success\":true}";
    }

    @PostMapping("/test/stream/mysql/save")
    public String testStreamMysqlSave(@RequestBody UserDTO userDTO) {
        Stream.of(1, 2, 3, 4, 5).parallel().forEach(x -> {
            userDTO.setName(userDTO.getName() + "_" + x);
            UserDO userDO = new UserDO();
            BeanUtils.copyProperties(userDTO, userDO);
            userService.save(userDO);
            LogEntry logEntry = new LogEntry();
            logEntry.setLog(userDO.toString());
            logRepository.save(logEntry);
        });
        return "{\"success\":true}";
    }
}
