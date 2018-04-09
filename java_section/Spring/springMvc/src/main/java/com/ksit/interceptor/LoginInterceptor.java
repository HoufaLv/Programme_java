package com.ksit.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 开发自己的拦截器
 * @author Lvhoufa
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * 前置拦截器方法
     * @param request
     * @param response
     * @param handler       这个参数没什么用,暂时不用理解
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //String requestURI = request.getRequestURI();
        System.out.println("LoginInterceptor.preHandle" + System.currentTimeMillis());
        return true;
    }


    /**
     * 后置拦截器方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor.postHandle" + System.currentTimeMillis());
    }


    /**
     * 完成拦截器方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor.afterCompletion" + System.currentTimeMillis());
    }
}
