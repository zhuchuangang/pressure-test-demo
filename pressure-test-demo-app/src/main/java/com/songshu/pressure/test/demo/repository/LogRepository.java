package com.songshu.pressure.test.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.songshu.pressure.test.demo.model.entry.LogEntry;

/**
 * @author 鼠笑天
 * @date 2019/12/29
 */
public interface LogRepository extends MongoRepository<LogEntry, String> {}
