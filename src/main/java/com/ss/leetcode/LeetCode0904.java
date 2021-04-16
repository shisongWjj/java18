package com.ss.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0904 {
    /*在一排树中，第 i 棵树产生 tree[i] 型的水果。
你可以从你选择的任何树开始，然后重复执行以下步骤：
 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 用这个程序你能收集的水果树的最大总量是多少？
 示例 1：
 输入：[1,2,1]
输出：3
解释：我们可以收集 [1,2,1]。
 示例 2：
 输入：[0,1,2,2]
输出：3
解释：我们可以收集 [1,2,2]
如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
 示例 3：
 输入：[1,2,3,2,2]
输出：4
解释：我们可以收集 [2,3,2,2]
如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
 示例 4：
 输入：[3,3,3,1,2,1,1,2,3,3,4]
输出：5
解释：我们可以收集 [1,2,1,1,2]
如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
 提示：
 1 <= tree.length <= 40000
 0 <= tree[i] < tree.length
 Related Topics 双指针
    leetcode submit region begin(Prohibit modification and deletion)*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {3,3,3,1,2,1,1,2,3,3,4};
        int[] nums2 = {7,4,8};
        String s1 = "a#c#b";
        String s2 = "b";
        int area = totalFruit(nums1);
        System.out.println(area);

    }

    public static int totalFruit(int[] tree) {
        if(tree == null){
            return 0;
        }
        if(tree.length <= 2){
            return tree.length;
        }
        int left = 0;
        int right = 0;
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while (right < tree.length){
            if (!map.containsKey(tree[right])){
                if(map.size()> 1){
                    for (Integer integer : map.keySet()) {
                        if(tree[right-1] != integer){
                            left = map.get(integer);
                            break;
                        }
                    }
                    map.remove(tree[left++]);
                }
            }
            map.put(tree[right],right);
            result = Math.max(result,right - left + 1);
            right ++;
        }
        return result;
    }

}
