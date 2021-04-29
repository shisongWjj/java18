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
public class LeetCode0066 {

   /* 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     你可以假设除了整数 0 之外，这个整数不会以零开头。
     示例 1：
    输入：digits = [1,2,3]
    输出：[1,2,4]
    解释：输入数组表示数字 123。
     示例 2：
    输入：digits = [4,3,2,1]
    输出：[4,3,2,2]
    解释：输入数组表示数字 4321。
     示例 3：
    输入：digits = [0]
    输出：[1]
     提示：
     1 <= digits.length <= 100
     0 <= digits[i] <= 9
     Related Topics 数组*/
    public static void main(String[] args) {
        int[] num = {1,1,1,1,1,1,1,1,1,1};
        int[] result = plusOne(num);
        System.out.println(result);

    }



    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }
        }
        //走到这里 说明每个数字都是9
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

}
