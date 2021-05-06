package com.ss.leetcode;


import java.util.Stack;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0316 {
   /* 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
    -characters 相同
     示例 1：
    输入：s = "bcabc"
    输出："abc"
     示例 2：
    输入：s = "cbacdcbc"
    输出："acdb"
     提示：
     1 <= s.length <= 104
     s 由小写英文字母组成
     Related Topics 栈 贪心算法 字符串 */
    public static void main(String[] args) {
        int[] nums2 = {2,3,2,1};
        String area = removeDuplicateLetters("cbacdcbc");
        System.out.println(area);

    }



    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if(stack.contains(c)){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(),i) != -1){
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
