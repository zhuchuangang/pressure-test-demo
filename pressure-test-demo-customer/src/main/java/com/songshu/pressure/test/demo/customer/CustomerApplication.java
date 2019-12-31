package com.songshu.pressure.test.demo.customer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 鼠笑天
 * @date 2019/12/29
 */
@EnableDubbo
@SpringBootApplication
public class CustomerApplication {

    /**
     * 主方法
     *
     * @param args spring boot参数
     */
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
