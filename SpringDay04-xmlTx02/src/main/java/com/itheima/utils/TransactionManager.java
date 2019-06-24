package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

import java.sql.Connection;
import java.sql.SQLException;

@Component("txManger")
@Aspect
public class TransactionManager {
    /**
     * 和事物管理相关的工具类，它包含了，开启事物，提交事物，回滚事物和释放连接
     */
    @Autowired
    private ConnectionUtils connectionUtils;


    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 开启事物
     */
    //@Before("pt1()")
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事物
     */
    //@AfterReturning("pt1()")
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事物
     */
   // @AfterThrowing("pt1()")
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    //@After("pt1()")
    public void release(){
        try {
            //关闭连接
            connectionUtils.getThreadConnection().close();
            //还回连接池
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 环绕通知
     * @return
     */
   @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtvalue = null;

        try {
            //1.获取参数
             Object[] args = pjp.getArgs();
            //2.开启事物
            this.beginTransaction();
            //3.执行方法
            rtvalue = pjp.proceed(args);
            //4.提交事物
            this.commit();
            //4.返回结果
            return rtvalue;

        }catch (Throwable t){
            //5.回滚操作
            this.rollback();
            throw new RuntimeException(t);
        }finally {
            //释放资源
            this.release();
        }

    }
}
