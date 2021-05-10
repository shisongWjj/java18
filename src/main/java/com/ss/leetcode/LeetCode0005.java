package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0005 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        String s = "aaaa";
        String i = longestPalindrome(s);
        System.out.println(i);

    }

    /**
     * 创建一个二维数组,用来记录第i个字符到第j个字符是不是回文字符串。
     * 首先我们知道，第i,i字符肯定是回文字符串，第i,第i+1，个 只要两个相等就是回文字符串
     * 第i到j是不是回文字符串，只要判断 第i和第j个字符相等，并且第i+1到第j-1个字符串是回文字符串就可以了。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.equalsIgnoreCase("")){
            return "";
        }
        int length = s.length();
        if(length == 1){
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        int start = 0;
        int end = 0;
        for (int i = length - 2 ; i >= 0;i--){
            for (int j = i+1;j<length;j++){
                dp[i][i] = true;
                char a = s.charAt(i);
                char b = s.charAt(j);
                if(a != b){
                    dp[i][j] = false;
                    continue;
                }

                if((dp[i+1][j-1] || j-i < 3) ){
                    dp[i][j] = true;
                }
                if(dp[i][j] && (end-start) < (j-i)){
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start,end+1);
    }

}
