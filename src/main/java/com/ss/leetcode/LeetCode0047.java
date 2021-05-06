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
public class LeetCode0047 {

    /*给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 提示：
 1 <= nums.length <= 8
 -10 <= nums[i] <= 10

 Related Topics 回溯算法*/
    public static void main(String[] args) {
        //int[] num = {10,1,2,7,6,1,5};
        int[] num = {1,1,2};
        List<List<Integer>> ints = permuteUnique(num);
        System.out.println(ints);

    }

    /*def backward():
    if (回朔点）：# 这条路走到底的条件。也是递归出口
        保存该结果
        return
    else:
        for route in all_route_set :  逐步选择当前节点下的所有可能route
            if 剪枝条件：
                剪枝前的操作
                return   #不继续往下走了，退回上层，换个路再走
            else：#当前路径可能是条可行路径
                保存当前数据  #向下走之前要记住已经走过这个节点了。例如push当前节点
                self.backward() #递归发生，继续向下走一步了。
                回朔清理     # 该节点下的所有路径都走完了，清理堆栈，准备下一个递归。例如弹出当前节点*/
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int[] flag = new int[nums.length];
        backTrace(result,nums,new ArrayList<>(),0,flag);
        return result;
    }

    private static void backTrace(List<List<Integer>> result, int[] nums, List<Integer> temp, int index, int[] flag) {
        //System.out.println(index +":" +temp );
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(index +":"+i+":" +temp );
            if(flag[i] == 1){
                continue;
            }
            /*if(i > 0 && nums[i] == nums[i-1] && nums[i-1] != 0){
                continue;
            }*/
            flag[i] = 1;
            temp.add(nums[i]);
            backTrace(result,nums,temp,i+1,flag);
            flag[i] = 0;
            temp.remove(temp.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }


}
