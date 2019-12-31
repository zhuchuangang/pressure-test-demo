package com.songshu.pressure.test.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import com.songshu.pressure.test.demo.dao.UserDAO;
import com.songshu.pressure.test.demo.model.entiry.UserDO;

/**
 * @author 鼠笑天
 * @date 2019/12/24
 */
@Service
public class UserService extends ServiceImpl<UserDAO,UserDO> {

}
