package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事物控制应该在业务层
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private TransactionManager txManger;


    public List<Account> findAllAccount() {
        try {
            //1.开启事物
            txManger.beginTransaction();
            //2.执行操作
            List<Account>accounts = accountDao.findAllAccount();
            //3.提交事物
            txManger.commit();
            //4.返回结果
            return accounts;

        } catch (Exception e) {
            //5.回滚操作
            txManger.rollback();
           throw new RuntimeException(e);

        }
        finally {
            //6.释放连接
            txManger.release();
        }
    }


    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }


    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }


    /**
     * 转账操作
     * @param sourceName        转出账户名称
     * @param targetName        转入账户名称
     * @param money             转账金额
     */
    public void transfer(String sourceName, String targetName, Float money) {

            //2执行操作
            //2.1.根据名称查询转出账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2.根据名称查询转入账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3.转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5.更新转出账户
            accountDao.updateAccount(source);

            int i =1/0;

            //2.6.更新转入账户
            accountDao.updateAccount(target);


    }
}
