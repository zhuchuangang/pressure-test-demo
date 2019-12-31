package com.songshu.pressure.test.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.util.StringUtils;

/**
 * @author 鼠笑天
 * @date 2019/12/24
 */
@EnableDubbo
@ServletComponentScan
@SpringBootApplication
public class DemoApplication {
    /**
     * 主方法
     *
     * @param args spring boot参数
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
