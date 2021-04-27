package com.ss.leetcode.face;

import java.util.Arrays;

/**
 * Face01606
 *
 * @author shisong
 * @date 2021/4/23
 */
public class Face01001 {

    /*给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     初始化 A 和 B 的元素数量分别为 m 和 n。
     示例:
     输入:
    A = [1,2,3,0,0,0], m = 3
    B = [2,5,6],       n = 3
    输出: [1,2,2,3,5,6]
     说明:
     A.length == n + m
     Related Topics 数组 双指针*/

    public static void main(String[] args) {
        int[] nums1 = {2,2,3,0,0,0};
        int[] nums2 = {1,5,6};
        Integer a = Integer.MAX_VALUE;
        System.out.println(a);
        merge(nums1,3, nums2,3);
        System.out.println("");
    }


    public static void merge(int[] A, int m, int[] B, int n) {
        int first = m - 1;
        int second = n -1;
        int index = m + n - 1;
        while (first >= 0 && second >= 0){
            int a = A[first];
            int b = B[second];
            if(a > b){
                A[index] = a;
                index --;
                first --;
            }else {
                A[index] = b;
                index --;
                second --;
            }
        }
        while (second >= 0){
            A[index--] = B[second--];
        }
        System.out.println("");
    }
}
