package com.ss.jvm.test2;

/**
 * JConsoleDeadLockTest
 *
 * @author shisong
 * @date 2019/1/31
 */
public class JConsoleDeadLockTest {

    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(new DeadLock(o1,o2)).start();
        new Thread(new DeadLock(o2,o1)).start();

    }

}

class DeadLock implements Runnable{

    private Object o1;
    private Object o2;

    public DeadLock(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("hello");
            }
        }
    }
}
