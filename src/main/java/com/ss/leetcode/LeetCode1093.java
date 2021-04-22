package com.ss.leetcode;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode1093 {
    /*我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 的采样个数。
     我们以 浮点数 数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。
     我们先来回顾一下中位数的知识：
     如果样本中的元素有序，并且元素数量为奇数时，中位数为最中间的那个元素；
     如果样本中的元素有序，并且元素数量为偶数时，中位数为中间的两个元素的平均值。
     示例 1：
     输入：count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    输出：[1.00000,3.00000,2.37500,2.50000,3.00000]
     示例 2：
     输入：count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    输出：[1.00000,4.00000,2.18182,2.00000,1.00000]
     提示：
     count.length == 256
     1 <= sum(count) <= 10^9
     计数表示的众数是唯一的
     答案与真实值误差在 10^-5 以内就会被视为正确答案
     Related Topics 数学 双指针*/
    public static void main(String[] args) {
        /*[4,7,9,7,6,7]
[5,0,0,6,1,6,2,2,4]*/
        int[] nums1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum += nums1[i] * i;
            count += nums1[i];

        }
        System.out.println(sum);
        System.out.println(count);
        int[] nums2 = {7,4,8};
        String s1 = "laiden";
        String s2 = "laiden";
        double[] area = sampleStats(nums1);
        System.out.println(area);

    }

    public static double[] sampleStats(int[] count) {
        double[] result = new double[5];
        int left = 0;
        int right = count.length - 1;
        int min = -1;
        int max = -1;
        long sum = 0 ;
        int totalCount = 0;
        int maxAppearIndex = -1;
        int maxTotalCount = 0;
        int leftValue = 0;
        int rightValue = 0;
        int balance = 0;
        while (left <= right){
            while (left <= right && count[left] == 0){
                left ++;
            }
            while (left <= right && count[right] == 0){
                right--;
            }
            if(left > right){
                break;
            }
            if(left == right){
                if(count[left] != 0 && min == -1){
                    min =  left;
                }
                if(count[right] != 0 && max == -1){
                    max =  right;
                }

                if(count[left] > maxTotalCount){
                    maxAppearIndex = left;
                    maxTotalCount = count[left];
                }
                if(count[right] > maxTotalCount){
                    maxAppearIndex = right;
                    maxTotalCount = count[right];
                }
                if(balance == 0){
                    sum += (long) count[right] * right;
                    totalCount += count[left];
                }
            }else{
                if(count[left] != 0 && min == -1){
                    min =  left;
                }
                if(count[right] != 0 && max == -1){
                    max =  right;
                }
                if(count[left] > maxTotalCount){
                    maxAppearIndex = left;
                    maxTotalCount = count[left];
                }
                if(count[right] > maxTotalCount){
                    maxAppearIndex = right;
                    maxTotalCount = count[right];
                }
                if(balance == 0){
                    balance += (count[left] - count[right]);
                    sum += (long) count[left] * left;
                    sum += (long) count[right] * right;
                    totalCount += count[left] + count[right];
                }else if(balance >0){
                    balance -= count[right];
                    sum += (long) count[right] * right;
                    totalCount += count[right];
                }else {
                    balance += count[left];
                    sum += (long) count[left] * left;
                    totalCount += count[left];
                }
            }
            if(balance > 0){
                leftValue = left;
                rightValue = left;
                right--;
            }else if(balance < 0){
                leftValue = right;
                rightValue = right;
                left ++;
            }else{
                leftValue = left;
                rightValue = right;
                left ++;
                right--;
            }
        }
        if(min == -1){
            return result;
        }
        result[0] = (double)min;
        result[1] = (double)max;
        result[2] = (double)sum/totalCount;
        result[3] = (double)(leftValue + rightValue)/2;
        result[4] = (double)maxAppearIndex;
        return result;
    }

}
