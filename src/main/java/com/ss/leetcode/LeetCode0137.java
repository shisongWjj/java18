package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0137 {

   /* 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 示例 1：
输入：nums = [2,2,3,2]
输出：3
 示例 2：
输入：nums = [0,1,0,1,0,1,99]
输出：99
 提示：
 1 <= nums.length <= 3 * 104
 -231 <= nums[i] <= 231 - 1
 nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 Related Topics 位运算*/
    public static void main(String[] args) {
        /*[5,8,2,8]
[6,5,6,6]*/
        int[] num1 = {4,2,2,1,1,2,3,3,1,3};
        int[] num2 = {6,5,6,6};
        int ints = singleNumber(num1);
        System.out.println(ints);

    }

    /*代码参考热评。解释下：假设有一个数为x,那么则有如下规律：
    0 ^ x = x,
    x ^ x = 0；
    x & ~x = 0,
    x & ~0 =x;
    -那么就是很好解释上面的代码了。一开始a = 0, b = 0;
    x第一次出现后，a = (a ^ x) & ~b的结果为 a = x, b = (b ^ x) & ~a的结果为此时因为a = x了，所以b = 0。
    x第二次出现：a = (a ^ x) & ~b, a = (x ^ x) & ~0, a = 0; b = (b ^ x) & ~a 化简， b = (0 ^ x) & ~0 ,b = x;
    x第三次出现：a = (a ^ x) & ~b， a = (0 ^ x) & ~x ,a = 0; b = (b ^ x) & ~a 化简， b = (x ^ x) & ~0 , b = 0;所以出现三次同一个数，a和b最终都变回了0.
    只出现一次的数，按照上面x第一次出现的规律可知a = x, b = 0;因此最后返回a.*/
    public static int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }

}
