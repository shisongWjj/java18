package com.ss.leetcode;

/**
 * LeetCode0004
 *
 * @author shisong
 * @date 2019/10/11
 */
public class LeetCode0004 {

    /*
    给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     示例 1：
    输入：nums1 = [1,3], nums2 = [2]
    输出：2.00000
    解释：合并数组 = [1,2,3] ，中位数 2
     示例 2：
    输入：nums1 = [1,2], nums2 = [3,4]
    输出：2.50000
    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     示例 3：
    输入：nums1 = [0,0], nums2 = [0,0]
    输出：0.00000
     示例 4：
    输入：nums1 = [], nums2 = [1]
    输出：1.00000
     示例 5：
    输入：nums1 = [2], nums2 = []
    输出：2.00000
     提示：
     nums1.length == m
     nums2.length == n
     0 <= m <= 1000
     0 <= n <= 1000
     1 <= m + n <= 2000
     -106 <= nums1[i], nums2[i] <= 106
     进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     Related Topics 数组 二分查找 分治算法*/

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double i = findMedianSortedArrays(nums1,nums2);
        System.out.println(i);

    }

    /**
     * 由于原本两数组就是 非递减数组，所以将两数组组合成一个非递减数组。
     * 新数组 如果是奇数，就获取中间那个
     * 如果是偶数，就两个数 相加 除以2
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n == 0 && m == 0){
            return 0D;
        }
        int[] x = new int[m+n];
        if(n == 0){
            x = nums2;
        }else if(m == 0){
            x = nums1;
        }else {
            int index1 = 0;
            int index = 0;
            for(int i = 0; i < n;){
                for(int y = index1; y < m; ){
                    if(nums1[i]<=nums2[y]){
                        x[index] = nums1[i];
                        i++;
                        index ++;
                        break;
                    }
                    if(nums1[i]>nums2[y]){
                        x[index] = nums2[y];
                        y++;
                        index1++;
                        index ++;
                    }
                }
                if(index < (m+n) && index1 == m){
                    x[index] = nums1[i];
                    i++;
                    index ++;
                }
            }
            if(index < (m+n) ){
                for(int y = index1; y < m; ){
                    x[index] = nums2[y];
                    y++;
                    index1++;
                    index ++;
                }
            }
        }

        if(x.length % 2 == 0){
            return (double) (x[x.length / 2] + x[x.length / 2 -1]) / 2d;
        }else{
            return (double) x[x.length / 2 ];
        }
    }
}
