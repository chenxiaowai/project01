package com.itheima.test;

import com.itheima.dao.ItemsDao;
import com.itheima.domain.Items;
import com.itheima.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsTest {

    /**
     * 测试dao层
     */
    @Test
    public void testFindByIdDao() {
        //1.获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取代理对象
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
        //3.调用对象中的方法
         Items items = itemsDao.findById(1);
        System.out.println(items.getName());
    }


    /**
     * 测试service层
     */
    @Test
    public void testFindByIdService() {
        //1.获取spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取代理对象
        ItemsService itemsService = ac.getBean(ItemsService.class);
        //3.调用对象中的方法
        Items items = itemsService.findById(1);
        System.out.println(items.getName());
    }
}
