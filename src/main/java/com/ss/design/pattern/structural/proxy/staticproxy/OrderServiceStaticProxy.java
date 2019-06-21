package com.ss.design.pattern.structural.proxy.staticproxy;

import com.ss.design.pattern.structural.proxy.IOrderService;
import com.ss.design.pattern.structural.proxy.Order;
import com.ss.design.pattern.structural.proxy.OrderServiceImpl;
import com.ss.design.pattern.structural.proxy.db.DataSourceContextHolder;

/**
 * OrderServiceStaticProxy
 *
 * @author shisong
 * @date 2019/1/17
 */
public class OrderServiceStaticProxy {

    private IOrderService orderService;

    public int saveOrder(Order order) {
        beforeMethod(order);
        orderService = new OrderServiceImpl();

        int i = orderService.saveOrder(order);

        afterMethod();
        return i;
    }

    public void beforeMethod(Order order) {
        System.out.println("静态代理 before code");

        Integer userId = order.getUserId();
        int dbRount = userId % 2;

        System.out.println("静态代理分配到【db" + dbRount + "】");
        DataSourceContextHolder.setDbtype(dbRount + "");
    }

    public void afterMethod() {
        System.out.println("静态代理 after code");
    }

}
