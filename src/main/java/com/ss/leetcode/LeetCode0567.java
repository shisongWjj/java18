package com.ss.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0567 {
    /*给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
     示例 1：
    输入: s1 = "ab" s2 = "eidbaooo"
    输出: True
    解释: s2 包含 s1 的排列之一 ("ba").
     示例 2：
    输入: s1= "ab" s2 = "eidboaoo"
    输出: False
     提示：
     输入的字符串只包含小写字母
     两个字符串的长度都在 [1, 10,000] 之间
     Related Topics 双指针 Sliding Window*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {-1,-2,-3,-4,-5};
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean area = checkInclusion(s1,s2);
        System.out.println(area);

    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length()){
            return false;
        }
        int[] temp = new int[26];
        for (char c : s1.toCharArray()) {
            temp[c-'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < s2.length()){
            char c = s2.charAt(right);
            temp[c-'a']--;
            while (temp[c-'a'] < 0 ){
                temp[s2.charAt(left)-'a']++;
                left++;
            }
            right++;
            if(right - left == s1.length()){
                return true;
            }

        }
        return false;

    }

   /* public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length()){
            return false;
        }
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        int left = 0;
        int right = s1.length();
        while (right <= s2.length()){
            String temp = s2.substring(left, right);
            char[] chars = temp.toCharArray();
            Arrays.sort(chars);
            if(new String(chars).equals(new String(c1))){
                return true;
            }else{
                left ++;
                right ++;
            }
        }
        return false;
    }*/
}
