package com.ss.dataStructures.tree;

/**
 * Main
 *
 * @author shisong
 * @date 2019/4/26
 */
public class Main {

    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();
        //BST
        //System.out.println(bst.getClass().getSimpleName());
    }

}
