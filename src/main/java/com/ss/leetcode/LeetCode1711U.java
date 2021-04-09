package com.ss.leetcode;

import java.util.Arrays;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode1711U {
    /*给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
    。假定每组输入只存在唯一答案。
     示例：
     输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     提示：
     -10^3 <= nums[i] <= 10^3
     -10^4 <= target <= 10^4
     Related Topics 数组 双指针*/
    public static void main(String[] args) {
        int[] nums2 = {-1,2,1,-4};
        int area = threeSumClosest(nums2,1);
        System.out.println(area);

    }


    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null){
            return 0;
        }
        int result = 0;
        if(nums.length <= 3){
            for (int num : nums) {
                result += num;
            }
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < 3; i++) {
            result += nums[i];
        }
        int sum = Math.abs(result - target);
        for (int i = 0; i < nums.length-2; i++) {
            int fixValue = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int a = nums[left];
                int b = nums[right];
                if(fixValue + a + b < target){
                    left++;
                }else if(fixValue + a + b == target){
                    return target;
                }else {
                    right--;
                }
                int temp = Math.abs(fixValue + a + b - target);
                if(temp < sum){
                    result = fixValue + a + b;
                }
                sum = Math.min(sum, temp);

            }

        }
        return result;
    }
}
