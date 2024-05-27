package com.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //@RequestMapping注解设置接收请求的路径，收到该路径的请求就执行下方的方法
    //方法必须无参、方法名随意、返回值为String：逻辑视图
    @RequestMapping("/index")
    public String toIndex(){
        System.out.println("访问到了IndexController的toIndex方法...");
        return "index";
    }
}
