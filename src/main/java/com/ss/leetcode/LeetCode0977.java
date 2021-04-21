package com.ss.leetcode;

import java.util.Arrays;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0977 {
    /*给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     示例 1：
    输入：nums = [-4,-1,0,3,10]
    输出：[0,1,9,16,100]
    解释：平方后，数组变为 [16,1,0,9,100]
    排序后，数组变为 [0,1,9,16,100]
     示例 2：
    输入：nums = [-7,-3,2,3,11]
    输出：[4,9,9,49,121]
     提示：
     1 <= nums.length <= 104
     -104 <= nums[i] <= 104
     nums 已按 非递减顺序 排序
     进阶：
     请你设计时间复杂度为 O(n) 的算法解决本问题
     Related Topics 数组 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {-7,-3,2,3,11};
        int[] nums2 = {7,4,8};
        String s1 = "laiden";
        String s2 = "laiden";
        int[] area = bagOfTokensScore(nums1);
        System.out.println(area);

    }

    public static int[] bagOfTokensScore(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = result.length - 1;
        while (left <= right){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                result[index--] = nums[right] * nums[right];
                right --;
            }else {
                result[index--] = nums[left] * nums[left];
                left ++;
            }
        }
        return result;
    }

}
