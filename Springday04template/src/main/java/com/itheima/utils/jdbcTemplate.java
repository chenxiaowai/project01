package com.itheima.utils;

import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class jdbcTemplate {

    public static void main(String[] args) {
        //1.准备数据源，jdbc的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("root");


        //2.创建template对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);


        //3.执行操作
        List<Account>accounts = jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
