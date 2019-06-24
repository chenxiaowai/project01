package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 账户的持久层接口实现类
 *
 * 继承了JdbcDaoSupport，可以自己创建一个jdbcTemplate，不支持注解 开发，支持xml文件开发
 */
public class AccountDaoImpl2 extends JdbcDaoSupport implements IAccountDao {



    /**
     * 查询所有
     * @return
     */
    public List<Account> findAccount() {
        return getJdbcTemplate().query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    /**
     * 根据id查询用户
     * @return
     */
    public Account findByAccountId(Integer accountId) {
        Account account =  getJdbcTemplate().queryForObject("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return account;
    }

    /**
     * 根据用户名查询
     * @return
     */
    public Account findByAccountName(String accountName) {

       List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),accountName);

       if (accounts.isEmpty()) {
            return null;
       }
       if (accounts.size()>1){
           throw new RuntimeException("结果集不为1");
       }
       return accounts.get(0);
    }
}
