package com.songshu.pressure.test.demo.customer.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.songshu.pressure.test.demo.api.UserApiService;
import com.songshu.pressure.test.demo.dto.UserDTO;

/**
 * @author 鼠笑天
 * @date 2019/12/29
 */
@RestController
public class CustomerController {

    /**
     * userApiService
     */
    @Reference(version = "1.0.0", retries = 0, validation = "true")
    private UserApiService userApiService;

    /**
     *
     * @param name 姓名
     * @return UserDTO
     */
    @GetMapping("/test/dubbo/user")
    public UserDTO testDubbo(@RequestParam("name") String name) {
        UserDTO userDTO = userApiService.find(name);
        return userDTO;
    }

    @PostMapping("/test/dubbo/save")
    public String testMysqlSave(@RequestBody UserDTO userDTO) {
        userApiService.save(userDTO);
        return "{\"success\":true}";
    }

}
