package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 账户的持久层接口实现类
 */
public class AccountDaoImpl implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

    /**
     * jdbcTemplate的set注入
     * @param jdbcTemplate
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询所有
     * @return
     */
    public List<Account> findAccount() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    /**
     * 根据id查询用户
     * @return
     */
    public Account findByAccountId(Integer accountId) {
        Account account =  jdbcTemplate.queryForObject("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return account;
    }

    /**
     * 根据用户名查询
     * @return
     */
    public Account findByAccountName(String accountName) {

       List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);

       if (accounts.isEmpty()) {
            return null;
       }
       if (accounts.size()>1){
           throw new RuntimeException("结果集不为1");
       }
       return accounts.get(0);
    }
}
