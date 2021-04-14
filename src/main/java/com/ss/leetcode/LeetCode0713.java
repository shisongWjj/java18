package com.ss.leetcode;

import org.apache.kafka.common.metrics.stats.Count;

import java.util.Arrays;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0713 {
    /*给定一个正整数数组 nums。
 找出该数组内乘积小于 k 的连续的子数组的个数。
 示例 1:
输入: nums = [10,5,2,6], k = 100
输出: 8
解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 说明:
 0 < nums.length <= 50000
 0 < nums[i] < 1000
 0 <= k < 10^6
 Related Topics 数组 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {5,2,50,600};
        int[] nums2 = {-1,-2,-3,-4,-5};
        int area = numSubarrayProductLessThanK(nums1,100);
        System.out.println(area);

    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0 || k == 1){
            return 0;
        }
        int left = 0;
        int right = 0;
        int product = 1;
        int count = 0;
        while (right < nums.length){
            product = product * nums[right];
            while (product >= k){
                product = product/nums[left];
                left ++;
            }
            count = count + right - left + 1;
            right ++;
        }

        return count;
    }

    /*public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        k = Math.abs(k);
        Arrays.sort(nums);
        int count = 0;
        int value = -108;
        for (int left = 0; left < nums.length - 1; left++) {
            if(nums[left] == value){
                continue;
            }else{
                value = nums[left];
            }
            for (int right = left + 1; right < nums.length; right++) {
                if(nums[right] - nums[left] == k){
                    count ++;
                    break;
                }
            }
        }
        return count;
    }*/
}
