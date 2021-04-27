package com.ss.leetcode.face;

/**
 * Face01606
 *
 * @author shisong
 * @date 2021/4/23
 */
public class Face01711 {

        /*有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，
    你能对此优化吗?
     示例：
     输入：words = ["I","am","a","student","from","a","university","in","a","city"],
    word1 = "a", word2 = "student"
    输出：1
     提示：
     words.length <= 100000
     Related Topics 双指针 字符串*/

    public static void main(String[] args) {
        int[] nums1 = {-2147483648,1};
        int[] nums2 = {2147483647,0};
        String[] nums = {"I","am","a","student","from","a","university","in","a","city"};
        //int[][] num = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        //int[][] num = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int ints = findClosest(nums, "a","student");
        System.out.println(ints);
    }


    public static int findClosest(String[] words, String word1, String word2) {
        if(words == null || words.length == 0){
            return 0;
        }
        int result = words.length;
        int first = -1;
        int second = -1;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)){
                first = i;
            }
            if(words[i].equals(word2)){
                second = i;
            }
            if(first != -1 && second !=-1){
                result = Math.min(Math.abs(second - first) , result);
            }
        }
        return result;
    }
}
