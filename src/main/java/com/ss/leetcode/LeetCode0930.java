package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0930 {
    /*在由若干 0 和 1 组成的数组 A 中，有多少个和为 S 的非空子数组。
     示例：
     输入：A = [1,0,1,0,1], S = 2
    输出：4
    解释：
    如下面黑体所示，有 4 个满足题目要求的子数组：
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]
     提示：
     A.length <= 30000
     0 <= S <= A.length
     A[i] 为 0 或 1
     Related Topics 哈希表 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {0,1,0,0};
        int[] nums2 = {7,4,8};
        String s1 = "laiden";
        String s2 = "laiden";
        int area = numSubarraysWithSum(nums1,1);
        System.out.println(area);

    }

    public static int numSubarraysWithSum(int[] arr, int s) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while (right < arr.length){
            sum += arr[right];
            while (left < right && sum > s){
                sum -= arr[left];
                left++;
            }

            int temp = sum;
            int leftTemp = left;
            while (temp == s && leftTemp <= right){
                temp -= arr[leftTemp];
                count++;
                leftTemp++;
            }
            right++;
        }

        return count;

    }

}
