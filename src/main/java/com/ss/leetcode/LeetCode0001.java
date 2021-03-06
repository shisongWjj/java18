package com.ss.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode0001
 *
 * @author shisong
 * @date 2019/10/10
 */
public class LeetCode0001 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] ints = twoSum(nums, target);
        System.out.println(ints);
    }

    /**
     * 解题思路
     * 创建一个map key: target-当前数组值 value的值是 - 当前数组值的下标
     * 循环数组，判断当前数组的值所对应的key 是否存在
     * 存在就直接获取到， 不存在就放入map 中
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0 ; i< nums.length;i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = hash.get(nums[i]);
                indexs[1] = i;
                return indexs;
            }
            hash.put(target-nums[i],i);
        }
        return indexs;
    }
}
