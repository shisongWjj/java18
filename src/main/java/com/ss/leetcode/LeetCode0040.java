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
public class LeetCode0040 {

    /*给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     candidates 中的每个数字在每个组合中只能使用一次。
     说明：
     所有数字（包括目标数）都是正整数。
     解集不能包含重复的组合。
     示例 1:
     输入: candidates = [10,1,2,7,6,1,5], target = 8,
    所求解集为:
    [
      [1, 7],
      [1, 2, 5],
      [2, 6],
      [1, 1, 6]
    ]
     示例 2:
     输入: candidates = [2,5,2,1,2], target = 5,
    所求解集为:
    [
      [1,2,2],
      [5]
    ]
     Related Topics 数组 回溯算法*/
    public static void main(String[] args) {
        //int[] num = {10,1,2,7,6,1,5};
        int[] num = {1,1,2,5,6,7,10};
        List<List<Integer>> ints = combinationSum2(num,8);
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
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrace(result,candidates,target,0,new ArrayList<>());
        return result;
    }

    private static void backTrace(List<List<Integer>> result, int[] candidates, int target, int index, List<Integer> temp) {
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            System.out.println(temp + ":" + index +":" + i);
            if(target - candidates[i] < 0){
                return;
            }
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            backTrace(result,candidates,target-candidates[i],i + 1,temp);
            temp.remove(temp.size() -1 );
        }
    }


}
