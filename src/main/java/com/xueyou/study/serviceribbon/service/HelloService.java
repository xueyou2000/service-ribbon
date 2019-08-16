package com.xueyou.study.serviceribbon.service;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 创建 by xueyo on 2019/7/24
 */
@Service
public class HelloService {

    private final RestTemplate restTemplate;

    public HelloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sayHelloFallback(String id) {
        return "error";
    }

    // 启用缓存结果
    @CacheResult(cacheKeyMethod = "getCacheKey")
    // 服务降级，指定失败时走的方法
    @HystrixCommand(fallbackMethod = "sayHelloFallback", threadPoolProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    // @CacheKey 指定了缓存的key, 如果key相同则直接返回上一次返回的结果
    public String sayHello(@CacheKey("id") String id) {
        System.out.println("sayHello - id = " + id);
        long start = System.currentTimeMillis();
        String result = restTemplate.getForObject("http://CLIENT/home", String.class);
        long end = System.currentTimeMillis();
        System.out.println("调用时间 : " + (end - start));
        return  result;
    }

    // 清除缓存
    @CacheRemove(commandKey = "sayHello")
    @HystrixCommand
    public void clean() {
        System.out.println("清除缓存");
    }

    public String getCacheKey(String id) {
        System.out.println(" cache id = " + id);
        return id;
    }


}
