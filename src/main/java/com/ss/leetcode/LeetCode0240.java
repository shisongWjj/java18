package com.ss.leetcode;

/**
 * Offer022
 *
 * @author shisong
 * @date 2021/4/27
 */
public class LeetCode0240 {

    /*编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     每行的元素从左到右升序排列。
     每列的元素从上到下升序排列。
     示例 1：
    输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
    ,23,26,30]], target = 5
    输出：true
     示例 2：
    输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
    ,23,26,30]], target = 20
    输出：false
     提示：
     m == matrix.length
     n == matrix[i].length
     1 <= n, m <= 300
     -109 <= matix[i][j] <= 109
     每行的所有元素从左到右升序排列
     每列的所有元素从上到下升序排列
     -109 <= target <= 109
     Related Topics 二分查找 分治算法*/

    public static void main(String[] args) {
        int[] nums1 = {-2147483648,1};
        int[] nums2 = {2147483647,0};
        int[][] num = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        //int[][] num = {{}};[[1,3,5,7,9],[2,4,6,8,10],[11,13,15,17,19],[12,14,16,18,20],[21,22,23,24,25]]
        //8
        //int[][] num = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        boolean ints = searchMatrix(num, 20);
        System.out.println(ints);
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[m].length - 1;
        while (m < matrix.length && n >= 0){
            if(matrix[m][n] == target){
                return true;
            }
            if(matrix[m][n] > target){
                n --;
            }else {
                m ++;
            }
        }
        return false;
    }

}
