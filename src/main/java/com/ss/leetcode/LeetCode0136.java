package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0136 {

    /*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     说明：
     你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     示例 1:
     输入: [2,2,1]
    输出: 1
     示例 2:
     输入: [4,1,2,1,2]
    输出: 4
     Related Topics 位运算 哈希表*/
    public static void main(String[] args) {
        /*[5,8,2,8]
[6,5,6,6]*/
        int[] num1 = {4,1,2,1,2};
        int[] num2 = {6,5,6,6};
        int ints = singleNumber(num1);
        System.out.println(ints);

    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

}
