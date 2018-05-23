package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YukunGeng on 2018/5/12.
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello,this is a springboot demo";
    }
}
