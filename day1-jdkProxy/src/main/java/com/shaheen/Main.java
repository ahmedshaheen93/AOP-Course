package com.shaheen;

import com.shaheen.aspect.AbstractFactory;
import com.shaheen.aspect.CalculatorFactory;
import com.shaheen.service.Calculator;
import com.shaheen.service.CalculatorImpl;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = CalculatorFactory.getInstance().getTargetWithAdvice();
        calculator.add(5d, 6d);
        calculator.sub(5d, 6d);
        calculator.mul(5d, 6d);
        calculator.div(5d, 0d);

        Calculator calculator2 = (Calculator) AbstractFactory.getInstance(new CalculatorImpl());
        calculator2.add(5d, 6d);
        calculator2.sub(5d, 6d);
        calculator2.mul(5d, 6d);
        calculator2.div(5d, 0d);
    }
}
