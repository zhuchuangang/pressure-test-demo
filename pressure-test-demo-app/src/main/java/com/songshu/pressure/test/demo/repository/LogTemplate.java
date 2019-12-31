package com.songshu.pressure.test.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 鼠笑天
 * @date 2019/12/29
 */
@Component
public class LogTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;
}
