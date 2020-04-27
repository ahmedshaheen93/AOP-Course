package com.shaheen.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AbstractFactory implements InvocationHandler {
    private Object target;
    private GeneralAdvice advice = new GeneralAdvice();

    private AbstractFactory(Object target) {
        this.target = target;
    }

    public static Object getInstance(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new AbstractFactory(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            advice.before(args);
            result = method.invoke(target, args);
        } catch (Exception exception) {
            advice.afterThrowing(exception);
        }
        advice.after(result);

        return result;
    }
}
