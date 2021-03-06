package com.ss.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode1839 {
    /*当一个字符串满足如下条件时，我们称它是 美丽的 ：
 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo"
不是美丽的 。
 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 子字符串 是字符串中一个连续的字符序列。
 示例 1：
输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
输出：13
解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
 示例 2：
输入：word = "aeeeiiiioooauuuaeiou"
输出：5
解释：最长子字符串是 "aeiou" ，长度为 5 。
 示例 3：
输入：word = "a"
输出：0
解释：没有美丽子字符串，所以返回 0 。
 提示：
 1 <= word.length <= 5 * 105
 word 只包含字符 'a'，'e'，'i'，'o' 和 'u' 。
 Related Topics 双指针 字符串*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {100,10,1};
        int[] nums2 = {7,4,8};
        //String s1 = "aaaaeiiiiouuuooaauuaeiu";
        //String s1 = "aeiou";
        String s1 = "eauoiouieaaoueiuaieoeauoiaueoiaeoiuieuaoiaeouiaueo";
        String s2 = "laiden";
        int area = longestBeautifulSubstring(s1);
        System.out.println(area);

    }

    public static int longestBeautifulSubstring(String word) {
        if(word == null || word.length() < 5){
            return 0;
        }
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < word.length()){
            while(right < word.length() && word.charAt(right) != 'a'){
                right ++;
            }
            if(word.length() - right < 5){
                return result;
            }
            left = right;
            Set temp = new HashSet();
            temp.add(word.charAt(right));
            while(right < word.length()){
                if(right == left){
                    right ++;
                    continue;
                }
                if(word.charAt(right)< word.charAt(right -1)){
                    break;
                }
                temp.add(word.charAt(right));
                right++;
            }
            if(temp.size() == 5){
                result = Math.max(result,right - left);
            }
        }
        return result;
    }

    /*public static int longestBeautifulSubstring(String word) {
        if(word.length() < 5){
            return 0;
        }
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Character> temp = new HashSet<>();
        while (right < word.length()){
            while (left < word.length()){
                if(word.charAt(left ) == 'a'){
                    break;
                }
                left++;
            }
            if(word.length() - left < 5){
                break;
            }
            temp = new HashSet<>();
            temp.add(word.charAt(left));
            right = left + 1;
            while (right < word.length()){
                if(word.charAt(right) >= word.charAt(right - 1)){
                    temp.add(word.charAt(right));
                    right ++;
                }else{
                    if(temp.size() == 5){
                        result = Math.max(result,right - left);
                    }
                    left = right;
                    break;
                }
            }
        }
        if(temp.size() == 5){
            result = Math.max(result,right - left);
        }
        return result;
    }*/

}
