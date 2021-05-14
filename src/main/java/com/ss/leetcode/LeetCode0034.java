package com.ss.leetcode;

import java.util.Arrays;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0034 {

   /* 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 如果数组中不存在目标值 target，返回 [-1, -1]。
 进阶：
 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
 示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
 示例 3：
输入：nums = [], target = 0
输出：[-1,-1]
 提示：
 0 <= nums.length <= 105
 -109 <= nums[i] <= 109
 nums 是一个非递减数组
 -109 <= target <= 109
 Related Topics 数组 二分查找*/
    public static void main(String[] args) {
        int[] num = {1,3};
        int[] ints = searchRange(num, 3);
        System.out.println("");

    }

    /**
     * 先通过二分法 找到 目标值
     * 如果不存在，就直接返回
     * 如果存在就通过双指针 一个向左找 一个向右找 ，直到不相等为止。
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums == null || nums.length ==0){
            return result;
        }
        int indexNum = searchRange(nums,target,0,nums.length,false);
        if(indexNum == -1){
            return result;
        }
        int left = indexNum;
        int right = indexNum;
        while (left > 0 && nums[left-1] == target){
            left --;
        }
        while (right < nums.length-1 && nums[right+1] == target){
            right ++;
        }
        return new int[]{left,right};
    }

    private static int searchRange(int[] nums, int target ,int start,int end,boolean flag){
        int index = (end+start)/2;
        if(flag){
            return -1;
        }
        int num = nums[index];
        if(num > target){
            return searchRange(nums,target,start,index,index == start || index == end);
        }else if(target > num){
            return searchRange(nums,target,index,end,index == start || index == end);
        }else{
            return index;
        }
    }

}
