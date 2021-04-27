package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode1750 {
   /* 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 前缀和后缀在字符串中任意位置都不能有交集。
 前缀和后缀包含的所有字符都要相同。
 同时删除前缀和后缀。
 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
 示例 1：
输入：s = "ca"
输出：2
解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
 示例 2：
输入：s = "cabaabac"
输出：0
解释：最优操作序列为：
- 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
- 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
- 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。
 示例 3：
输入：s = "aabccabba"
输出：3
解释：最优操作序列为：
- 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
- 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
 提示：
 1 <= s.length <= 105
 s 只包含字符 'a'，'b' 和 'c' 。
 Related Topics 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {100,10,1};
        int[] nums2 = {7,4,8};
        String s1 = "cabaabac";
        String s2 = "yqcnfjajiiczbzgcziiriyhfxlqrdtijusntxzazzxncqnuyryrognehxsgkmkzgtmtpdpkffxqvgtmcifissukj";
        int area = minimumLength(s1);
        System.out.println(area);

    }

    public static int minimumLength(String s) {
        if(s.length() ==1){
            return s.length();
        }
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            char a = s.charAt(left);
            char b = s.charAt(right);
            if(a != b){
                break;
            }
            left ++;
            right --;
            while (a == s.charAt(left) && left < right){
                left++;
            }
            while (b == s.charAt(right)&& left - 1 < right){
                right--;
            }
        }
        return left > right ? 0 : right - left + 1;

    }
}
