package com.ss.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0017 {

   /* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 示例 2：
输入：digits = ""
输出：[]
 示例 3：
输入：digits = "2"
输出：["a","b","c"]
 提示：
 0 <= digits.length <= 4
 digits[i] 是范围 ['2', '9'] 的一个数字。
 Related Topics 深度优先搜索 递归 字符串 回溯算法*/
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        List<String>  flag = isPalindrome("23");
        System.out.println(flag);

    }

    /**
     * 先创建一个map，将数字与字母的关系，组合起来
     * 根据数字，拿到所以的字母，放到list中
     * 然后 循环遍历字母的list，进行拼接，通过两个list 互相赋值。
     * @param digits
     * @return
     */
    public static List<String> isPalindrome(String digits) {
        if(digits == null || digits.length() ==0){
            return new ArrayList<>();
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < digits.toCharArray().length; i++) {
            temp.add(map.get(digits.charAt(i)));
        }
        List<String> result = new ArrayList<>();
        List<String> resultTemp = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            String s = temp.get(i);
            if(i == 0){
                for (int j = 0; j < s.toCharArray().length; j++) {
                    result.add(String.valueOf(s.charAt(j)));
                }
            }else{
                result = new ArrayList<>();
                for (String s1 : resultTemp) {
                    for(int j = 0 ; j < s.length() ; j++){
                        result.add(s1 + String.valueOf(s.charAt(j)));
                    }
                }
            }
            resultTemp = result;
        }
        return result;
    }
}
