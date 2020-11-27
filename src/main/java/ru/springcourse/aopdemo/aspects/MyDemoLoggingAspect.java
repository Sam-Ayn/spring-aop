package ru.springcourse.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* ru.springcourse.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* ru.springcourse.aopdemo.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("execution(* ru.springcourse.aopdemo.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    private void forDaoWithoutSettersAndGetters(){}

//    @Before("execution(public void ru.springcourse.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(public * add*())")
//    @Before("execution(public * add*(ru.springcourse.aopdemo.Account))")
//    @Before("execution(public * add*(ru.springcourse.aopdemo.Account, .. ))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* ru.springcourse.aopdemo.dao.*.*(..))")
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoWithoutSettersAndGetters()")
    public void performApiAnalytics(){
        System.out.println("\n=====>>> Performing API analytics");
    }

}
