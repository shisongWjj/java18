package com.ss.leetcode;

import java.util.Stack;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0021 {

    /*将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     示例 1：
    输入：l1 = [1,2,4], l2 = [1,3,4]
    输出：[1,1,2,3,4,4]
     示例 2：
    输入：l1 = [], l2 = []
    输出：[]
     示例 3：
    输入：l1 = [], l2 = [0]
    输出：[0]
     提示：
     两个链表的节点数目范围是 [0, 50]
     -100 <= Node.val <= 100
     l1 和 l2 均按 非递减顺序 排列
     Related Topics 递归 链表*/
    public static void main(String[] args) {
        String s = "([)]";
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(2,head3);
        ListNode head = new ListNode(1,head4);


        ListNode tail3 = new ListNode(4);
        ListNode tail4 = new ListNode(3,tail3);
        ListNode tail = new ListNode(1,tail4);
        ListNode flag = mergeTwoLists(head,tail);
        System.out.println(flag);

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                node = node.next;
                l1 = l1.next;
                node.next = null;
            }else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
                node.next = null;
            }
        }
        if(l1 != null){
            node.next = l1;
        }
        if(l2 != null){
            node.next = l2;
        }
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
