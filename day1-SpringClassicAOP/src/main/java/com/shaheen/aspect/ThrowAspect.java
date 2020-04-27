package com.shaheen.aspect;

import org.springframework.aop.ThrowsAdvice;

public class ThrowAspect implements ThrowsAdvice {
    public void afterThrowing(Exception exception) throws Throwable {
        System.out.println(exception.getMessage());
    }
}
