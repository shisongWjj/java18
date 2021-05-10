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
        String s ="abba";
        //String s ="dvdf";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    /**
     * 创建一个map  key为滑动窗口中已出现的字符，value为该字符在字符串中的位置。
     * 创建左右指针，和滑动窗口的大小，
     * 当遇到已存在的字符，那么就将左指针移到 上一次出现该字符的位置+1（map中get）
     * 注意这里会遇到回退的问题：
     * 比如abba，当执行到第二个b的时候，left = 2,但是执行到第二个a的时候，left 回退到1，
     * 所以 只有value的值 大于等于 left的时候，才给left进行 重新赋值。
     * 然后 获取最大的滑动窗口的值（Math.max(result,right - left + 1)）
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < s.toCharArray().length; right++) {
            if(map.containsKey(s.charAt(right)) && left <= map.get(s.charAt(right))){
                left = map.get(s.charAt(right)) + 1;
            }
            map.put(s.charAt(right),right);
            result = Math.max(result,right - left + 1);

        }
        return result;
    }

    /*public static int lengthOfLongestSubstring(String s) {
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
    }*/

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
