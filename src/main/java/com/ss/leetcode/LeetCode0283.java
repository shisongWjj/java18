package com.ss.leetcode;

/**
 * LeetCode0001
 *
 * @author shisong
 * @date 2019/10/10
 */
public class LeetCode0283 {
    /*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     示例:
     输入: [0,1,0,3,12]
    输出: [1,3,12,0,0]
     说明:
     必须在原数组上操作，不能拷贝额外的数组。
     尽量减少操作次数。
     Related Topics 数组 双指针*/

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int target = 18;
        moveZeroes(nums);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] != 0){
                nums[left] = nums[right];
                left++;
            }
        }
        while (left < nums.length){
            nums[left] = 0;
            left++;
        }
        System.out.println(1);
    }
}
