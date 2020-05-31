package com.ss.juc.gupao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLockDemo
 *
 * @author shisong
 * @date 2020-05-30
 */
public class ReentrantReadWriteLockDemo {

    /**
     * 缓存MAP
     */
    static Map<String,Object> cacheMap = new HashMap<>();

    /**
     * 读写锁
     */
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    /**
     * 从读写锁中 获取读锁
     */
    static ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();
    /**
     * 从读写锁中 获取写锁
     */
    static ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();

    public static void main(String[] args){

        new Thread(()->{
            try {
                ReentrantReadWriteLockDemo.put("123","dddd");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                ReentrantReadWriteLockDemo.get("123");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                ReentrantReadWriteLockDemo.get("123");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    static Object get(String key) throws InterruptedException {
        System.out.println("get start.........");
        readLock.lock();
        try {
            Thread.sleep(1000l);
            System.out.println("get.........");
            return cacheMap.get(key);
        }finally {
            readLock.unlock();
        }
    }

    static Object put(String key,Object value) throws InterruptedException{
        System.out.println("put start.........");
        writeLock.lock();
        try {
            Thread.sleep(1000l);
            System.out.println("put.........");
            return cacheMap.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }
}
