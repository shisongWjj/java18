package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0074 {
   /* 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     每行中的整数从左到右按升序排列。
     每行的第一个整数大于前一行的最后一个整数。
     示例 1：
    输入：matrix = [
     [1,3,5,7],
     [10,11,16,20],
     [23,30,34,60]
     ], target = 3
    输出：true
     示例 2：
    输入：matrix = [
    [1,3,5,7],
    [10,11,16,20],
    [23,30,34,60]
    ], target = 13
    输出：false
     提示：
     m == matrix.length
     n == matrix[i].length
     1 <= m, n <= 100
     -104 <= matrix[i][j], target <= 104
     Related Topics 数组 二分查找*/
    public static void main(String[] args) {
        //int[] nums2 = {-1,0,1,2,-1,-4,-1,0,2,2,2};
        //int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        //int[] nums2 = {1,2,0,2,1,1,0,1,1};
        int[] nums2 = {0,0,1,1,2,2};
        int[][] num = {{1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        boolean flag = searchMatrix(num,13);
        System.out.println(flag);
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[m].length - 1;
        while (m < matrix.length && n >= 0){
            if(matrix[m][n] == target){
                return true;
            }else if(matrix[m][n] > target){
                n--;
            }else {
                m++;
            }
        }
        return false;
    }

}
