package ru.springcourse.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

//    @Before("execution(public void ru.springcourse.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(public * add*())")
//    @Before("execution(public * add*(ru.springcourse.aopdemo.Account))")
//    @Before("execution(public * add*(ru.springcourse.aopdemo.Account, .. ))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* ru.springcourse.aopdemo.dao.*.*(..))")
    @Before("ru.springcourse.aopdemo.aspects.AopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
