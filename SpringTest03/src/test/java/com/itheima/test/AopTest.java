package com.itheima.test;

import com.itheima.service.IAccountService;
import com.itheima.utils.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {

        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //ApplicationContext ac = new AnnotationConfigApplicationContext(Logger.class,IAccountService.class);
        //2.获取对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();
        //as.updateAccount(1);
        //as.deleteAccount();
    }
}
