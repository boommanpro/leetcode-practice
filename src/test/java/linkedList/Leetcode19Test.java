package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode19Test {





    @Test
    public void leetcode19Test() {
        //   Given a linked list, remove the n-th node from the end of list and return its head.
        //
        //   Example:
        //
        //   Given linked list: 1->2->3->4->5, and n = 2.
        //
        //   After removing the second node from the end, the linked list becomes 1->2->3->5.


        ListNode listNode = new ListNode(1);

        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = removeNthFromEnd(listNode, 2);
        System.out.println(listNode1);
    }



    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        // 题目是移除倒数第几个

        int nodeLength = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        ListNode first = head;
        while (first != null) {
            nodeLength++;
            first = first.next;
        }

        nodeLength -= n;

        while (nodeLength > 0) {
            curr = curr.next;
            nodeLength--;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }

}
