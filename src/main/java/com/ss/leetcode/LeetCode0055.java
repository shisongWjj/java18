package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0055 {

    /*给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     数组中的每个元素代表你在该位置可以跳跃的最大长度。
     判断你是否能够到达最后一个下标。
     示例 1：
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     示例 2：
    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     提示：
     1 <= nums.length <= 3 * 104
     0 <= nums[i] <= 105
     Related Topics 贪心算法 数组*/
    public static void main(String[] args) {
        int[] num = {3,0,8,2,0,0,1};
        boolean ints = canJump(num);
        System.out.println(ints);

    }

    public static boolean canJump(int[] nums) {
        int index = 0;
        while (index + nums[index] < nums.length - 1){
            if(nums[index]==0){
                return false;
            }
            int temp = index;
            for (int i = index ; i <= index + nums[index];i++){
                if(nums[i] + i > nums[temp] + temp){
                    temp = i;
                }
            }
            if(temp == index){
                return false;
            }
            index = temp;
        }
        return true;
    }
}
