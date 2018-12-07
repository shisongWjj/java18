package com.ss.design.pattern.creational.singleton;

/**
 * 懒汉式：注重延时加载，只有使用它的时候 才会加载，会存在线程安全，
 * //1.创建静态对象，赋值为null
 * //2.私有化构造器
 * //3.创建一个静态方法，判断，当对象为null时，创建对象
 *
 *
 * 改进一：所以要加同步锁 ==》性能低
 * synchronized 锁静态方法的时候，锁的是整个类， 锁 普通方法的时候，锁是在堆内存中生产的
 *
 * 改进二：双重检查模式 ==》 会存在重排序隐患
 * 1.分配内存给这个对象
 * 2.初始化对象
 * 3.设置lazyDoubleCheckSingleton 指向刚刚分配的内存地址。
 * 在java内有这样一个协议intra-thread semantics 保证重排序不会改变单线程内的程序执行结果。
 * 换句话说，intra-thread semantics 允许那些在单线程内，不会改变单线程程序执行结果的重排序
 * 即2，3可以互换位置
 * 所以 如果，当3优先执行的情况下，
 *      当线程1，执行到lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton() 3和2之间时
 *      线程2，执行到if(lazyDoubleCheckSingleton == null) ，这时的lazyDoubleCheckSingleton是不为空的，
 *          因为它已经指向了一个有地址值的对象，但是它其实是没有值的，那么 当它返回，并且用它来调用方法是，就会报异常
 *  这里有2两种解决方案
 *  方案一：不允许它重排序，即用volatile来修饰对象，使这个对象可见，所有线程都能实时的修改这个对象的值
 *      @see com.ss.design.pattern.creational.singleton.LazyDoubleCheckSingleton
 *  方案二：允许它重排序的情况下，那么肯定是当1,2，3都完成后，才能使另外一个线程执行if(lazyDoubleCheckSingleton == null)这个，基于类初始化的解决方案
 *  @see StaticInnerClassSingleton
 *      原理：jvm在类的初始化阶段，也就是class被加载后，并且被线程使用之前，都是类的初始化阶段，在这个阶段，会执行类的初始化。在执行类的初始化期间，jvm会去获取一个锁，这个锁能同步多个线程对一个类的初始化。基于这个特性，我们可以实现基于静态内部类的并且是线程安全的延迟初始化方案。
 *
 *
 *
 * 学习到的技能，多线程debug
 */
public class LazySingleton {

    //创建静态对象，赋值为null
    private static LazySingleton lazySingleton = null;

    //私有化构造器
    private LazySingleton() {
    }

    //创建一个静态方法，判断，当对象为null时，创建对象
    public synchronized static LazySingleton getInstatnce(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
