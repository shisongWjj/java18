package com.ss.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0349 {
   /* 给定两个数组，编写一个函数来计算它们的交集。
 示例 1：
 输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
 示例 2：
 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
 说明：
 输出结果中的每个元素一定是唯一的。
 我们可以不考虑输出结果的顺序。
 Related Topics 排序 哈希表 双指针 二分查找*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {5,0,0,6,1,6,2,2,4};
        int[] area = intersection(nums1,nums2);
        System.out.println(area);

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0;
        int right = 0;
        Set<Integer> temps = new HashSet<>();
        while (left < nums1.length && right < nums2.length){
            if(nums1[left] == nums2[right]){
                temps.add(nums1[left]);
                left ++;
                right ++;
            }else if(nums1[left] < nums2[right]){
                left ++;
            }else{
                right ++;
            }
        }
        int[] result = new int[temps.size()];
        int i = 0;
        for (Integer temp : temps) {
            result[i] = temp;
            i++;
        }
        return result;

    }
}
