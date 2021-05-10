package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0011 {

    /*给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的    两个端点分别为 (i,
    ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     说明：你不能倾斜容器。
     示例 1：
    输入：[1,8,6,2,5,4,8,3,7]
    输出：49
    解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     示例 2：
    输入：height = [1,1]
    输出：1
     示例 3：
    输入：height = [4,3,2,1,4]
    输出：16
     示例 4：
    输入：height = [1,2,1]
    输出：2
     提示：
     n = height.length
     2 <= n <= 3 * 104
     0 <= height[i] <= 3 * 104
     Related Topics 数组 双指针*/
    public static void main(String[] args) {
        int[] nums2 = {1,8,6,2,5,4,8,3,7};
        int area = maxArea(nums2);
        System.out.println(area);

    }

    /**
     * 左右指针 ，只要哪边小，那边就往另一边靠，然后计算最大值。
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        //超时了，尴尬
        /*if(height == null || height.length == 0){
            return 0;
        }
        int max = 0;
        for(int i = 0 ; i < height.length -1 ; i++){
            for(int j = i+1 ; j < height.length ; j++){
                int a = Math.min(height[i],height[j]);
                int b = j - i;
                max = Math.max(max,a*b);
            }
        }
        return max;*/
        if(height == null || height.length == 0){
            return 0;
        }
        int max = 0;
        int head = 0;
        int tail = height.length-1;
        while (head < tail){
            int a = Math.min(height[head],height[tail]);
            int b = tail - head;
            max = Math.max(max,a*b);
            if(height[head]<height[tail]){
                head++;
            }else {
                tail--;
            }
        }
        return max;
    }

}
