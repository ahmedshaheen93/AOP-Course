package com.shaheen.aspect;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class BeforeAspect implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Method name = \t" + method.getName() + "\t" + Arrays.toString(objects));
    }
}
