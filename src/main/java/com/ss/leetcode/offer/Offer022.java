package com.ss.leetcode.offer;

/**
 * Offer022
 *
 * @author shisong
 * @date 2021/4/27
 */
public class Offer022 {

    /*输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     示例：
    给定一个链表: 1->2->3->4->5, 和 k = 2.
    返回链表 4->5.
     Related Topics 链表 双指针*/

    public static void main(String[] args) {
        int[] nums1 = {-2147483648,1};
        int[] nums2 = {2147483647,0};
        ListNode tail = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head1.next = tail;
        head2.next = head1;
        head3.next = head2;
        head4.next = head3;
        ListNode ints = kthToLast(head4, 2);
        System.out.println(ints);
    }


    public static ListNode kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0 ; i < k ; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
