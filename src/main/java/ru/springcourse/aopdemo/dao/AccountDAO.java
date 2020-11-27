package ru.springcourse.aopdemo.dao;

import org.springframework.stereotype.Component;
import ru.springcourse.aopdemo.Account;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + ": Doing db work: Adding account");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": Doing some work");
        return true;
    }
}
