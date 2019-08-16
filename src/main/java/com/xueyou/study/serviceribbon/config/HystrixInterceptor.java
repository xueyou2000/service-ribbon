package com.xueyou.study.serviceribbon.config;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建 by xueyo on 2019/8/14
 */
@Component
public class HystrixInterceptor implements HandlerInterceptor {

    private Integer i = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行控制器之前执行拦截器");

        if (i == 0) {
            HystrixRequestContext.initializeContext();
            //return true;
            i++;
        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("执行控制器之后执行拦截器");
        //HystrixRequestContext.initializeContext();
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        System.out.println("前端控制器之后执行拦截器");
    }

}
