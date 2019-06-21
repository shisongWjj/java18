package com.ss.jvm.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * Main
 *
 * @author shisong
 * @date 2019/1/22
 */
public class Main {

    public static void main(String[] args) {
        List<Demo> demoList = new ArrayList<>();
        while (true) {
            demoList.add(new Demo());
        }
    }

}
