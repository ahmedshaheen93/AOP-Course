package com.shaheen.aspect;

import com.shaheen.service.Calculator;
import com.shaheen.service.CalculatorImpl;

import java.lang.reflect.Proxy;
import java.util.Objects;

public class CalculatorFactory {
    private static CalculatorFactory instance;
    private final Calculator target;
    private final Calculator targetWithAdvice;

    private CalculatorFactory() {
        System.out.println("init CalculatorFactory");
        target = new CalculatorImpl();
        CalculatorAdvice calculatorAdvice = new CalculatorAdvice();
        CalculatorProxy calculatorProxy = new CalculatorProxy(target, calculatorAdvice);
        Class<?>[] interfaces = new Class[]{Calculator.class};

        targetWithAdvice = (Calculator) Proxy.newProxyInstance(new ClassLoader() {
        }, interfaces, calculatorProxy);
    }

    public static CalculatorFactory getInstance() {
        instance = Objects.requireNonNullElseGet(instance, CalculatorFactory::new);
        return instance;
    }

    public Calculator getTargetWithAdvice() {
        return targetWithAdvice;
    }
}
