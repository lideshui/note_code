package com.spring.pojo;

public class HelloWorld {
    private String name;

    public HelloWorld() {
    }

    public HelloWorld(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello，My Name Is " + this.name);
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "name='" + name + '\'' +
                '}';
    }
}
