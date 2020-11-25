package ru.springcourse.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.springcourse.aopdemo.dao.AccountDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();
        System.out.println("\n let's call again");
        accountDAO.addAccount();
        context.close();
    }
}
