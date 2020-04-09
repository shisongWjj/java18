package com.ss.design.watchBook.structural.strategy;

/**
 * IStrategy
 * 观设计模式之禅 后感 -- 策略模式
 *
 * 1.创建接口  策略接口
 * 2.让实际策略 实现接口内的方法
 * 3.创建一个辅助类 创建一个属性，主策略接口对象
 * 4。辅助类的有参构造 参数就是主策略接口对象
 * 5.辅助类的方法 内部调用的就是 主策略接口内的方法 也就是 子策略实现的方法
 * @author shisong
 * @date 2020/4/9
 */
public interface IStrategy {
}
