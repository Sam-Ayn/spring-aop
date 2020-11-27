package ru.springcourse.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember(){
        System.out.println(getClass() + ": Doing db work: Adding membership");
        return true;
    }

    public boolean goSleep(){
        System.out.println(getClass() + ": Going to sleep");
        return true;
    }
}
