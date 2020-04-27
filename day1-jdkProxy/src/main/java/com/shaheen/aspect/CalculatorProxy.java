package com.shaheen.aspect;

import com.shaheen.service.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorProxy implements InvocationHandler {
    Calculator calculator;
    CalculatorAdvice calculatorAdvice;

    public CalculatorProxy(Calculator calculator, CalculatorAdvice calculatorAdvice) {
        this.calculator = calculator;
        this.calculatorAdvice = calculatorAdvice;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Double result = 0d;
        Double firstNum = (Double) args[0];
        Double secondNum = (Double) args[1];
        try {
            switch (method.getName()) {
                case "add":
                    calculatorAdvice.before(firstNum, "+", secondNum);
                    result = (Double) method.invoke(calculator, args);
                    break;
                case "sub":
                    calculatorAdvice.before(firstNum, "-", secondNum);
                    result = (Double) method.invoke(calculator, args);
                    break;
                case "mul":
                    calculatorAdvice.before(firstNum, "*", secondNum);
                    result = (Double) method.invoke(calculator, args);
                    break;
                case "div":
                    try {
                        calculatorAdvice.before(firstNum, "/", secondNum);
                        result = (Double) method.invoke(calculator, args);
                        break;
                    } catch (Exception exception) {
                        calculatorAdvice.afterThrowing(exception);
                    }

            }

            calculatorAdvice.after(result);

        } catch (Exception exception) {
            exception.printStackTrace();

        }
        return null;
    }
}
