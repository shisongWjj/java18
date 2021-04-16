package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0844 {
    /*给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 注意：如果对空文本输入退格字符，文本继续为空。
 示例 1：
输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
 示例 2：
输入：S = "ab##", T = "c#d#"
输出：true
解释：S 和 T 都会变成 “”。
 示例 3：
输入：S = "a##c", T = "#a#c"
输出：true
解释：S 和 T 都会变成 “c”。
 示例 4：
输入：S = "a#cc", T = "b"
输出：false
解释：S 会变成 “c”，但 T 仍然是 “b”。
 提示：
 1 <= S.length <= 200
 1 <= T.length <= 200
 S 和 T 只含有小写字母以及字符 '#'。
 进阶：
 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 Related Topics 栈 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {4,7,9,7,6,7};
        int[] nums2 = {-1,-2,-3,-4,-5};
        String s1 = "a#c#b";
        String s2 = "b";
        boolean area = backspaceCompare(s1,s2);
        System.out.println(area);

    }

    public static boolean backspaceCompare(String s, String t) {
        int first = s.length() -1;
        int second = t.length() -1;
        int firstCount = 0;
        int secondCount = 0;
        while (first >= 0 || second >= 0){
            first = jump(s,firstCount,first);
            second = jump(s,secondCount,second);
            if(first < 0 || second < 0){
                break;
            }
            if(s.charAt(first) == t.charAt(second)){
                first--;
                second--;
                continue;
            }
            return false;
        }
        return first == second;

    }

    private static int jump(String str, int count, int i) {
        while (i >= 0){
            char c = str.charAt(i);
            if(c == '#'){
                count ++;
            }else if(count > 0){
               count--;
            }else{
                break;
            }
            i--;
        }
        return i;
    }

}
