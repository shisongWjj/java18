package com.ss.juc;

//生成者 消费者问题  synchronized

/**
 * 没有等待唤醒机制之前，我们可以看到，当进货时，已显示仓库已满，但是仍被要求进货，相反 当无货时，一直被要求卖货，其实是一种不合理的情况
 * 我们需要，当提示仓库已满时，就不再继续进货，反之，当无货时，不再被要求卖货。
 * 所以我们就用到了等待唤醒机制，当仓库已满或者无货时，让线程处于等待状态，并且进货或者卖出货物时，唤醒其他线程。
 *
 * 然而 当我们将最大进货数变为1时，并且生产者生产时，睡200毫秒（网络通信中很正常），就会发现程序一直在运行，不能停止
 * 这是因为生产者最后一次进入等待的时候，没有其他线程进行唤醒操作。
 *
 * 所以 我们需要把else里的提取出来。同理消费者也应该一样
 *
 * 然而 当我们开启多条生产者或消费者 线程时，发现 居然出现了负数 .这是一种虚假唤醒
 *
 *
 * 对于某一个参数的版本，实现中断和虚假唤醒是可能的，而且此方法应始终在循环中使用：
 * synchronized (obj) {
 while (<condition does not hold>)
 obj.wait();
 ... // Perform action appropriate to condition
 }
    只需要将if改为while即可
 */
public class TestProductorAndConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor p1 = new Productor(clerk);
        Consumer c1 = new Consumer(clerk);

        new Thread(p1,"生产者A").start();
        new Thread(c1,"消费者B").start();
        new Thread(p1,"生产者C").start();
        new Thread(c1,"消费者D").start();
    }
}

/*class Clerk{
    private Integer product = 0;

    //进货
    public synchronized void get(){
        while(product>=1){
            System.out.println(Thread.currentThread().getName()+":仓库已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }*//*else{
            System.out.println(Thread.currentThread().getName()+":" + ++product);
            this.notifyAll();
        }*//*
        System.out.println(Thread.currentThread().getName()+":" + ++product);
        this.notifyAll();
    }

    //卖货
    public synchronized void sale(){
        while(product<=0){
            System.out.println(Thread.currentThread().getName()+":仓库无货");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }*//*else{
            System.out.println(Thread.currentThread().getName()+":" + --product);
            this.notifyAll();
        }*//*
        System.out.println(Thread.currentThread().getName()+":" + --product);
        this.notifyAll();
    }
}

//生成者
class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for(int i = 0;i<20;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            clerk.get();
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for(int i = 0;i<20;i++){
            clerk.sale();
        }

    }
}*/
