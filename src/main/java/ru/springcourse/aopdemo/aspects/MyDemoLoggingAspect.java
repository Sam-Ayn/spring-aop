package ru.springcourse.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.springcourse.aopdemo.Account;

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
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        System.out.println("Method: " + signature);
        Object[] args = joinPoint.getArgs();
        for (Object arg: args) {
            System.out.println(arg);
            if (arg instanceof Account)
                System.out.println("Name: " + ((Account) arg).getName() + " and level: "+ ((Account) arg).getLevel());

        }
    }
}
