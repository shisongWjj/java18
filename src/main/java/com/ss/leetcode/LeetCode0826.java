package com.ss.leetcode;

import com.ss.dataStructures.array.Array;

import java.util.Arrays;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0826 {
    /*有一些工作：difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 我们能得到的最大收益是多少？
 示例：
 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
输出: 100
解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 提示:
 1 <= difficulty.length = profit.length <= 10000
 1 <= worker.length <= 10000
 difficulty[i], profit[i], worker[i] 的范围是 [1, 10^5]

 Related Topics 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        /*[7,20,68]
[26,28,57]
[71,20,71]*/
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        int area = maxProfitAssignment(difficulty,profit,worker);
        System.out.println(area);

    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Job[] jobs = new Job[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i] = new Job(difficulty[i],profit[i]);
        }
        Arrays.sort(worker);
        Arrays.sort(jobs,(a,b)->{
            return a.difficult-b.difficult;
        });
        int count = 0;
        int left = 0;
        int right = 0;
        int top = 0;
        while (right < worker.length){
            int diff = jobs[left].difficult;
            while (diff <= worker[right]){
                top = Math.max(top,jobs[left].pro);
                left++;
                if(left == jobs.length){
                    break;
                }
                diff = jobs[left].difficult;
            }
            count += top;
            right++;
            if(left != 0){
                left--;
            }
        }
        return count;

    }

    public static class Job{
        public int difficult;
        public int pro;

        public Job(int difficult, int pro) {
            this.difficult = difficult;
            this.pro = pro;
        }
    }
}
