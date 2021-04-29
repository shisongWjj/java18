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
public class LeetCode0039 {

    /*给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     candidates 中的数字可以无限制重复被选取。
     说明：
     所有数字（包括 target）都是正整数。
     解集不能包含重复的组合。
     示例 1：
     输入：candidates = [2,3,6,7], target = 7,
    所求解集为：
    [
      [7],
      [2,2,3]
    ]
     示例 2：
     输入：candidates = [2,3,5], target = 8,
    所求解集为：
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]
     提示：
     1 <= candidates.length <= 30
     1 <= candidates[i] <= 200
     candidate 中的每个元素都是独一无二的。
     1 <= target <= 500
     Related Topics 数组 回溯算法*/
    public static void main(String[] args) {
        int[] num = {2,3,6,7};
        List<List<Integer>> ints = combinationSum(num,7);
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
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(result,candidates,target,0,new ArrayList<>());
        return result;
    }

    private static void combinationSum(List<List<Integer>> result,int[] candidates,int target,int index,List<Integer> temp){
        if(target  == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            if( target - candidates[i] < 0){
                return;
            }
            temp.add(candidates[i]);
            combinationSum(result,candidates,target - candidates[i],i,temp);
            temp.remove(temp.size()-1);
        }
    }

}
