package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.domain.Person;
import com.itheima.domain.Student;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 基本参数绑定
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("testParam")
    public String testParam(String username,String password){
        System.out.println("执行了...");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    /**
     * 将数据封装成javaBean对象
     * 需要解决中文乱码问题，MVC框架中在web.xml文件中配置filter过滤器标签，设置初始参数name是encoding
     * value值是utf-8
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("saveAccount")
    public String saveAccount( Account account)  {

        System.out.println("执行了...");
        System.out.println(account);
        return "success";
    }

    /**
     * 将数据封装到list集合和map集合中
     * @param person
     * @return
     */
    @RequestMapping("testListAndMap")
    public String testListAndMap(Person person)  {

        System.out.println("执行了...");
        System.out.println(person);
        return "success";

        //Person{pname='哈哈', page=11, list=[Account{username='嘿嘿', age=100, money=22.0, user=User{uname='莎莎', uage=33, address='北京'}}], map={user=User{uname='兰兰', uage=44, address='南京'}}}
    }


    /**
     * 自定义类型转化器
     * @param student
     * @return
     */
    @RequestMapping("saveStudent")
    public String saveStudent(Student student)  {

        System.out.println("执行了...");
        System.out.println(student);
        return "success";
    }
}
