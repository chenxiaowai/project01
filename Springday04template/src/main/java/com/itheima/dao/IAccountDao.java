package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    List<Account> findAccount();

    Account findByAccountId(Integer accountId);

    Account findByAccountName(String accountName);
}
