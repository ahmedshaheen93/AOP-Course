package com.shaheen;

import com.shaheen.config.AppConfig;
import com.shaheen.service.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculator calculator = (Calculator) context.getBean("calculator");
        calculator.add(5d, 6d);
        calculator.sub(5d, 6d);
        calculator.mul(5d, 6d);
        try {
            calculator.div(5d, 0d);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
