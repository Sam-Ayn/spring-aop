package ru.springcourse.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.springcourse.aopdemo.dao.AccountDAO;
import ru.springcourse.aopdemo.dao.MembershipDAO;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = accountDAO.findAccounts();
        System.out.println("\n\n Main program - after returning demo app");
        System.out.println(accounts);
        System.out.println("\n");
        context.close();
    }
}
