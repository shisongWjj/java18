package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0029 {

    /*给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     返回被除数 dividend 除以除数 divisor 得到的商。
     整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     示例 1:
     输入: dividend = 10, divisor = 3
    输出: 3
    解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     示例 2:
     输入: dividend = 7, divisor = -3
    输出: -2
    解释: 7/-3 = truncate(-2.33333..) = -2
     提示：
     被除数和除数均为 32 位有符号整数。
     除数不为 0。
     假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     Related Topics 数学 二分查找*/
    public static void main(String[] args) {
        //int[] nums2 = {-1,0,1,2,-1,-4,-1,0,2,2,2};
        //int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        //int[] nums2 = {3,2,2,3};
        String haystack = "mississippi";
        String needle = "issip";
        int area = divide(-2147483648,1);
        System.out.println(area);
    }


    /**
     * a/b 等价于 (a/2) / (b/2)
     * a/b == c......d  0<d<b
     * 假设a=100  b = 11  ,将a从31位开始左移
     * a>>31
     * a>>30
     * a>>29
     * .
     * .
     * .
     * a>> 5
     * a>> 4
     * a>> 3
     * 当左移3次的时候 a=12 >= b
     *
     * 那么 a = a- b<<3 = 100 - 88 = 12
     * result = 1<<3 = 8
     *
     * 进入下一次循环
     * 左移0次
     * 那么 a = a- b<<0 = 12 - 11 = 1
     * result = 1<<0 = 1+8 =9
     * 100/11 = 9......1;
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean flag = (dividend ^ divisor) < 0;
        int result = 0;
        long di = Math.abs((long) dividend);
        long d = Math.abs((long)divisor);
        for(int i = 31 ; i >=0; i--){
            if((di>>i) >= d){
                result += 1 << i;
                di -= d << i;
            }
        }
        return flag ? -result : result;
    }

}
