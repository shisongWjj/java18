package com.ss.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0287 {
    /*给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     示例 1：
    输入：nums = [1,3,4,2,2]
    输出：2
     示例 2：
    输入：nums = [3,1,3,4,2]
    输出：3
     示例 3：
    输入：nums = [1,1]
    输出：1
     示例 4：
    输入：nums = [1,1,2]
    输出：1
     提示：
     2 <= n <= 3 * 104
     nums.length == n + 1
     1 <= nums[i] <= n
     nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
     进阶：
     如何证明 nums 中至少存在一个重复的数字?
     你可以在不修改数组 nums 的情况下解决这个问题吗？
     你可以只用常量级 O(1) 的额外空间解决这个问题吗？
     你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？
     Related Topics 数组 双指针 二分查找*/
    public static void main(String[] args) {
        int[] nums2 = {2,3,2,1};
        int area = findDuplicate(nums2);
        System.out.println(area);

    }



    public static int findDuplicate(int[] nums) {
        /*Set temp = new HashSet();
        for (int num : nums) {
            if(!temp.add(num)){
                return num;
            }
        }
        return 0;*/
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
