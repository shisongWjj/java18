package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0045 {

    /*给定一个非负整数数组，你最初位于数组的第一个位置。
     数组中的每个元素代表你在该位置可以跳跃的最大长度。
     你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     假设你总是可以到达数组的最后一个位置。
     示例 1:
    输入: [2,3,1,1,4]
    输出: 2
    解释: 跳到最后一个位置的最小跳跃数是 2。
         从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     示例 2:
    输入: [2,3,0,1,4]
    输出: 2
     提示:
     1 <= nums.length <= 1000
     0 <= nums[i] <= 105
     Related Topics 贪心算法 数组*/
    public static void main(String[] args) {
        int[] num = {2,3,1,1,4};
        int ints = jump(num);
        System.out.println(ints);

    }

    public static int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int count = 1;
        int index = 0;
        while (index < nums.length - 1 && index + nums[index] < nums.length-1){
            count ++;
            if(nums[index] == 0){
                return -1;
            }
            int temp = index;
            for(int i = index + 1; i <= index + nums[index] ; i ++){
                if(nums[i] + i > nums[temp] + temp){
                    temp = i;
                }
            }
            if(temp == index){
                return -1;
            }else {
                index = temp;
            }
        }
        return count;
    }

}
