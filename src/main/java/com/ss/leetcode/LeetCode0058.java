package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0058 {

    /*给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
     单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     示例 1：
    输入：s = "Hello World"
    输出：5
     示例 2：
    输入：s = " "
    输出：0
     提示：
     1 <= s.length <= 104
     s 仅有英文字母和空格 ' ' 组成
     Related Topics 字符串*/
    public static void main(String[] args) {
        int[] num = {2,3,1,1,4};
        int ints = lengthOfLastWord("a ");
        System.out.println(ints);

    }

    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int right = s.length()- 1;
        if(s.endsWith(" ")){
            while (right >=0){
                if(s.charAt(right) == ' '){
                    right--;
                }else {
                    break;
                }
            }
        }
        s = s.substring(0,right+1);
        while (right >= 0){
            if(s.charAt(right) != ' '){
                right--;
            }else {
                break;
            }

        }
        return s.length() - right -1;
    }

}
