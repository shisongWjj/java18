package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0035 {

    /*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     你可以假设数组中无重复元素。
     示例 1:
     输入: [1,3,5,6], 5
    输出: 2
     示例 2:
     输入: [1,3,5,6], 2
    输出: 1
     示例 3:
     输入: [1,3,5,6], 7
    输出: 4
     示例 4:
     输入: [1,3,5,6], 0
    输出: 0
     Related Topics 数组 二分查找*/
    public static void main(String[] args) {
        int[] num = {1,3};
        int ints = search(num, 2);
        System.out.println("");

    }

    /**
     * 通过二分法去查找，如果找到就直接返回下标
     * 如果没找到，left = mid +1   或者 right = mid;
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length ==0 ){
            return 0;
        }
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

}
