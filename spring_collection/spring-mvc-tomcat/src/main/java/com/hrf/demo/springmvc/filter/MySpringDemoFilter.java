package com.hrf.demo.springmvc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 *
 */
public class MySpringDemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("自定义过滤器初始化方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器拦截前");
        filterChain.doFilter(request,response);
        System.out.println("过滤器拦截后");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器方法销毁");
    }
}
