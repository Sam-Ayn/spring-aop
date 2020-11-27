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
        accountDAO.addAccount(new Account("My Account", "Gold"), false);
        accountDAO.doWork();
        accountDAO.setName("DAO name");
        accountDAO.setServiceCode("code 1");
        accountDAO.getName();
        accountDAO.getServiceCode();
        System.out.println("\n let's call again");
        membershipDAO.addMember();
        membershipDAO.goSleep();
        context.close();
    }
}
