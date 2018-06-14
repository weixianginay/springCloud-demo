package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "fbn-provider-dev1")
public interface FeignDemoClient {
//url = "http://localhost:8080/thirdApi"

    @GetMapping(value = "/hello/get")
    String get();

    @PostMapping(value = "/hello/post")
    String post();


}
