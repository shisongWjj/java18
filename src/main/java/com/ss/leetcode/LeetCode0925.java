package com.ss.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0925 {
    /*你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
     你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
     示例 1：
     输入：name = "alex", typed = "aaleex"
    输出：true
    解释：'alex' 中的 'a' 和 'e' 被长按。
     示例 2：
     输入：name = "saeed", typed = "ssaaedd"
    输出：false
    解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
     示例 3：
     输入：name = "leelee", typed = "lleeelee"
    输出：true
     示例 4：
     输入：name = "laiden", typed = "laiden"
    输出：true
    解释：长按名字中的字符并不是必要的。
     提示：
     name.length <= 1000
     typed.length <= 1000
     name 和 typed 的字符都是小写字母。
     Related Topics 双指针 字符串*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {0,0,0};
        int[] nums2 = {7,4,8};
        String s1 = "laiden";
        String s2 = "laiden";
        boolean area = isLongPressedName(s1,s2);
        System.out.println(area);

    }

    public static boolean isLongPressedName(String name, String typed) {
        if(name == null && typed == null){
            return true;
        }
        if(typed == null){
            return false;
        }
        if(name.length() > typed.length()){
            return false;
        }
        int min = 0;
        int max = 0;
        char pressedName = 'A';
        while (min < name.length() && max < typed.length()){
            if(name.charAt(min) == typed.charAt(max)){
                pressedName = typed.charAt(max);
                min++;
                max++;
            }else {
                if(typed.charAt(max) != pressedName){
                    return false;
                }
                max ++;
            }
        }
        while (max < typed.length()){
            if(typed.charAt(max) != pressedName){
                return false;
            }
            max ++;
        }
        return min == name.length();
    }

}
