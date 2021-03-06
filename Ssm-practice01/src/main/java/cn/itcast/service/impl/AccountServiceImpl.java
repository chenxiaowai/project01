package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层接口的实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层实现类。。。");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public Account findByAccountId(Integer AccountId) {
        return null;
    }

    @Override
    public List<Account> findByAccountName(String AccountName) {
        return null;
    }

    @Override
    public void deleteAccount(Integer AccountId) {

    }
}
