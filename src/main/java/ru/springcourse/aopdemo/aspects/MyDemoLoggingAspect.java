package ru.springcourse.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.springcourse.aopdemo.Account;

import java.util.List;

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

    @AfterReturning(
            pointcut = "execution(* ru.springcourse.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method: " + method);
        System.out.println("\n====>>> result is " + result);
        convertAccountNamesToUpperCase(result);
        System.out.println("\n====>>> result is " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account:result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @AfterThrowing(
    pointcut = "execution(* ru.springcourse.aopdemo.dao.AccountDAO.findAccounts(..))",
    throwing = "exception")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, Throwable exception){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterThrowing on method: " + method);
        System.out.println("\n====>>> exception is " + exception);
    }
}
