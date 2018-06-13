package com.controller;

import com.example.demo.FeignDemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class Controller {

    @Autowired
    FeignDemoClient client;

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String get(){

        String result=" 服务访问了 fbn-provider-dev1 ！ 获取到的结果"+client.get();
        return result;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String post(){
        String result=" 服务访问了 fbn-provider-dev1 ！ 获取到的结果"+client.get();
        return result;
    }
}
