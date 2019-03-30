package com.lcydream.project.springwebmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DefaultDemoInterceptor
 *
 * @author Luo Chun Yun
 * @date 2018/11/23 15:09
 */
public class DefaultDemoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("handler : " + handler.toString());
        return true;
    }

}
