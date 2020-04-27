package com.shaheen.aspect;

public class CalculatorAdvice {

    public void before(double firstNum, String operator, double secondNum) {
        System.out.println(firstNum + "\t" + operator + "\t" + secondNum);
    }

    public void after(double result) {
        System.out.println("result =" + "\t" + result);
    }

    public void afterThrowing(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
