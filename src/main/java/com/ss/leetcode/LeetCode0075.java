package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0075 {
    /*
        给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     示例 1：
    输入：nums = [2,0,2,1,1,0]
    输出：[0,0,1,1,2,2]
     示例 2：
    输入：nums = [2,0,1]
    输出：[0,1,2]
     示例 3：
    输入：nums = [0]
    输出：[0]
     示例 4：
    输入：nums = [1]
    输出：[1]
     提示：
     n == nums.length
     1 <= n <= 300
     nums[i] 为 0、1 或 2
     进阶：
     你可以不使用代码库中的排序函数来解决这道题吗？
     你能想出一个仅使用常数空间的一趟扫描算法吗？
     Related Topics 排序 数组 双指针*/
    public static void main(String[] args) {
        //int[] nums2 = {-1,0,1,2,-1,-4,-1,0,2,2,2};
        //int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        //int[] nums2 = {1,2,0,2,1,1,0,1,1};
        int[] nums2 = {0,0,1,1,2,2};
        sortColors(nums2);

    }


    public static void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right){
            int temp = nums[index];
            if(index < left){
                index ++;
            }else if(temp == 0){
                nums[index] = nums[left];
                nums[left] = 0;
                left ++;
            }else if(temp == 2){
                nums[index] = nums[right];
                nums[right] = 2;
                right --;
            }else{
                index ++;
            }

        }
        System.out.println(nums);

    }

}
