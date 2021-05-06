package com.ss.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0046 {

   /* 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     示例:
     输入: [1,2,3]
    输出:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
     Related Topics 回溯算法*/
    public static void main(String[] args) {
        //int[] num = {10,1,2,7,6,1,5};
        int[] num = {1,2,3};
        List<List<Integer>> ints = permute(num);
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
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] flag = new int[nums.length];
        dfs(result,nums,new ArrayList<>(),flag);
        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] nums, List<Integer> temp,int[] flag){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(temp);
            if(temp.size() == nums.length){
                return;
            }
            if(flag[i] == 1){
                continue;
            }
            flag[i] = 1;
            temp.add(nums[i]);
            dfs(result,nums,temp,flag);
            flag[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }

}
