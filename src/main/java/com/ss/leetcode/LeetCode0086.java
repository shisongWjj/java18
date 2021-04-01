package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0086 {
    /*给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     你应当 保留 两个分区中每个节点的初始相对位置。
     示例 1：
    输入：head = [1,4,3,2,5,2], x = 3
    输出：[1,2,2,4,3,5]
     示例 2：
    输入：head = [2,1], x = 2
    输出：[1,2]

     提示：
     链表中节点的数目在范围 [0, 200] 内
     -100 <= Node.val <= 100
     -200 <= x <= 200
     Related Topics 链表 双指针*/
    public static void main(String[] args) {
        //int[] nums2 = {-1,0,1,2,-1,-4,-1,0,2,2,2};
        /*int[] nums2 = {-1,0,1,2,-1,-4};
        List<List<Integer>>  area = hasCycle(nums2);
        System.out.println(area);*/
        ListNode tail = new ListNode(2);
        ListNode head1 = new ListNode(5,tail);
        ListNode head2 = new ListNode(2,head1);
        ListNode head3 = new ListNode(3,head2);
        ListNode head4 = new ListNode(4,head3);
        ListNode head = new ListNode(1,head4);
        ListNode result = partition(head,3);
        System.out.println(result);

    }


    /**
     *
     * @param head
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode min = dummyHead1;
        ListNode max = dummyHead2;
        while (head != null){
            if(head.val < x){
                min.next = new ListNode(head.val);
                head = head.next;
                min = min.next;
            }else{
                max.next = new ListNode(head.val);
                head = head.next;
                max = max.next;
            }
        }
        min.next = dummyHead2.next;
        return dummyHead1.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
