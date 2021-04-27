package com.ss.leetcode.face;

/**
 * Face01606
 *
 * @author shisong
 * @date 2021/4/23
 */
public class Face00204 {

    /*编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
    分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
     示例:
     输入: head = 3->5->8->5->10->2->1, x = 5
    输出: 3->1->2->10->5->5->8
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
        ListNode ints = partition(head4, 3);
        System.out.println(ints);
    }


    public static  ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);
        ListNode small = smallDummy;
        ListNode big = bigDummy;
        while (head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
                head = head.next;
                small.next = null;
            }else {
                big.next = head;
                big = big.next;
                head = head.next;
                big.next = null;
            }
        }
        small.next = bigDummy.next;
        return smallDummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
