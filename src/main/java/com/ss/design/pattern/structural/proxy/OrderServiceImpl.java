package com.ss.design.pattern.structural.proxy;

/**
 * OrderServiceImpl
 *
 * @author shisong
 * @date 2019/1/17
 */
public class OrderServiceImpl implements IOrderService{

    private IOrderDao orderDao;

    @Override
    public int saveOrder(Order order) {
        orderDao = new OrderDaoImpl();
        System.out.println("Service层调用Dao层添加Order");
        return orderDao.insert(order);
    }
}
