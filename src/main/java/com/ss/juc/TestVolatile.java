package com.ss.juc;

/**
 * 当多个线程访问共有变量时，由于jvm会给每个线程开辟一个独立的内存，当线程1访问共有变量 并且修改，重新同步到主存中时，线程2可能已经将共有变量拉取到自己的内存中，
 * 又由于while(true)的运行速度很快（都不需要重新到主存中拉取共有变量）。解决这种问题有多种方法，这里只列举2中
 * 1：synchronized 同步锁 会每次去读取内存中的值  但是效率非常低 有多个线程同时访问的时候  【如果有一个线程已经在读取了 那么其他线程都要挂起】（叫互斥性）
 * 2：volatile 关键字
 * <p>
 * volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。原理 底层代码 调用了 线程栅栏  ,不能重排序
 * <p>
 * 相较于 synchronized 是一种较为轻量级的同步策略
 * <p>
 * 注意：
 * 1.volatile 不具备 互斥性  一个线程进入 其他线程只能等待，这个现象叫做互斥性
 * 2.volatile 不能保证变量的原子性
 */
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo();
        new Thread(t1).start();

        while (true) {
            //可以用同步锁 会每次去读取内存中的值  但是效率非常低 有多个线程同时访问的时候  【如果有一个线程已经在读取了 那么其他线程都要挂起】（叫互斥性）
            synchronized (t1) {
                if (t1.isFlag()) {
                    System.out.println("------------------------------");
                    break;
                }
            }

        }

    }

}

class ThreadDemo implements Runnable {

    //private volatile boolean flag = false;
    private boolean flag = false;

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println("flag=" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
