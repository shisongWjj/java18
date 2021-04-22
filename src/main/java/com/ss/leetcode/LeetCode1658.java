package com.ss.leetcode;

import java.util.Arrays;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode1658 {
   /* 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
 数组以供接下来的操作使用。
 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 示例 1：
输入：nums = [1,1,4,2,3], x = 5
输出：2
解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 示例 2：
输入：nums = [5,6,7,8,9], x = 4
输出：-1
 示例 3：
输入：nums = [3,2,20,1,1,3], x = 10
输出：5
解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 提示：
 1 <= nums.length <= 105
 1 <= nums[i] <= 104
 1 <= x <= 109
 Related Topics 贪心算法 双指针 二分查找 Sliding Window*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {5,6,7,8,9};
        int[] nums2 = {7,4,8};
        String s1 = "fgixkdymrtiqifbmwjhuwdukaqfjekzckyjyxfbdiswmmwsidbfxyjykczkejfqakudwuhjwmbfizciijajfncqy";
        String s2 = "yqcnfjajiiczbzgcziiriyhfxlqrdtijusntxzazzxncqnuyryrognehxsgkmkzgtmtpdpkffxqvgtmcifissukj";
        int area = minOperations(nums1,4);
        System.out.println(area);

    }

    public static int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        if(sum < x){
            return -1;
        }
        if(sum == x){
            return nums.length;
        }
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int slidingWindow = -1;
        while (right < nums.length){
            currentSum += nums[right];
            right++;
            while (currentSum > sum - x){
                currentSum -= nums[left];
                left ++;
            }
            if(currentSum == sum - x){
                slidingWindow = Math.max(slidingWindow,right -left);
            }
        }
        return slidingWindow == -1 ? -1 : nums.length - slidingWindow;
    }
}
