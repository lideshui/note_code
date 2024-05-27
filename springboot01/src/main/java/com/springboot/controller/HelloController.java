package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//该注解是@RequestBody和@Controller的组合版
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "hello spring boot!!" ;
    }
}