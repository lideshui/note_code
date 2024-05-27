package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBoot启动器，声明这是一个SpringBoot应用程序
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //传入当前类的字节码对象和args命令行参数这两个参数
        SpringApplication.run(Application.class,args);
    }
}
