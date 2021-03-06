package com.ss.leetcode;

import java.util.List;

/**
 * LeetCode0001
 *
 * @author shisong
 * @date 2019/10/10
 */
public class LeetCode0395U {
    /*给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 示例 1：
输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 示例 2：
输入：s = "ababbc", k = 2
输出：5
解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 提示：
 1 <= s.length <= 104
 s 仅由小写英文字母组成
 1 <= k <= 105

 Related Topics 递归 分治算法 Sliding Window*/

    public static void main(String[] args) {
        char[] nums = {'h','e','l','l','o'};
        int target = 18;
        String s = "ababbc";
        int result = longestSubstring(s,2);
        System.out.println(result);
    }


    public static int longestSubstring(String s, int k) {
        if(k == 1){
            return s.length();
        }
        int[] temp = new int[26];
        for (int i = 0; i < s.toCharArray().length; i++) {
            temp[s.charAt(i) - 'a']++;
        }
        return 0;

    }
}
