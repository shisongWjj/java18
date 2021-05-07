package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0050 {

   /* 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     示例 1：
    输入：x = 2.00000, n = 10
    输出：1024.00000
     示例 2：
    输入：x = 2.10000, n = 3
    输出：9.26100
     示例 3：
    输入：x = 2.00000, n = -2
    输出：0.25000
    解释：2-2 = 1/22 = 1/4 = 0.25
     提示：
     -100.0 < x < 100.0
     -231 <= n <= 231-1
     -104 <= xn <= 104
     Related Topics 数学 二分查找*/
    public static void main(String[] args) {
        //int[] nums2 = {-1,0,1,2,-1,-4,-1,0,2,2,2};
        //int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        //int[] nums2 = {3,2,2,3};
        String haystack = "mississippi";
        String needle = "issip";
        double area = myPow(2.00000,-2);
        System.out.println(area);
    }



    public static double myPow(double x, int n) {
     double result = 1.0d;
     for(int i = n; i != 0;i=i/2){
        if(i % 2 != 0){
            result = result * x;
        }
        x = x*x;
     }
     return n < 0 ? (double) 1/result : result;
    }

}
