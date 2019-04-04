package com.ss.juc;

import org.apache.commons.collections.CollectionUtils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * concurrentHashMap:
 *          hashMap：性能高，线程不安全；
 *          hashTable:线程安全，性能低 ，底层都是用synchronized修饰（串行） 但是这边的线程安全也是相对的，如果做复合操作，其实也是存在线程安全的。
 *          复合操作:若存在则删除；若不存在则添加 这类的就是复合操作。
 *          concurrentHashMap：采用分段锁机制，是并行的  1.8  concurrentHashMap 取消了分段锁
 *
 * CopyOnWriteArrayList:复制并写入list  支持并发操作 每一次操作  在底层 都会先copy一个新的list 所以不会发生java.util.ConcurrentModificationException 错误
 *          由于每次都是copy一个新的  性能可想而知 肯定非常低，内存开销很大
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        CopyOnWriterArrayDemo c1 = new CopyOnWriterArrayDemo();
        for(int i = 0;i <10 ; i++){
            new Thread(c1).start();
        }
    }

}



class CopyOnWriterArrayDemo implements Runnable{

    //private static List<String> list = new ArrayList<>();//java.util.ConcurrentModificationException
    //private static List<String> list = CollectionUtils.synchronizedCollection(new ArrayList<String>());//失败
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();

    static{
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }


    @Override
    public void run() {

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

            //list.add("AA");
            list.remove("AA");
        }
    }
}
