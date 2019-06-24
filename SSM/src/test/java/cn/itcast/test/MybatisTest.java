package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
//@SuppressWarnings("all")
public class MybatisTest {


    /**
     * 查询
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        sqlSession.close();
        in.close();
    }


        /**
         * 添加
         */
        @Test
        public void testSaveAccount() throws Exception {
            Account account = new Account();
            account.setName("小兰");
            account.setMoney(300d);
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            SqlSession sqlSession = factory.openSession();
            AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
            accountDao.saveAccount(account);
            sqlSession.commit();
            sqlSession.close();
            in.close();
            }
    }

