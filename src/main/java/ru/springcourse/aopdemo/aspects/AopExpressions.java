package ru.springcourse.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* ru.springcourse.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* ru.springcourse.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("execution(* ru.springcourse.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    public void forDaoWithoutSettersAndGetters(){}
}
