package com.shaheen;

import com.shaheen.service.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Calculator calculator = (Calculator) applicationContext.getBean("calculatorProxy");
        calculator.add(5d, 6d);
        calculator.sub(5d, 6d);
        calculator.mul(5d, 6d);
        try {
            calculator.div(5d, 0d);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Calculator calculator2 = (Calculator) applicationContext.getBean("calculatorProxy2");
        calculator2.add(5d, 6d);
        calculator2.sub(5d, 6d);
        calculator2.mul(5d, 6d);
        try {
            calculator2.div(5d, 0d);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Calculator calcuator3 = (Calculator) applicationContext.getBean("calc2");

        calcuator3.add(5d, 6d);
        calcuator3.sub(5d, 6d);
        calcuator3.mul(5d, 6d);
        try {
            calcuator3.div(5d, 0d);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Calculator calcuator4 = (Calculator) applicationContext.getBean("calc3");
        calcuator4.add(5d, 6d);
        calcuator4.sub(5d, 6d);
        calcuator4.mul(5d, 6d);
        try {
            calcuator4.div(5d, 0d);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
