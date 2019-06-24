package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {

    @RequestMapping(value = "/hello")
    public String sayHello(){
        System.out.println("springMvc.....");
        return "success";
    }
}
