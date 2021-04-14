package com.ss.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0763 {
        /*字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     示例：
    输入：S = "ababcbacadefegdehijhklij"
    输出：[9,7,8]
    解释：
    划分结果为 "ababcbaca", "defegde", "hijhklij"。
    每个字母最多出现在一个片段中。
    像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     提示：
     S的长度在[1, 500]之间。
     S只包含小写字母 'a' 到 'z' 。
     Related Topics 贪心算法 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {-1,-2,-3,-4,-5};
        String s1 = "ababcbacadefegdehijhklij";
        String s2 = "eidbaooo";
        List<Integer> area = partitionLabels(s1);
        System.out.println(area);

    }

    public static List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        int[] temp = new int[26];
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            temp[c-'a']++;
        }
        int left = 0;
        List<Integer> result = new ArrayList<>();
        for (int right = 0; right < s.toCharArray().length; right++) {
            char c = s.charAt(right);
            temp[c-'a']--;
            if(temp[c-'a'] == 0){
                set.remove(c);
            }else{
                set.add(c);
            }
            if(set.isEmpty()){
                result.add(right - left + 1);
                left = right + 1;
            }
        }
        return result;
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
