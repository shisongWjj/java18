package com.ss.jvm.test4;

/**
 * Main
 * 验证垃圾回收器是否使用的是引用计数法
 *
 * @author shisong
 * @date 2019/1/28
 */
public class Main {

    private Object instance;

    public Main() {
        byte[] abc = new byte[20 * 1024 * 1024];
    }


    /**
     * [GC (System.gc()) [PSYoungGen: 44892K->776K(76288K)] 44892K->784K(251392K), 0.0076700 secs] [Times: user=0.05 sys=0.00, real=0.01 secs]
     * [Full GC (System.gc()) [PSYoungGen: 776K->0K(76288K)] [ParOldGen: 8K->652K(175104K)] 784K->652K(251392K), [Metaspace: 2850K->2850K(1056768K)], 0.0044507 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * Heap
     * PSYoungGen      total 76288K, used 655K [0x000000076b400000, 0x0000000770900000, 0x00000007c0000000)
     * eden space 65536K, 1% used [0x000000076b400000,0x000000076b4a3ee8,0x000000076f400000)
     * from space 10752K, 0% used [0x000000076f400000,0x000000076f400000,0x000000076fe80000)
     * to   space 10752K, 0% used [0x000000076fe80000,0x000000076fe80000,0x0000000770900000)
     * ParOldGen       total 175104K, used 652K [0x00000006c1c00000, 0x00000006cc700000, 0x000000076b400000)
     * object space 175104K, 0% used [0x00000006c1c00000,0x00000006c1ca3150,0x00000006cc700000)
     * Metaspace       used 2856K, capacity 4486K, committed 4864K, reserved 1056768K
     * class space    used 306K, capacity 386K, committed 512K, reserved 1048576K
     * <p>
     * 从[PSYoungGen: 44892K->776K(76288K)] 44892K->784K(251392K), 0.0076700 secs]可以看出，这里的gc使用的不是引用计数法
     *
     * @param args
     */
    public static void main(String[] args) {

        Main m1 = new Main();
        Main m2 = new Main();

        m1.instance = m2;
        m2.instance = m1;

        m1 = null;
        m2 = null;

        System.gc();

    }

}
