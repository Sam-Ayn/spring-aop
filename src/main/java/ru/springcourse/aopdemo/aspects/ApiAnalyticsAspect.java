package ru.springcourse.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {
    @Before("ru.springcourse.aopdemo.aspects.AopExpressions.forDaoWithoutSettersAndGetters()")
    public void performApiAnalytics(){
        System.out.println("\n=====>>> Performing API analytics");
    }
}
