package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode1800 {
    /*给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
     子数组是数组中的一个连续数字序列。
     已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi
    +1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
     示例 1：
    输入：nums = [10,20,30,5,10,50]
    输出：65
    解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
     示例 2：
    输入：nums = [10,20,30,40,50]
    输出：150
    解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
     示例 3：
    输入：nums = [12,17,15,13,10,11,12]
    输出：33
    解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
     示例 4：
    输入：nums = [100,10,1]
    输出：100
     提示：
     1 <= nums.length <= 100
     1 <= nums[i] <= 100
     Related Topics 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {100,10,1};
        int[] nums2 = {7,4,8};
        String s1 = "QWER";
        String s2 = "laiden";
        int area = maxAscendingSum(nums1);
        System.out.println(area);

    }

    public static int maxAscendingSum(int[] nums) {
        int index = 0;
        int sum = 0 ;
        int result = 0 ;
        while (index < nums.length){
            if(index == 0){
                sum += nums[index];
                result = Math.max(sum,result);
                index ++;
                continue;
            }
            if(nums[index] - nums[index - 1] > 0){
                sum += nums[index];
            }else{
                sum = nums[index];
            }
            result = Math.max(sum,result);
            index ++;
        }
        return result;

    }

}
