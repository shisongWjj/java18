package com.ss.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0457 {
    /*
     遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
     所有 nums[seq[j]] 应当不是 全正 就是 全负
     k > 1
     如果 nums 中存在循环，返回 true ；否则，返回 false 。
     示例 1：
    输入：nums = [2,-1,1,2,2]
    输出：true
    解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
     示例 2：
    输入：nums = [-1,2]
    输出：false
    解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
     示例 3:
    输入：nums = [-2,1,-1,-2,-2]
    输出：false
    解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
    所有 nums[seq[j]] 应当不是全正就是全负。
     提示：
     1 <= nums.length <= 5000
     -1000 <= nums[i] <= 1000
     nums[i] != 0
     进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？
     Related Topics 数组 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {-1,-2,-3,-4,-5};
        boolean area = circularArrayLoop(nums2);
        System.out.println(area);

    }

    public static boolean circularArrayLoop(int[] nums) {
        if(nums == null || nums.length <=1){
            return false;
        }
        if(nums.length == 2 && nums[0]*nums[1] < 0){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int lastSlow,lastFast;
            int slow = i ,fast = i;
            while (true){
                lastSlow = slow;
                slow = (slow + nums[slow])%nums.length;
                slow = slow < 0 ? slow + nums.length : slow;
                if(nums[lastSlow]*nums[slow] < 0 || slow == lastSlow || nums[slow] == 0){
                    setZero(nums, i);
                    break;
                }

                lastFast = fast;
                fast = (fast + nums[fast])%nums.length;
                fast = fast < 0 ? fast + nums.length : fast;
                if(nums[lastFast]*nums[fast] < 0 || fast == lastFast || nums[fast] == 0){
                    setZero(nums, i);
                    break;
                }

                lastFast = fast;
                fast = (fast + nums[fast])%nums.length;
                fast = fast < 0 ? fast + nums.length : fast;
                if(nums[lastFast]*nums[fast] < 0 || fast == lastFast || nums[fast] == 0){
                    setZero(nums, i);
                    break;
                }
                if(fast == slow){
                    return true;
                }
            }
        }
        return false;
    }

    private static void setZero(int[] nums, int i) {
        int j;
        while (true){
            j = (i + nums[i])%nums.length;
            j = j < 0 ? j + nums.length : j;
            if(nums[i]*nums[j] < 0 || nums[j] == 0){
                nums[i] = 0;
                break;
            }
            nums[i] = 0;
            i = j;
        }
    }
}
