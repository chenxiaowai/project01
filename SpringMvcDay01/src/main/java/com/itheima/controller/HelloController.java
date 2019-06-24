package com.itheima.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public  class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello SpringMvc");
        return "success";
    }


    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(path = "/testRequestMapping",method = {RequestMethod.GET},params = {"username=hello"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("testRequestMapping测试成功");
        return "success";
    }
}
