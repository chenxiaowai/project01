package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class templateTest {



    @Test
    public void testQuery(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate  = ac.getBean("jdbcTemplate",JdbcTemplate.class);

        List<Account> accounts = jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));

        for (Account account : accounts) {
            System.out.println(account);
        }
    }


    @Test
    public void testQuery1(){
        //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate  = ac.getBean("jdbcTemplate",JdbcTemplate.class);

        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(accounts.isEmpty()?"没有数据":accounts.get(0));

    }
}
