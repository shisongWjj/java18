package com.ss.leetcode.face;

import java.util.Arrays;

/**
 * Face01606
 *
 * @author shisong
 * @date 2021/4/23
 */
public class Face01009 {

    /*给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
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
 Related Topics 双指针 二分查找 分治算法*/

    public static void main(String[] args) {
        int[] nums1 = {-2147483648,1};
        int[] nums2 = {2147483647,0};
        //int[][] num = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        //int[][] num = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int[][] num = {{}};
        boolean ints = searchMatrix(num, -5);
        System.out.println(ints);
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int m = 0;
        int n = matrix[0].length - 1;
        while (m <= matrix.length - 1 && n >= 0){
            if(matrix[m][n] == target){
                return true;
            }else if(matrix[m][n] < target){
                m++;
            }else {
                n--;
            }
        }
        return false;
    }
}
