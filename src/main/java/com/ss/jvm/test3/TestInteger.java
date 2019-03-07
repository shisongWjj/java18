package com.ss.jvm.test3;

/**
 * TestInteger
 *
 * @author shisong
 * @date 2019/1/25
 */
public class TestInteger {

    public static void main(String[] args) {

        /**
         Integer i1 = 127 就是 Integer i1 = Integer.valueOf(127);
         关于i1==i3 false 其实和String那块一样的原因
         我们主要关注于 i1==i2  为什么在127的时候返回的是true,在128的时候 返回false;
         其实也很简单，既然调用的是valueOf方法，我们就看下源码
         if (i >= IntegerCache.low && i <= IntegerCache.high)
         return IntegerCache.cache[i + (-IntegerCache.low)];
         return new Integer(i);
         源码中，我们可以看到，当传入的i大于IntegerCache.low或者小于等于IntegerCache.high时，是直接在一个缓存返回，
         当不在这个范围时，是new一个，所以我们关注下IntegerCache.low和IntegerCache.high的值就可以啦
         static final int low = -128;
         计算可得：high=127

         */
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1==i2);//true

        Integer i3 = new Integer(127);
        System.out.println(i1==i3);//false

        Integer i4= Integer.valueOf(127);
        System.out.println(i1==i4);//true

        Integer i5 = 100;
        Integer i6 = 27;
        Integer i7 = i5+i6;
        System.out.println(i1==i7);

        Integer i8 = 100+27;
        System.out.println(i1==i8);

        /*Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1==i2);//false

        Integer i3 = new Integer(128);
        System.out.println(i1==i3);//false

        Integer i4= Integer.valueOf(128);
        System.out.println(i1==i4);//false*/

    }

}
