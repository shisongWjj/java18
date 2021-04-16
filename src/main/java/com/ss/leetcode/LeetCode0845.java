package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0845 {
    /*我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 B.length >= 3
 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
[B.length - 1]
 （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 给出一个整数数组 A，返回最长 “山脉” 的长度。
 如果不含有 “山脉” 则返回 0。
 示例 1：
 输入：[2,1,4,7,3,2,5]
输出：5
解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 示例 2：
 输入：[2,2,2]
输出：0
解释：不含 “山脉”。
 提示：
 0 <= A.length <= 10000
 0 <= A[i] <= 10000
 Related Topics 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {0,1,2,3,4,5,4,3,2,1,0};
        int[] nums2 = {7,4,8};
        String s1 = "a#c#b";
        String s2 = "b";
        int area = longestMountain(nums1);
        System.out.println(area);

    }

    public static int longestMountain(int[] arr) {
        int index = 1;
        int result = 0;
        while (index < arr.length - 1){
            if (arr[index] > arr[index -1] && arr[index] > arr[index + 1]){
                int left = index - 1;
                int right = index + 1;
                while (left > 0 && arr[left] > arr[left -1]){
                    left --;
                }

                while (right < arr.length - 1 && arr[right] > arr[right + 1]){
                    right ++;
                }
                result = Math.max(result,right -left + 1);
            }
            index ++;
        }
        return result;
    }

}
