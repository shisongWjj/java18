package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0125 {
    /*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     说明：本题中，我们将空字符串定义为有效的回文串。
     示例 1:
     输入: "A man, a plan, a canal: Panama"
    输出: true
     示例 2:
     输入: "race a car"
    输出: false
    Related Topics 双指针 字符串*/
    public static void main(String[] args) {
        int[] nums2 = {2,3,2,1};
        boolean area = isPalindrome("race a car");
        System.out.println(area);

    }

    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 1){
            return true;
        }
        s = s.toLowerCase();
        int head = 0;
        int tail = s.length()-1;
        while (head < tail){
            char a = s.charAt(head);
            char b = s.charAt(tail);
            if(!((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z'))){
                head++;
                continue;
            }
            if(!((b >= '0' && b <= '9') || (b >= 'a' && b <= 'z'))){
                tail--;
                continue;
            }
            if(a != b){
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
