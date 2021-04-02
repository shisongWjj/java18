package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0159U {
    /*给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
    *示例 1:
    输入: "eceba"
    输出: 3
    解释: t 是 "ece"，长度为3。

    示例 2:
    输入: "ccaabbb"
    输出: 5
    解释: t 是 "aabbb"，长度为5。
     */
    public static void main(String[] args) {
        int[] nums2 = {2,3,2,1};
        int area = lengthOfLongestSubstringTwoDistinct("AAAABBAAB");
        System.out.println(area);

    }


    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null){
            return 0;
        }

        return 0;
    }
}
