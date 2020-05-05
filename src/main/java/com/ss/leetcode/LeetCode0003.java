package com.ss.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode0003
 *
 * @author shisong
 * @date 2019/10/11
 */
public class LeetCode0003 {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        //String s = "aabaab!bb";
        //String s ="abcabcbb";
        //String s ="bbbbb";
        //String s =" ";
        //String s ="au";
        //String s ="cdd";
        //String s ="abba";
        String s ="dvdf";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0,last = 0;
        char[] chars = s.toCharArray();
        int size = chars.length;
        for(int i = 0; i < size ; i ++){
            if(map.containsKey(chars[i]) && map.get(chars[i]) >= last){
                if(i - last > max){
                    max = i - last;
                }
                last = map.get(chars[i]) + 1;
            }
            map.put(chars[i],i);
        }
        return max > size-last ? max : size-last;
    }

    public static Integer aaa(String s){
        List<Character> rs = new ArrayList<>();
        List<Character> result = new ArrayList<>();
        for (char s1 : s.toCharArray()) {
            if(result.contains(s1)){
                if(result.size() > rs.size()){
                    rs = new ArrayList<>();
                    rs.addAll(result);
                }
                result = result.subList(result.indexOf(s1)+1,result.size());
            }
            result.add(s1);

        }
        return rs.size() > result.size() ?rs.size():result.size() ;
    }
}
