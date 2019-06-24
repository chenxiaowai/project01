package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层接口
 */
@Repository
public interface AccountDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    List<Account>findAll();


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
