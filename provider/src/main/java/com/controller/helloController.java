package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class helloController {
    int i=0;

    @Value("${spring.application.name}")
    String name;

    @Value("${server.port}")
    String port;

    @GetMapping(value = "/get")
    public String get(){
        i++;
        return "get hello 提供服务："+name+" 端口号："+port+" 访问了"+i+" 次";
    }

    @PostMapping(value = "/post")
    public String post(){
        i++;
        return "post hello 提供服务："+name+" 端口号："+port+" 访问了"+i+" 次";
    }

    @GetMapping(value = "/reset")
    public String reset(){
        i=0;
        return "ok";
    }
}
