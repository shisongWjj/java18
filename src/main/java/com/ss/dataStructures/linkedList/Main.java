package com.ss.dataStructures.linkedList;

import com.ss.leetcode.LeetCode0002;

/**
 * Mian
 *
 * @author shisong
 * @date 2019/4/11
 */
public class Main {

    public static void main(String[] args) {
        /*LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(666, 2);
        System.out.println(linkedList);*/

        LeetCode0002 temp = new LeetCode0002();
        LeetCode0002.ListNode node = temp.new ListNode(0);
        LeetCode0002.ListNode cursor = node;
        LeetCode0002.ListNode listNode = temp.new ListNode(2);
        cursor.next = listNode;
        cursor = listNode;

        LeetCode0002.ListNode listNode2 = temp.new ListNode(4);
        cursor.next = listNode2;
        cursor = listNode2;

        LeetCode0002.ListNode listNode3 = temp.new ListNode(3);
        cursor.next = listNode3;
        cursor = listNode3;
        System.out.println(node);
    }

}
