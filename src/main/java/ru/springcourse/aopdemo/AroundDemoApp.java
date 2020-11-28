package ru.springcourse.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.springcourse.aopdemo.service.TrafficFortuneService;

import java.util.logging.Logger;

public class AroundDemoApp {
    private static final Logger logger =
            Logger.getLogger(AroundDemoApp.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService service =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);
        logger.info("\nMain program: Around demo app");
        logger.info("Calling getFortune");
        boolean tripWire = true;
        String data = service.getFortune(tripWire);
        logger.info("\nMy fortune is: " + data);
        logger.info("Finished");
        context.close();
    }
}
