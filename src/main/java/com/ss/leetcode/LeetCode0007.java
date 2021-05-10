package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0007 {

    /*给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
    假设环境不允许存储 64 位整数（有符号或无符号）。
    示例 1：
    输入：x = 123
    输出：321

    示例 2：
    输入：x = -123
    输出：-321

    示例 3：
    输入：x = 120
    输出：21

    示例 4：
    输入：x = 0
    输出：0
     
    提示：
    -231 <= x <= 231 - 1

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-integer
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int i = reverse(6541546);
        System.out.println(i);

    }

    /**
     * 每次都获取数字的个位，然后将返回值*10 + 当前数字，
     * 然后 对数字 除以10取整，最后对边界进行判断
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long result = 0;
        while(x != 0){
            int i = x % 10;
            result = result*10 + i;
            x = x/10;

        }
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE){
            return 0;
        }
        return (int)result;
    }

}
