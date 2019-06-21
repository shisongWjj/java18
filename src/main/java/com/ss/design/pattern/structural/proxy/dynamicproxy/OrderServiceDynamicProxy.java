package com.ss.design.pattern.structural.proxy.dynamicproxy;

import com.ss.design.pattern.structural.proxy.Order;
import com.ss.design.pattern.structural.proxy.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * OrderServiceDynamicProxy 实现动态代理
 *
 * @author shisong
 * @date 2019/1/18
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object bind() {
        Class<?> aClass = target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object orderObject = args[0];
        beforeMethod(orderObject);
        Object invoke = method.invoke(target, args);
        afterMethod();
        return invoke;
    }

    public void beforeMethod(Object object) {
        System.out.println("动态代理 before code");
        Integer userId = 0;
        if (object instanceof Order) {
            Order order = (Order) object;
            userId = order.getUserId();
        }

        int dbRount = userId % 2;

        System.out.println("动态代理分配到【db" + dbRount + "】");
        DataSourceContextHolder.setDbtype(dbRount + "");
    }

    public void afterMethod() {
        System.out.println("动态代理 after code");
    }
}
