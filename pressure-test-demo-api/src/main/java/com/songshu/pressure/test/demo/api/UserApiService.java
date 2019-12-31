package com.songshu.pressure.test.demo.api;

import com.songshu.pressure.test.demo.dto.UserDTO;

/**
 * @author 鼠笑天
 * @date 2019/12/29
 */
public interface UserApiService {

    UserDTO find(String name);

    void save(UserDTO userDTO);

}
