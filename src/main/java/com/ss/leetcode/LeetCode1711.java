package com.ss.leetcode;

import java.util.*;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode1711 {
    /*大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
     你可以搭配 任意 两道餐品做一顿大餐。
     给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
    餐 的数量。结果需要对 109 + 7 取余。
     注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
     示例 1：
    输入：deliciousness = [1,3,5,7,9]
    输出：4
    解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
    它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
     示例 2：
    输入：deliciousness = [1,1,1,3,3,3,7]
    输出：15
    解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
     提示：
     1 <= deliciousness.length <= 105
     0 <= deliciousness[i] <= 220
     Related Topics 数组 哈希表 双指针*/
    public static void main(String[] args) {
        int[] nums2 = {149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        int area = threeSumClosest(nums2,1);
        System.out.println(area);

    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int mod = 1000000007;
        List<Integer> result = new ArrayList<>(22);
        for (int i = 0; i <= 21; i++) {
            result.add(1 << i);
        }
        Map<Integer,Integer> temp = new HashMap<>();
        for (int num : nums) {
            if(temp.containsKey(num)){
                temp.put(num,temp.get(num)+1);
            }else{
                temp.put(num,1);
            }
        }
        long total = 0L;
        for (Integer key : temp.keySet()) {
            for (Integer sum : result) {
                int another = sum - key;
                if(another < 0){
                    continue;
                }
                Integer integer = temp.get(another);
                if(integer == null){
                    continue;
                }
                if(another == key){
                    total += (long)integer * (integer - 1) ;
                }else{
                    total += (long)integer * temp.get(key);
                }

            }
        }
        return (int) ((total/2) % mod);
    }
}
