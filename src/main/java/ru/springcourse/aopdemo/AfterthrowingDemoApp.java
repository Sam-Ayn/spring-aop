package ru.springcourse.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.springcourse.aopdemo.dao.AccountDAO;

import java.util.List;

public class AfterthrowingDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
            System.out.println("\n\n Main program - after throwing demo app");
        } catch (Exception e){
            System.out.println("\n\nMain program ... caught exception: " + e);
        }
        System.out.println(accounts);
        System.out.println("\n");
        context.close();
    }
}
