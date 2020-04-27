package com.shaheen.service;

public class CalculatorImpl implements Calculator {
    public CalculatorImpl() {
        System.out.println("init CalculatorImpl");
    }

    public Double add(Double num1, Double num2) {
        return num1 + num2;
    }

    public Double sub(Double num1, Double num2) {
        return num1 - num2;
    }

    public Double div(Double num1, Double num2) throws RuntimeException {
        if (num2 == 0) {
            throw new RuntimeException("cant div by zero");
        }
        return num1 / num2;
    }

    public Double mul(Double num1, Double num2) {
        return num1 * num2;
    }
}
