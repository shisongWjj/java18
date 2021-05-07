package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0069 {

    /*实现 int sqrt(int x) 函数。
 计算并返回 x 的平方根，其中 x 是非负整数。
 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 示例 1:
 输入: 4
输出: 2
 示例 2:
 输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 Related Topics 数学 二分查找*/
    public static void main(String[] args) {
        //int[] num = {4,5,6,7,0,1,2};
        int[] num = {1,3};
        int ints = mySqrt(2147395599);
        System.out.println(ints);

    }

    public static int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        int min = 0;
        int max = x;
        while (max - min > 1){
            int mid = (max + min)/2;
            if(mid <= x/mid){
                min = mid;
            }else{
                max = mid;
            }
        }
        return min;
    }

}
