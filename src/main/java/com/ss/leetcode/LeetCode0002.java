package com.ss.leetcode;

import java.util.LinkedList;

/**
 * LeetCode0002
 *
 * @author shisong
 * @date 2019/10/10
 */
public class LeetCode0002 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {

    }


    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }


    /**
     * 创建一个虚拟节点列表，
     * 只要2个列表不为空，并且存在进位，就一直循环
     * 判断2个列表是否为空，如果为空 那么值就是0；
     * 合为 ： 2个列表的值 + 进位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cursor = result;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null || carry !=0){
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            carry = sum/10 ;
            ListNode temp = new ListNode(sum%10);
            cursor.next = temp;
            cursor = temp;
            if(l1 != null){
                l1 = l1.next ;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        return result.next;
    }




}
