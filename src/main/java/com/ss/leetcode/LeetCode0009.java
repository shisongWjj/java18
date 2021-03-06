package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0009 {

    /*给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     示例 1：
    输入：x = 121
    输出：true
     示例 2：
    输入：x = -121
    输出：false
    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     示例 3：
    输入：x = 10
    输出：false
    解释：从右向左读, 为 01 。因此它不是一个回文数。
     示例 4：
    输入：x = -101
    输出：false
     提示：
     -231 <= x <= 231 - 1
     进阶：你能不将整数转为字符串来解决这个问题吗？
     Related Topics 数学*/
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        boolean flag = isPalindrome(121);
        System.out.println(flag);

    }

    /**
     * 根据题意，负数肯定不是回文数字
     * 然后按照题7走一遍，判断 反转后的数字和原数字是否相等，相等就是回文
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int origin = x;
        int result = 0;
        while (x != 0){
            int temp = x % 10;
            result = result * 10 + temp;
            x = x / 10;
        }
        return result == origin;
    }

}
