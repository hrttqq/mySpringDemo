package com.hrf.demo.springmvc.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class MySpringDemoInterceptor extends HandlerInterceptorAdapter {
    /**
     * 目标方法执行前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("获取拦截地址:"+uri);
        //获取请求头的参数
        String token = request.getHeader("OCLOUD-TOKEN");
        String packageName = request.getHeader("OCLOUD-PACKAGE-NAME");
        if (StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(packageName)){
            System.out.println("token is null or packageName is null!!!");
            error403(response);
            //拦截器驳回
            return false;
        }
        //拦截器放行
        return true;
    }

    private void error403(HttpServletResponse resp) {
        resp.setStatus(403);
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = resp.getWriter();
            resp.setContentLength("{\"code\":403,\"errmsg:\":\"token is null or packageName is null!}".length());
            out.write("{\"code\":403,\"errmsg\":\"token is null or packageName is null!\"}");
            out.flush();
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (out != null){
                out.close();
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 目标方法执行后调用
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
