package com.ss.dataStructures.array;

/**
 * Main
 *
 * @author shisong
 * @date 2019/4/2
 */
public class Main {

    public static void main(String[] args) {
        // 创建 数组 方式一
        /*int[] arr = new int[20];

        for (int i=0 ; i < arr.length;i++) {
            arr[i]=i;
        }

        // 创建 数组 方式二
        int[] scores = new int[]{100,99,66};
        for (int i=0 ; i < scores.length;i++) {
            System.out.println(scores[i]);
        }

        scores[0] = 98;
        for (int score : scores) {
            System.out.println(score);
        }*/
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.add(i, i);
        }
        System.out.println(arr.toString());

        arr.add(1, 99);
        System.out.println(arr.toString());
    }
}
