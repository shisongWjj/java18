package com.ss.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0022 {

    /*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     示例 1：
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
     示例 2：
    输入：n = 1
    输出：["()"]
     提示：
     1 <= n <= 8
     Related Topics 字符串 回溯算法*/
    public static void main(String[] args) {
        String s = "([)]";
        List<String> flag = generateParenthesis(3);
        System.out.println(flag);

    }


    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result,0,0,n,"");
        return result;
    }

    private static void dfs(List<String> result,int left,int right,int n,String s){
        if(s.length() == n * 2){
            result.add(s);
            return;
        }
        if(left < right){
            return;
        }
        System.out.println(s);
        if(left < n){
            dfs(result,left+1,right,n,s + "(");
        }
        if(right < n){
            dfs(result,left,right+1,n,s + ")");
        }
    }
}
