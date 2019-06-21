package com.ss.design.pattern.structural.proxy;

/**
 * OrderDaoImpl
 *
 * @author shisong
 * @date 2019/1/17
 */
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }
}
