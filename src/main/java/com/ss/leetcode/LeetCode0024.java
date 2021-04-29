package com.ss.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0024 {

    /*给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]
 示例 2：
输入：head = []
输出：[]
 示例 3：
输入：head = [1]
输出：[1]
 提示：
 链表中节点的数目在范围 [0, 100] 内
 0 <= Node.val <= 100
 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 Related Topics 递归 链表*/
    public static void main(String[] args) {
        String s = "([)]";
        ListNode tail = new ListNode(2);
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(2,head1);
        ListNode head3 = new ListNode(3,head2);
        ListNode head4 = new ListNode(4,head3);
        ListNode head = new ListNode(1,head4);
        ListNode result = swapPairs(head);
        System.out.println(result);

    }


    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (head != null && head.next  != null){
            ListNode first = head;
            ListNode second = head.next;
            head = head.next.next;
            temp.next = second;
            temp = temp.next;
            temp.next = first;
            temp = temp.next;
            temp.next = null;
        }
        temp.next = head;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
