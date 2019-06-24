package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的类，里面提供了公共代码
 */

@Component("logger")
@Aspect//配置切面
//@ComponentScan("com.itheima")
//@EnableAspectJAutoProxy
public class Logger {
    @Pointcut(value ="execution(* com.itheima.service.impl.*.*(..))")
    public void pt1(){}

    /**
     * 用于打印日志，计划让其在切入点之前执行
     */
    //@Before("pt1()")
    public void beforePrintLog() {

        System.out.println("前置通知开始记录日志了");
    }

    //@AfterReturning("pt1()")
    public void afterReturningPrintLog() {

        System.out.println("后置通知开始记录日志了");
    }

    //@AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {

        System.out.println("异常通知开始记录日志了");
    }

    //@After("pt1()")
    public void afterPrintLog() {

        System.out.println("最终通知开始记录日志了");
    }

    /**
     * 环绕通知
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtvalue = null;
        try {

            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println("前置环绕通知开始记录日志了");
            rtvalue = pjp.proceed(args);//明确调用业务层方法
            System.out.println("后置环绕通知开始记录日志了");
            return rtvalue;
        } catch (Throwable e) {
            System.out.println("异常环绕通知开始记录日志了");
            throw new RuntimeException(e);
        } finally {
            System.out.println("最终环绕通知开始记录日志了");
        }
    }
}
