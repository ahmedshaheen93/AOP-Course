package com.shaheen.aspect;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterAspect implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object result, Method method, Object[] args, Object traget) throws Throwable {
        System.out.println("result = " + result);
    }
}
