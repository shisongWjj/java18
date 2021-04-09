package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0019 {

    /*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     进阶：你能尝试使用一趟扫描实现吗？
     示例 1：
    输入：head = [1,2,3,4,5], n = 2
    输出：[1,2,3,5]
     示例 2：
    输入：head = [1], n = 1
    输出：[]
     示例 3：
    输入：head = [1,2], n = 1
    输出：[1]
     提示：
     链表中结点的数目为 sz
     1 <= sz <= 30
     0 <= Node.val <= 100
     1 <= n <= sz
     Related Topics 链表 双指针
    */
    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(4,head1);
        ListNode head3 = new ListNode(3,head2);
        ListNode head4 = new ListNode(2,head3);
        ListNode head = new ListNode(1,head4);
        ListNode result = removeNthFromEnd(head,1);
        System.out.println(result);

    }


    /**
     * 方式二，快慢指针，先让快指针走n，然后一起走，当 快指针为null,慢指针所对应的那个节点就是要删除的
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0 ; i < n-1 ; i++){
            fast = fast.next;
            if(fast == null){
                return head;
            }
        }
        fast = fast.next;
        ListNode dummyList = new ListNode(0);
        ListNode result = dummyList;
        while (fast != null){
            result.next = slow;
            result = result.next;
            slow = slow.next;
            fast = fast.next;
            result.next = null;
        }
        result.next = slow.next;
        return dummyList.next;
    }

    /**
     * 方式一 先计算长度，
     * @param head
     * @param n
     * @return
     */
    /*public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        int size = 0;
        ListNode temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        if(n > size){
            return head;
        }
        int index = size - n;
        ListNode dummyList = new ListNode(0);
        ListNode result = dummyList;
        int i = 0;
        while (head != null){
            if(index == i){
                head = head.next;
                i++;
                continue;
            }
            result.next = head;
            result = result.next;
            head = head.next;
            result.next = null;
            i++;
        }
        return dummyList.next;
    }*/

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
