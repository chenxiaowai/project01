package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class templateTest3 {



    @Test
    public void testQuery(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao  = ac.getBean("accountDao", IAccountDao.class);

        List<Account> accounts = accountDao.findAccount();

        for (Account account : accounts) {
            System.out.println(account);
        }
    }


    @Test
    public void testQuery1(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao  = ac.getBean("accountDao", IAccountDao.class);

        Account account = accountDao.findByAccountId(1);
        System.out.println(account);

    }

    @Test
    public void testFindByAccountName(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao  = ac.getBean("accountDao", IAccountDao.class);

        //3.执行方法
         Account account = accountDao.findByAccountName("aaa");

        System.out.println(account);

    }
}
