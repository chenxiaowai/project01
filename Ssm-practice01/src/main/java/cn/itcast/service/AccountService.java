package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();


    /**
     * 添加方法
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 根据id查询账户
     * @param AccountId
     * @return
     */
    Account findByAccountId(Integer AccountId);

    /**
     * 根据名字进行模糊查询
     * @param AccountName
     * @return
     */
    List<Account>findByAccountName(String AccountName);

    /**
     * 根据id删除用户
     * @param AccountId
     */
    void deleteAccount(Integer AccountId);

}
