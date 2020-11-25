package ru.springcourse.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(){
        System.out.println(getClass() + ": Doing db work: Adding account");
    }
}
