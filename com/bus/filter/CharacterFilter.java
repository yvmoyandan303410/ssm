package com.bus.filter;

import javax.servlet.*;
import java.io.IOException;


public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("字符过滤器初始化！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //解决乱码情况
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //过滤器链---> 到下一个过滤器去
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        System.out.println("字符过滤器销毁了！");
    }
}
