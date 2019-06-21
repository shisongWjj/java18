package com.ss.dataStructures.stack;

import java.util.Stack;

/**
 * Solution
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @author shisong
 * @date 2019/4/9
 */
public class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ']') {
                    if (pop.equals('[')) {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (c == '}') {
                    if (pop.equals('{')) {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (c == ')') {
                    if (pop.equals('(')) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[[[[]]]]]"));
    }

}
