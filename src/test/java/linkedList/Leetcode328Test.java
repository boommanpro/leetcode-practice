package linkedList;

import lombok.Data;
import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 * link: https://leetcode.com/problems/odd-even-linked-list/
 */
public class Leetcode328Test {
    @Test
    public void leetcode328Test() {
        //    Given a singly linked list, group all odd nodes together followed by the even nodes.
        //
        //    Please note here we are talking about the node number and not the value in the nodes.
        //
        //    You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
        //
        //    Example 1:
        //
        //    Input: 1->2->3->4->5->NULL
        //    Output: 1->3->5->2->4->NULL
        //    Example 2:
        //
        //    Input: 2->1->3->5->6->4->7->NULL
        //    Output: 2->3->6->7->1->5->4->NULL


        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(7);
        ListNode listNode1 = oddEvenList(listNode);
        System.out.println(listNode1);
    }



    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode endPoint = head;
        int countLength = 1;
        while (endPoint.next != null) {
            endPoint = endPoint.next;
            countLength++;
        }

        if (countLength < 3) {
            return head;
        }
        ListNode now = head;
        ListNode end = endPoint;

        for (int i = 0; i < countLength / 2; i++) {

            ListNode next = now.next;
            now.next = next.next;

            end.next = next;
            next.next = null;

            end = next;
            now = now.next;

        }
        return head;
    }
}
