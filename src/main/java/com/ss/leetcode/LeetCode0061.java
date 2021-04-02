package com.ss.leetcode;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0061 {
    /*给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     示例 1：
    输入：head = [1,2,3,4,5], k = 2
    输出：[4,5,1,2,3]
     示例 2：
    输入：head = [0,1,2], k = 4
    输出：[2,0,1]
     提示：
     链表中节点的数目在范围 [0, 500] 内
     -100 <= Node.val <= 100
     0 <= k <= 2 * 109
     Related Topics 链表 双指针*/
    public static void main(String[] args) {
        ListNode tail = new ListNode(2);
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(4,head1);
        ListNode head3 = new ListNode(3,head2);
        ListNode head4 = new ListNode(2,head3);
        ListNode head = new ListNode(1,head4);
        ListNode result = rotateRight(head,2);
        System.out.println(result);

    }


    /**
     *  获取当前列表的长度，除去k的多余循环次数，也就是 只会循环一次
     *  两个列表，左右列表，左列表存放的是从头节点到（size-k）位置的节点
     *  右节点 存放的是（size - k）到尾节点的位置。
     * @param head
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        //创建一个虚拟节点
        ListNode dumpyHead1 = new ListNode(0);
        ListNode dumpyHead2 = new ListNode(0);
        ListNode right = dumpyHead1;
        ListNode left = dumpyHead2;
        //获取当前列表的长度
        int size = 0;
        ListNode cursor=head;
        while (cursor != null){
            size ++;
            cursor = cursor.next;
        }
        k = k % size;
        if(k == 0){
            return head;
        }
        k = size - k;
        for(int i = 0 ; i < size ; i++){
            if(i < k){
                right.next = head;
                head = head.next;
                right = right.next;
                right.next = null;
            }else{
                left.next = head;
                head = head.next;
                left = left.next;
                left.next = null;
            }

        }
        left.next = dumpyHead1.next;
        return dumpyHead2.next;
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
