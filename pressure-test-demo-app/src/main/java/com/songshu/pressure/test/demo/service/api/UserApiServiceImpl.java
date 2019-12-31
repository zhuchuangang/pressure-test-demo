package com.songshu.pressure.test.demo.service.api;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.songshu.pressure.test.demo.api.UserApiService;
import com.songshu.pressure.test.demo.dto.UserDTO;
import com.songshu.pressure.test.demo.model.entiry.UserDO;
import com.songshu.pressure.test.demo.model.entry.LogEntry;
import com.songshu.pressure.test.demo.repository.LogRepository;
import com.songshu.pressure.test.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 鼠笑天
 * @date 2019/12/29
 */
@Slf4j
@Service(version = "1.0.0", timeout = 5000, validation = "true", dynamic = true)
public class UserApiServiceImpl implements UserApiService {

    @Autowired
    private UserService userService;

    @Autowired
    private LogRepository logRepository;

    @Override
    public UserDTO find(String name) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        queryWrapper.last("limit 0,1");
        UserDO userDO = userService.getOne(queryWrapper);
        LogEntry logEntry = new LogEntry();
        logEntry.setLog(name);
        logRepository.save(logEntry);
        if (userDO != null) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userDO, userDTO);
            return userDTO;
        }
        return null;
    }

    @Override
    public void save(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO, userDO);
        LogEntry logEntry = new LogEntry();
        logEntry.setLog(userDTO.toString());
        logRepository.save(logEntry);
        userService.save(userDO);
    }

}
