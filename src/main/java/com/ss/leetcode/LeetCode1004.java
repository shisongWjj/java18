package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode1004 {
    /*给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
     返回仅包含 1 的最长（连续）子数组的长度。
     示例 1：
     输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
    输出：6
    解释：
    [1,1,1,0,0,1,1,1,1,1,1]
    粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     示例 2：
     输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
    输出：10
    解释：
    [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     提示：
     1 <= A.length <= 20000
     0 <= K <= A.length
     A[i] 为 0 或 1
     Related Topics 双指针 Sliding Window */
    public static void main(String[] args) {
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int area = longestOnes(nums2,3);
        System.out.println(area);

    }


    /**
     * 用一个参数记录count 0 在滑动窗口中出现的次数
     * 如果count > k 意味着需要移动左指针，并且获取原左指针所对应的数值，如果是0的话，就将count-1
     * @param nums
     * @param k
     * @return
     */
    public static int longestOnes(int[] nums, int k) {
        if(nums == null){
            return 0;
        }
        if(nums.length < k){
            return nums.length;
        }
        int count = 0;
        int left = 0;
        for(int right = 0; right < nums.length;right++){
            int num = nums[right];
            if(num != 1){
                count ++;
            }
            if(count > k){
                int num1 = nums[left];
                if(num1 != 1){
                    count --;
                }
                left ++;
            }
        }
        return nums.length - left;
    }
}
