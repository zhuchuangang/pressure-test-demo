package com.songshu.pressure.test.demo.model.entry;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 鼠笑天
 * @date 2019/12/24
 */
@Data
@Document
public class LogEntry {

    @Id
    private String id;


    private String log;
}
