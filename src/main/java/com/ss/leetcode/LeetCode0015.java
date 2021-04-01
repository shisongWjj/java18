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
public class LeetCode0015 {

    /*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
    复的三元组。
     注意：答案中不可以包含重复的三元组。
     示例 1：
    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
     示例 2：
    输入：nums = []
    输出：[]
     示例 3：
    输入：nums = [0]
    输出：[]
     提示：
     0 <= nums.length <= 3000
     -105 <= nums[i] <= 105
     Related Topics 数组 双指针*/
    public static void main(String[] args) {
        //int[] nums2 = {-1,0,1,2,-1,-4,-1,0,2,2,2};
        int[] nums2 = {-1,0,1,2,-1,-4};
        List<List<Integer>>  area = threeSum(nums2);
        System.out.println(area);

    }


    /**
     * 解题思路，先将数组 排序
     * 如果第一个就大于0，那么就直接返回
     * 如果最后一个就小于0，那么就直接返回
     * 获取第一个值，作为固定值，如果固定值大于0，就直接结束循环
     * 然后双指针，一个从N+1开始，一个从尾部开始，
     * 如果相加 小于0 则头部向后移动，如果大于0，则尾部向前移动，直到尾指针小于等于头指针
     *
     *
     * @param nums 数组
     * @return 结果集
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length <3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if(nums[0]>0 || nums[nums.length-1] < 0){
            return new ArrayList<>();
        }
        int head,tail;
        int fixedValue;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 1 ;i++){
            fixedValue = nums[i];
            if(fixedValue > 0){
                break;
            }
            if(i>0 && fixedValue == nums[i-1]){
                continue;
            }
            head = i + 1;
            tail = nums.length - 1;
            while (head < tail){
                int a = nums[head];
                int b = nums[tail];
                if(fixedValue + a + b == 0){
                    result.add(Arrays.asList(fixedValue,a,b));
                    //针对重复数据做处理
                    while (head < tail && nums[head] == nums[head+1]){
                        head+=1;
                    }
                    while (head < tail && nums[tail] == nums[tail-1]){
                        tail-=1;
                    }
                    tail--;
                    head++;
                }else if(fixedValue + a + b > 0){
                    tail--;
                }else {
                    head++;
                }
            }

        }
        return result;

    }

}
