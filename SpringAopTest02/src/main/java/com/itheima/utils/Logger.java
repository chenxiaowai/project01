package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的类，里面提供了公共代码
 */
public class Logger {


    /**
     * 用于打印日志，计划让其在切入点之前执行
     */
    public void beforePrintLog() {

        System.out.println("前置通知开始记录日志了");
    }

    public void afterReturningPrintLog() {

        System.out.println("后置通知开始记录日志了");
    }

    public void afterThrowingPrintLog() {

        System.out.println("异常通知开始记录日志了");
    }

    public void afterPrintLog() {

        System.out.println("最终通知开始记录日志了");
    }

    /**
     * 环绕通知
     */
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
