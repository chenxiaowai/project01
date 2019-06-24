package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {


    /**
     * 查询所有方法
     * @return
     */
    List<Account> findAll();


    /**
     * 保存用户方法
     * @param account
     */
    void saveAccount(Account account);
}
