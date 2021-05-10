package com.ss.leetcode;

/**
 * LeetCode0001
 *
 * @author shisong
 * @date 2019/10/10
 */
public class LeetCode0374 {
    /*猜数字游戏的规则如下：
 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 -1：我选出的数字比你猜的数字小 pick < num
 1：我选出的数字比你猜的数字大 pick > num
 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 返回我选出的数字。
 示例 1：
输入：n = 10, pick = 6
输出：6
 示例 2：
输入：n = 1, pick = 1
输出：1
 示例 3：
输入：n = 2, pick = 1
输出：1
 示例 4：
输入：n = 2, pick = 2
输出：2
 提示：


 1 <= n <= 231 - 1
 1 <= pick <= n

 Related Topics 二分查找*/

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int result = guessNumber(10);
        System.out.println(result);
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high){
            int mid = low + (high - low)/2;
            int guess = guess(mid);
            if(guess == 0){
                return mid;
            }
            if(guess == -1){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }



    private static int guess(int num){
        int pick = 6;
        if(pick == num){
            return 0;
        }
        if(pick < num){
            return -1;
        }
        return 1;
    }
}
