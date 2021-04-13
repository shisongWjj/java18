package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0234 {
    /*请判断一个链表是否为回文链表。
     示例 1:
     输入: 1->2
    输出: false
     示例 2:
     输入: 1->2->2->1
    输出: true
     进阶：
    你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     Related Topics 链表 双指针*/
    public static void main(String[] args) {
        ListNode tail = new ListNode(1);
        ListNode head1 = new ListNode(2,tail);
        ListNode head2 = new ListNode(3,head1);
        ListNode head3 = new ListNode(3,head2);
        ListNode head4 = new ListNode(2,head3);
        ListNode head = new ListNode(1,tail);
        boolean result = isPalindrome(head);
        System.out.println(result);

    }


    /**
     * 1 通过快慢指针 获取到中点
     * 2 反转慢指针
     * 3 将反转后的慢指针与head 对比，只要慢指针不为null
     * @param head
     * @return
     */
    public static  boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        if(head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;

        ListNode current = temp.next;
        slow.next = null;
        while (current != null){
            temp = current;
            current = current.next;
            temp.next = slow;
            slow = temp;
        }
        while (slow != null){
            if(slow.val != head.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
