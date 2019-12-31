package com.songshu.pressure.test.demo.plugin.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.util.StringUtils;

import com.songshu.pressure.test.demo.plugin.context.MarkContext;

/**
 * @author 鼠笑天
 * @date 2019/12/27
 */
public class ServletPressureTestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        String mark = servletRequest.getParameter(MarkContext.MARK);
        if (!StringUtils.isEmpty(mark)) {
            MarkContext.PRESSUER_TEST_MARK.set(true);
        }
        filterChain.doFilter(servletRequest, servletResponse);
        MarkContext.PRESSUER_TEST_MARK.set(null);
    }
}
