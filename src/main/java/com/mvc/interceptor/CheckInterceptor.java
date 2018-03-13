package com.mvc.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 检查接口通用参数
 */
public class CheckInterceptor extends HandlerInterceptorAdapter {
    public CheckInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String _source = request.getParameter("_source");
        if(_source == null ){
            return false;
        }else{return  true;}
    }
}
