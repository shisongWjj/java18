package com.ss.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode0005
 *
 * @author shisong
 * @date 2019/10/22
 */
public class LeetCode0141 {
    /*
        给定一个链表，判断链表中是否有环。
     如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
    位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     如果链表中存在环，则返回 true 。 否则，返回 false 。
     进阶：
     你能用 O(1)（即，常量）内存解决此问题吗？
     示例 1：
     输入：head = [3,2,0,-4], pos = 1
    输出：true
    解释：链表中有一个环，其尾部连接到第二个节点。
     示例 2：
     输入：head = [1,2], pos = 0
    输出：true
    解释：链表中有一个环，其尾部连接到第一个节点。
     示例 3：
     输入：head = [1], pos = -1
    输出：false
    解释：链表中没有环。
     提示：
     链表中节点的数目范围是 [0, 104]
     -105 <= Node.val <= 105
     pos 为 -1 或者链表中的一个 有效索引 。
     Related Topics 链表 双指针*/
    public static void main(String[] args) {
        //int[] nums2 = {-1,0,1,2,-1,-4,-1,0,2,2,2};
        /*int[] nums2 = {-1,0,1,2,-1,-4};
        List<List<Integer>>  area = hasCycle(nums2);
        System.out.println(area);*/

    }


    /**
     *  快慢指针 快指针如果为null  就返回false，如果快慢指针相等 就返回true
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                return false;
            }
            fast = fast.next;
        }
        return false;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
