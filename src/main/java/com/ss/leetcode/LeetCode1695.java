package com.ss.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode1695 {
   /* 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 返回 只删除一个 子数组可获得的 最大得分 。
 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 示例 1：
输入：nums = [4,2,4,5,6]
输出：17
解释：最优子数组是 [2,4,5,6]
 示例 2：
输入：nums = [5,2,1,2,5,2,1,2,5]
输出：8
解释：最优子数组是 [5,2,1] 或 [1,2,5]
 提示：
 1 <= nums.length <= 105
 1 <= nums[i] <= 104
 Related Topics 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};
        int[] nums2 = {7,4,8};
        String s1 = "fgixkdymrtiqifbmwjhuwdukaqfjekzckyjyxfbdiswmmwsidbfxyjykczkejfqakudwuhjwmbfizciijajfncqy";
        String s2 = "yqcnfjajiiczbzgcziiriyhfxlqrdtijusntxzazzxncqnuyryrognehxsgkmkzgtmtpdpkffxqvgtmcifissukj";
        int area = maximumUniqueSubarray(nums1);
        System.out.println(area);

    }

    public static int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int maxSum = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while (right < nums.length){
            if(!map.containsKey(nums[right])){
                map.put(nums[right],right);
                sum += nums[right++];
            }else{
                System.out.println(right);
                Integer index = map.get(nums[right]);
                /*if(left < index){
                    left = index;
                }*/
                while (left <= index){
                    map.remove(nums[left]);
                    sum -= nums[left++];
                }
                map.put(nums[right],right);
                sum += nums[right];
                right ++;
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
