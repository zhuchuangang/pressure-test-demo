package com.songshu.pressure.test.demo.customer.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.songshu.pressure.test.demo.plugin.servlet.ServletPressureTestFilter;

/**
 * @author 鼠笑天
 * @date 2019/12/29
 */
@Configuration
public class AppConfig {
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new ServletPressureTestFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
