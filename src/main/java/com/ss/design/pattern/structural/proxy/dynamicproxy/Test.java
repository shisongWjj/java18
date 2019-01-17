package com.ss.design.pattern.structural.proxy.dynamicproxy;

import com.ss.design.pattern.structural.proxy.IOrderService;
import com.ss.design.pattern.structural.proxy.Order;
import com.ss.design.pattern.structural.proxy.OrderServiceImpl;

/**
 * Test
 *
 * @author shisong
 * @date 2019/1/18
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        IOrderService orderServicedynamicProxy = (IOrderService)new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderServicedynamicProxy.saveOrder(order);
    }
}
