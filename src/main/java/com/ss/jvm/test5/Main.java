package com.ss.jvm.test5;

/**
 * Main
 *验证优先分配到Eden区域
 * @author shisong
 * @date 2019/1/29
 */
public class Main {

    /**
     * Heap
     PSYoungGen      total 76288K, used 9339K [0x000000076b400000, 0x0000000770900000, 0x00000007c0000000)
     eden space 65536K, 14% used [0x000000076b400000,0x000000076bd1ed48,0x000000076f400000)
     from space 10752K, 0% used [0x000000076fe80000,0x000000076fe80000,0x0000000770900000)
     to   space 10752K, 0% used [0x000000076f400000,0x000000076f400000,0x000000076fe80000)
     ParOldGen       total 175104K, used 0K [0x00000006c1c00000, 0x00000006cc700000, 0x000000076b400000)
     object space 175104K, 0% used [0x00000006c1c00000,0x00000006c1c00000,0x00000006cc700000)
     Metaspace       used 2855K, capacity 4486K, committed 4864K, reserved 1056768K
     class space    used 306K, capacity 386K, committed 512K, reserved 1048576K

     eden space 65536K, 14% used [0x000000076b400000,0x000000076bd1ed48,0x000000076f400000)
     从这行信息就可以看出，对象优先在Eden上分配
     */
    public static void main(String[] args) {

        byte [] b1 = new byte[400*1024*1024];

    }

}
