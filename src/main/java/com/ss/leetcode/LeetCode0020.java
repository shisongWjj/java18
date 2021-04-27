package com.ss.leetcode;

import java.util.Stack;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0020 {

   /* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     有效字符串需满足：
     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     示例 1：
    输入：s = "()"
    输出：true
     示例 2：
    输入：s = "()[]{}"
    输出：true
     示例 3：
    输入：s = "(]"
    输出：false
     示例 4：
    输入：s = "([)]"
    输出：false
     示例 5：
    输入：s = "{[]}"
    输出：true
     提示：
     1 <= s.length <= 104
     s 仅由括号 '()[]{}' 组成
     Related Topics 栈 字符串*/
    public static void main(String[] args) {
        String s = "([)]";
        boolean flag = isValid(s);
        System.out.println(flag);

    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            if(stack.size() == 0){
                return false;
            }
            Character pop = stack.pop();
            if (c == ')' && pop != '('){
                return false;
            }
            if (c == ']' && pop != '['){
                return false;
            }
            if (c == '}' && pop != '{'){
                return false;
            }
        }
        return stack.size() == 0;
    }

}
