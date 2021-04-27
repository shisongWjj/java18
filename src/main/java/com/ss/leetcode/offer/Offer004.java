package com.ss.leetcode.offer;

/**
 * Offer022
 *
 * @author shisong
 * @date 2021/4/27
 */
public class Offer004 {

   /* 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 示例:
 现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
 给定 target = 5，返回 true。
 给定 target = 20，返回 false。
 限制：
 0 <= n <= 1000
 0 <= m <= 1000
 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 [
 [1,3,5,7,9],
 [2,4,6,8,10],
 [11,13,15,17,19],
 [12,14,16,18,20],
 [21,22,23,24,25]
 ]
 Related Topics 数组 双指针*/

    public static void main(String[] args) {
        int[] nums1 = {-2147483648,1};
        int[] nums2 = {2147483647,0};
        int[][] num = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        //int[][] num = {{}};[[1,3,5,7,9],[2,4,6,8,10],[11,13,15,17,19],[12,14,16,18,20],[21,22,23,24,25]]
        //8
        //int[][] num = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        boolean ints = findNumberIn2DArray(num, 20);
        System.out.println(ints);
    }


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int m = 0;
        int n = matrix[m].length -1;
        if(n < 0){
            return false;
        }
        while (m <= matrix.length -1 && n >= 0){
            if(matrix[m][n] == target){
                return true;
            }
            System.out.println(matrix[m][n]);
            if(target > matrix[m][n]){
                m++;
            }else{
                n--;
            }
        }
        return false;

    }

}
