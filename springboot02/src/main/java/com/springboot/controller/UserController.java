package com.springboot.controller;

import com.springboot.pojo.User;
import com.springboot.service.UserService;
import com.springboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//处理前端发起的异步请求（前后端分离），所以需要该注解，处理和返回的都是Json
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public Result findAll(){
        //调用UserService查询所有的用户
        return Result.ok(userService.findAll());
    }


    @PostMapping("/save")
    //使用pojo入参和@RequestBody的区别：
    //pojo必须一个个的传参数，@RequestBody支持传递一个Json再自动解析成bean对象
    public Result save(@RequestBody  User user){
        userService.addUser(user);
        return Result.ok("create success");
    }
}
