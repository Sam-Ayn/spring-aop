package ru.springcourse.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.springcourse.aopdemo.dao.AccountDAO;
import ru.springcourse.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        accountDAO.addAccount(new Account(), false);
        accountDAO.doWork();
        System.out.println("\n let's call again");
        membershipDAO.addMember();
        membershipDAO.goSleep();
        context.close();
    }
}
