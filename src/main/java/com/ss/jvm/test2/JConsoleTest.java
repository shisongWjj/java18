package com.ss.jvm.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * JConsole
 *
 * @author shisong
 * @date 2019/1/22
 */
public class JConsoleTest {

    public JConsoleTest() {
        byte[] b1 = new byte[128 * 1024];
    }

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start ..");
        fill(1000);
    }

    private static void fill(int n) {
        List<JConsoleTest> jConsoleTestList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jConsoleTestList.add(new JConsoleTest());
        }
    }

}
