package cn.itcast.test;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTest {


    @Test
    public void testSpring(){
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext");
        AccountService as = ac.getBean("accountService", AccountService.class);
         List<Account> accounts = as.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
