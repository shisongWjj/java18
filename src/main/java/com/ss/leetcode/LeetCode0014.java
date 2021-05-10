package com.ss.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0014 {

    /*编写一个函数来查找字符串数组中的最长公共前缀。
     如果不存在公共前缀，返回空字符串 ""。
     示例 1：
    输入：strs = ["flower","flow","flight"]
    输出："fl"
     示例 2：
    输入：strs = ["dog","racecar","car"]
    输出：""
    解释：输入不存在公共前缀。
     提示：
     0 <= strs.length <= 200
     0 <= strs[i].length <= 200
     strs[i] 仅由小写英文字母组成
     Related Topics 字符串*/
    public static void main(String[] args) {
        //int[] nums2 = {-1,0,1,2,-1,-4,-1,0,2,2,2};
        String[] nums2 = {"flower","flow","flight"};
        String area = longestCommonPrefix(nums2);
        System.out.println(area);

    }

    /**
     * 暴力算法，先取第一个和第二个的公共前缀，然后按照公共前缀去和之后的比
     * 最后拿到结果。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length  == 0){
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = longestCommonPrefix(result,strs[i]);
            if(result.equals("")){
                return result;
            }
        }
        return result;
    }

    private static String longestCommonPrefix(String s1,String s2){
        if(s1 == null || s1.length() ==0){
            return "";
        }
        if(s2 == null || s2.length() ==0){
            return "";
        }
        int first = 0;
        int second = 0;
        while (first < s1.length() && second < s2.length()){
            if(s1.charAt(first) == s2.charAt(second)){
                first ++;
                second++;
            }else {
                break;
            }
        }
        return s1.substring(0,first);
    }

}
