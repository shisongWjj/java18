package com.ss.leetcode;

/**
 * LeetCode0001
 *
 * @author shisong
 * @date 2019/10/10
 */
public class LeetCode0345 {
   /* 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     示例 1：
     输入："hello"
    输出："holle"
     示例 2：
     输入："leetcode"
    输出："leotcede"
     提示：
     元音字母不包含字母 "y" 。
     Related Topics 双指针 字符串*/

    public static void main(String[] args) {
        char[] nums = {'h','e','l','l','o'};
        String target = "leetcode";
        String s = reverseVowels(target);
        System.out.println(s);
    }

    /**
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right){
            while (!isYuanYin(s.charAt(left)) && left < right){
                 ++ left;
            }
            while (!isYuanYin(s.charAt(right))&& left < right){
                 -- right;
            }
            if(left < right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
        }
        return new String(chars);
    }

    private static boolean isYuanYin(char c){
        //'a','e','i','o','u','A','E','I','O','U'
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }
}
