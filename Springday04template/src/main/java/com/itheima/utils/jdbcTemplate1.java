package com.itheima.utils;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class jdbcTemplate1 {

    public static void main(String[] args) {
     //1.获取容器
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jdbcTemplate  = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //jdbcTemplate.execute("insert into account(name,money) values('ddd',1000)");

        //3.查询方法
         List<Account> accounts = jdbcTemplate.query("select * from user ", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accounts) {
            System.out.println(account);
        }


    }
}
