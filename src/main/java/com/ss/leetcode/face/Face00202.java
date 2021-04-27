package com.ss.leetcode.face;

import java.util.Arrays;

/**
 * Face01606
 *
 * @author shisong
 * @date 2021/4/23
 */
public class Face00202 {

    /*实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     注意：本题相对原题稍作改动
     示例：
     输入： 1->2->3->4->5 和 k = 2
    输出： 4
     说明：
     给定的 k 保证是有效的。
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
        int ints = kthToLast(head4, 2);
        System.out.println(ints);
    }


    public static int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0 ; i < k ; i ++){
            fast = fast.next;
        }
        while (fast != null){
            fast  = fast.next;
            slow  = slow.next;
        }
        return slow.val;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
