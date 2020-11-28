package ru.springcourse.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneService {

    public String getFortune(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect heavi traffic this morning";
    }
    public String getFortune(boolean tripWire){
        if (tripWire) throw new RuntimeException("Major accident! Highway is closed");
        return getFortune();
    }
}
