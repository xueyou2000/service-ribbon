package com.xueyou.study.serviceribbon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 创建 by xueyo on 2019/8/14
 */
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    private final HystrixInterceptor hystrixInterceptor;
//
//    public WebConfig(HystrixInterceptor hystrixInterceptor) {
//        this.hystrixInterceptor = hystrixInterceptor;
//    }
//
//    // 配置拦截器
//    public void addInterceptors(InterceptorRegistry registry) {
//        System.out.println("配置拦截器==================");
//        registry.addInterceptor(hystrixInterceptor).addPathPatterns("/**");
//    }
//
//
//
//}
