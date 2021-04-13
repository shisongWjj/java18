package com.ss.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0524 {
        /*给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
    串。如果答案不存在，则返回空字符串。
     示例 1:
    输入:
    s = "abpcplea", d = ["ale","apple","monkey","plea"]
    输出:
    "apple"
     示例 2:
    输入:
    s = "abpcplea", d = ["a","b","c"]
    输出:
    "a"
     说明:
     所有输入的字符串只包含小写字母。
     字典的大小不会超过 1000。
     所有输入的字符串长度不会超过 1000。
     Related Topics 排序 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {-1,-2,-3,-4,-5};
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");
        String area = findLongestWord(s,dictionary);
        System.out.println(area);

    }

    public static String findLongestWord(String s, List<String> dictionary) {
        if(s == null || s.length() == 0 || dictionary == null || dictionary.size() == 0){
            return "";
        }
        String result = "";
        dictionary.sort((a1, a2) -> {
            if (a1.length() != a2.length()) {
                return a2.length() - a1.length();
            }
            return a1.compareTo(a2);
        });
        for (String str : dictionary) {
            if(str.length() <= result.length()){
                continue;
            }
            if(str.length() > s.length()){
                continue;
            }
            int small = 0;
            int big = 0;
            while (small < str.length() && big < s.length()){
                if(str.charAt(small) == s.charAt(big)){
                    big ++;
                    small ++;
                }else{
                    big++;
                }
            }
            if(small >= str.length()){
                result = str;
            }
        }
        return result;

    }
}
