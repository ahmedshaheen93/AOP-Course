package com.shaheen.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(1)
@Component
public class CalculatorAdvice {
    @Around("com.shaheen.aspect.CalculatorAspect.calculatorPointCuts()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // before advice
        System.out.println(getClass());
        System.out.println("Method name = \t" + joinPoint.getSignature().getName() + "\t"
                + Arrays.toString(joinPoint.getArgs()));
        Object result = null;
        try {
            // proceed method Or not depend on need
            result = joinPoint.proceed(joinPoint.getArgs());
        } catch (Exception exception) {
            //AfterThrowing
            System.out.println(exception.getMessage());
        }
        // after returning
        System.out.println("result = " + result);
        return result;
    }
}
