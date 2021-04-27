package com.ss.leetcode.face;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Face01606
 *
 * @author shisong
 * @date 2021/4/23
 */
public class Face01606 {

    /*给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
     示例：
    输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
    输出：3，即数值对(11, 8)
     提示：
     1 <= a.length, b.length <= 100000
     -2147483648 <= a[i], b[i] <= 2147483647
     正确结果在区间 [0, 2147483647] 内
     Related Topics 数组 双指针*/

    public static void main(String[] args) {
        int[] nums1 = {-2147483648,1};
        int[] nums2 = {2147483647,0};
        Integer a = Integer.MAX_VALUE;
        System.out.println(a);
        int ints = smallestDifference(nums1, nums2);
        System.out.println(ints);
    }


    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long result = 2147483647;
        int first = 0;
        int second = 0;
        while (first < a.length && second < b.length){
            int i = a[first];
            int j = b[second];
            long diff = i - j;
            result = Math.min(result,Math.abs(diff));
            if(result == 0){
                break;
            }
            if(i > j){
                second++;
            }else {
                first++;
            }
        }
        return (int)result;
    }
}
