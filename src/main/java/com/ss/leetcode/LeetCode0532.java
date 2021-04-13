package com.ss.leetcode;

import com.ss.dataStructures.array.Array;

import java.util.Arrays;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0532 {
    /*给定一个整数数组和一个整数 k，你需要在数组里找到不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
     这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
     0 <= i, j < nums.length
     i != j
     |nums[i] - nums[j]| == k
     注意，|val| 表示 val 的绝对值。
     示例 1：
    输入：nums = [3, 1, 4, 1, 5], k = 2
    输出：2
    解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
    尽管数组中有两个1，但我们只应返回不同的数对的数量。
     示例 2：
    输入：nums = [1, 2, 3, 4, 5], k = 1
    输出：4
    解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     示例 3：
    输入：nums = [1, 3, 1, 5, 4], k = 0
    输出：1
    解释：数组中只有一个 0-diff 数对，(1, 1)。
     示例 4：
    输入：nums = [1,2,4,4,3,3,0,9,2,3], k = 3
    输出：2
     示例 5：
    输入：nums = [-1,-2,-3], k = 1
    输出：2
     提示：
     1 <= nums.length <= 104
     -107 <= nums[i] <= 107
     0 <= k <= 107
     Related Topics 数组 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {-1,-2,-3,-4,-5};
        int area = findPairs(nums2,1);
        System.out.println(area);

    }

    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        k = Math.abs(k);
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = 1;
        while (right < nums.length){
            if(nums[right] - nums[left] < k){
                right ++;
            }else if(nums[right] - nums[left] > k){
                left++;
            }else {
                count ++;
                left ++;
                right ++;
            }
            while (right < nums.length && nums[right] == nums[right -1]){
                right ++;
            }

            while (left > 0 && left < nums.length && nums[left] == nums[left -1]){
                left ++;
            }
            if(right <= left){
                right = left +1;
            }
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
