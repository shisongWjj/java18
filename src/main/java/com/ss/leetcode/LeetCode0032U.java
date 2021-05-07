package com.ss.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0032U {

    /*给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     示例 1：
    输入：s = "(()"
    输出：2
    解释：最长有效括号子串是 "()"
     示例 2：
    输入：s = ")()())"
    输出：4
    解释：最长有效括号子串是 "()()"
     示例 3：
    输入：s = ""
    输出：0
     提示：
     0 <= s.length <= 3 * 104
     s[i] 为 '(' 或 ')'
     Related Topics 字符串 */
    public static void main(String[] args) {
        int[] num = {1,5,3};
        String s = "))()()";
        int result = longestValidParentheses(s);
        System.out.println(result);

    }



    public static int longestValidParentheses(String s) {
        return 0;
    }
    /*public static int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        while (right < s.length()){
            while (right < s.length() && s.charAt(right) != '('){
                right++;
            }
            left = right;
            //stack.push(s.charAt(left));
            while (right < s.length()){
                if(stack.isEmpty() && s.charAt(right) == ')'){
                    break;
                }
                if(s.charAt(right) == ')'){
                    stack.pop();
                }else {
                    stack.push(s.charAt(right));
                }
                right++;
            }
            result = Math.max(result,right - left - stack.size());
        }
        return result;
    }*/
}
