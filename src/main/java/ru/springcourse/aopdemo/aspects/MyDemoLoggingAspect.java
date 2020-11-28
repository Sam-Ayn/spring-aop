package ru.springcourse.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.springcourse.aopdemo.Account;
import ru.springcourse.aopdemo.AroundDemoApp;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private static final Logger logger =
            Logger.getLogger(MyDemoLoggingAspect.class.getName());

    //    @Before("execution(public void ru.springcourse.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(public * add*())")
//    @Before("execution(public * add*(ru.springcourse.aopdemo.Account))")
//    @Before("execution(public * add*(ru.springcourse.aopdemo.Account, .. ))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* ru.springcourse.aopdemo.dao.*.*(..))")
    @Before("ru.springcourse.aopdemo.aspects.AopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("\n=====>>> Executing @Before advice on addAccount()");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: " + signature);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info(arg.toString());
            if (arg instanceof Account)
                logger.info("Name: " + ((Account) arg).getName() + " and level: " + ((Account) arg).getLevel());

        }
    }

    @AfterReturning(
            pointcut = "execution(* ru.springcourse.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @AfterReturning on method: " + method);
        logger.info("\n====>>> result is " + result);
        convertAccountNamesToUpperCase(result);
        logger.info("\n====>>> result is " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @AfterThrowing(
            pointcut = "execution(* ru.springcourse.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @AfterThrowing on method: " + method);
        logger.info("\n====>>> exception is " + exception);
    }

    @After("execution(* ru.springcourse.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @After on method: " + method);
    }

    @Around("execution(* ru.springcourse.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @Around on method: " + method);
        long begin = System.currentTimeMillis();
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            result = "Major accident! But no worries," +
                    " your private AOP helicopter is on the way!";
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        logger.info("\n====>>> Duration: " + duration / 1000.0 + " seconds");
        return result;
    }
}
