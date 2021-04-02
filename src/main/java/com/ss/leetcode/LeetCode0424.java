package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0424 {
    /*给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
     注意：字符串长度 和 k 不会超过 104。
     示例 1：
    输入：s = "ABAB", k = 2
    输出：4
    解释：用两个'A'替换为两个'B',反之亦然。
     示例 2：
    输入：s = "AABABBA", k = 1
    输出：4
    解释：
    将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
    子串 "BBBB" 有最长重复字母, 答案为 4。

 Related Topics 双指针 Sliding Window*/
    public static void main(String[] args) {
        int[] nums2 = {2,3,2,1};
        int area = characterReplacement("AAAABBAAB",3);
        System.out.println(area);

    }

    public static int characterReplacement(String s, int k) {
        if(s == null){
            return 0;
        }
        if(s.length() < k + 1){
            return s.length();
        }
        //由于只有26个大写字母，所以创建一个数组，用来存放，在滑动窗口中，每个大写字母的出现次数
        int[] letterArrays = new int[26];
        // 滑动窗口的大小 只要 左指针指向的字符 出现的次数 + k 比（左指针的下标-右指针的小标 + 1（3-0=3 其实出现4次）） 小
        // 则滑动窗口扩大，否则 就平移，右指针++，并且减掉原右指针指向的字符 出现次数-1
        int slidingWindow = 0;
        int left = 0;
        // 左指针 - 右指针 + 1
        int result = 0;
        for(int right = 0; right < s.length();right++){
            //当前字符-'A' 就能获取当前字符在 数组所对应的下标 直接++
            letterArrays[s.charAt(right) - 'A']++;
            slidingWindow = Math.max(slidingWindow,letterArrays[s.charAt(right) - 'A']);
            if(right - left + 1 - slidingWindow > k){
                letterArrays[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result,right - left + 1);
        }
        return result;
    }
}
