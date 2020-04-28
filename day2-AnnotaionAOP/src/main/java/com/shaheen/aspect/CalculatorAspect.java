package com.shaheen.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(0)
@Component
public class CalculatorAspect {
    @Pointcut(value = "execution(* com.shaheen.service.Calculator.*(..))")
    public void calculatorPointCuts() {
    }

    @Before(value = "calculatorPointCuts()")
    public void before(JoinPoint joinPoint) {
        System.out.println(getClass());
        System.out.println("Method name = \t" + joinPoint.getSignature().getName() + "\t"
                + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "result",
            value = "calculatorPointCuts()")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println(getClass());
        System.out.println("result = " + result);
    }

    @AfterThrowing(throwing = "exception", value = "calculatorPointCuts()")
    public void afterThrowing(Exception exception) {
        System.out.println(getClass());
        System.out.println(exception.getMessage());
    }
}
