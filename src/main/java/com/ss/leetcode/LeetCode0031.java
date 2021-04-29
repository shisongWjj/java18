package com.ss.leetcode;

import java.util.Arrays;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0031 {

    /*实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 必须 原地 修改，只允许使用额外常数空间。
 示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]
 示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]
 示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]
 示例 4：
输入：nums = [1]
输出：[1]
 提示：
 1 <= nums.length <= 100
 0 <= nums[i] <= 100
 Related Topics 数组*/
    public static void main(String[] args) {
        int[] num = {1,5,3};
        nextPermutation(num);
        System.out.println("");

    }



    public static void nextPermutation(int[] nums) {
        if(nums.length ==1){
            return;
        }
        int i = nums.length - 1;
        while (i > 0 && nums[i-1]>=nums[i]){
            i--;
        }
        if(i==0){
            Arrays.sort(nums);
            return;
        }
        int j = nums.length -1;
        while (j > i-1){
            if(nums[j] > nums[i-1]){
                break;
            }
            j--;
        }
        int temp = nums[j];
        nums[j] = nums[i-1];
        nums[i-1] = temp;
        Arrays.sort(nums,i,nums.length);
    }

}
