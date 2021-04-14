package com.ss.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0838 {
   /* 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
     在开始时，我们同时把一些多米诺骨牌向左或向右推。
     每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
     同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
     如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
     就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
     给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = '
    R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
     返回表示最终状态的字符串。
     示例 1：
     输入：".L.R...LR..L.."
    输出："LL.RR.LLRRLL.."
     示例 2：
     输入："RR.L"
    输出："RR.L"
    说明：第一张多米诺骨牌没有给第二张施加额外的力。
     提示：
     0 <= N <= 10^5
     表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.';
     Related Topics 双指针 动态规划*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {-1,-2,-3,-4,-5};
        String s1 = ".L.R...LR..L..";
        String s2 = "eidbaooo";
        String area = pushDominoes(s1);
        System.out.println(area);

    }

    public static String pushDominoes(String dominoes) {
        if(dominoes == null || dominoes.length() <= 1){
            return dominoes;
        }
        int left = -1;
        int right = -1;
        int leftIndex = 0;
        int rightIndex = 0;
        char[] chars = dominoes.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '.'){
                continue;
            }else{
                left = right;
                right = i;
            }
            if(left == -1){
                if(c != 'L'){
                    continue;
                }
                while (leftIndex < right){
                    chars[leftIndex++] = 'L';
                }
            }else{
                if(chars[left] == chars[right]){
                    leftIndex = left;
                    while (leftIndex < right){
                        chars[leftIndex++] = c;
                    }
                }else if(chars[left] == 'R' && chars[right] == 'L'){
                    leftIndex = left;
                    rightIndex = right;
                    while (leftIndex < rightIndex){
                        chars[leftIndex++] = chars[left];
                        chars[rightIndex--] = chars[right];
                    }
                }
            }
        }
        if(right == -1){
            return dominoes;
        }
        rightIndex= right;
        while (chars[right] == 'R' && rightIndex < chars.length){
            chars[rightIndex++] = 'R';
        }
        return new String(chars);
    }

}
