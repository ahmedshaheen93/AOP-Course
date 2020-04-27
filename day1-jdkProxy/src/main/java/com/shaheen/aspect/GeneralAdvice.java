package com.shaheen.aspect;

public class GeneralAdvice {

    public void before(Object[] args) {
        for (Object arg : args) {
            System.out.println(arg);
        }
    }

    public void after(Object result) {
        System.out.println("result =" + "\t" + result);
    }

    public void afterThrowing(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
