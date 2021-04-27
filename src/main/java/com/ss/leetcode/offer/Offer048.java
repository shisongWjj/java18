package com.ss.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Offer022
 *
 * @author shisong
 * @date 2021/4/27
 */
public class Offer048 {
    /*请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     示例 1:
     输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:
     输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:
     输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     提示：
     s.length <= 40000
     注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
    eating-characters/
     Related Topics 哈希表 双指针 Sliding Window*/
    public static void main(String[] args) {
        int[] nums1 = {-2147483648,1};
        int[] nums2 = {2147483647,0};
        int[][] num = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        //int[][] num = {{}};[[1,3,5,7,9],[2,4,6,8,10],[11,13,15,17,19],[12,14,16,18,20],[21,22,23,24,25]]
        //8
        //int[][] num = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        String s = "pwwkew";
        int ints = lengthOfLongestSubstring(s);
        System.out.println(ints);
    }


    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0;
        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int right = 0; right < s.length() ; right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                Integer index = map.get(c);
                if(left <= index){
                    left = index + 1;
                }
            }
            map.put(c,right);
            result = Math.max(right - left + 1,result);
        }
        return result;
    }

}
