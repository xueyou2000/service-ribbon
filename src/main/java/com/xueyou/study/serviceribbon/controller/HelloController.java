package com.xueyou.study.serviceribbon.controller;

import com.xueyou.study.serviceribbon.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建 by xueyo on 2019/7/24
 */
@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam String id) {
        System.out.println("第一次调用 " + helloService.sayHello(id));
        System.out.println("第二次调用 " + helloService.sayHello(id));
        System.out.println("第三次调用 " + helloService.sayHello("不易i杨"));
        System.out.println("第四次调用 " + helloService.sayHello(id));

        return helloService.sayHello(id);
    }

    @GetMapping("/clean")
    public void clean() {
        helloService.clean();
    }

}
