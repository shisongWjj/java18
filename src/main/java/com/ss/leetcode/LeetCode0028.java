package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0028 {

    /*实现 strStr() 函数。
     给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
    果不存在，则返回 -1。
     示例 1:
     输入: haystack = "hello", needle = "ll"
    输出: 2
     示例 2:
     输入: haystack = "aaaaa", needle = "bba"
    输出: -1
     说明:
     当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     Related Topics 双指针 字符串*/
    public static void main(String[] args) {
        //int[] nums2 = {-1,0,1,2,-1,-4,-1,0,2,2,2};
        //int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        //int[] nums2 = {3,2,2,3};
        String haystack = "mississippi";
        String needle = "issip";
        int area = strStr(haystack,needle);
        System.out.println(area);
    }


    /**
     * 双指针实现
     * 在haystack找到needle的头一个字符，然后将left等于当前下标
     * 之后逐一对比，只要都相等就返回left
     * 只要有一个不相等，就将计数器重置为0，并将右指针移到左指针处。
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.equals("")){
            return 0;
        }
        if(haystack == null || haystack.equals("")){
            return -1;
        }
        int left = 0;
        int index = 0;
        for (int right = 0; right < haystack.length(); right ++){
            if(haystack.charAt(right) == needle.charAt(index)){
                index ++;
                if(index == needle.length()){
                    return left;
                }
            }else{
                right = left;
                left ++;
                index = 0;
            }
        }
        return -1;

    }

}
