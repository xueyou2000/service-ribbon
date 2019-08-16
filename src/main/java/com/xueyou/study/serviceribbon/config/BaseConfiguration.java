package com.xueyou.study.serviceribbon.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 创建 by xueyo on 2019/7/24
 */
@Configuration
public class BaseConfiguration {

    /**
     * 注入restTemplate
     * LoadBalanced注解 开启负载均衡的功能
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public FilterRegistrationBean<HystrixRequestContextServletFilter> someFilterRegistration1() {
        //新建过滤器注册类
        FilterRegistrationBean<HystrixRequestContextServletFilter> registration = new FilterRegistrationBean<>();
        // 添加我们写好的过滤器
        registration.setFilter(new HystrixRequestContextServletFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        return registration;
    }

}
