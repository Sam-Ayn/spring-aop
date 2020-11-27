package ru.springcourse.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {

    @Before("ru.springcourse.aopdemo.aspects.AopExpressions.forDaoWithoutSettersAndGetters()")
    public void logToCloudAsync(){
        System.out.println("\n=====>>> Logging to cloud");
    }

}
