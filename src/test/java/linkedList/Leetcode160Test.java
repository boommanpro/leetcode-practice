package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 * link: https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Leetcode160Test {


    @Test
    public void leetcode160Test(){

        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(1);
        node1.next.next = common;

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(0);
        node2.next.next = new ListNode(1);
        node2.next.next.next = common;

        ListNode intersectionNode = getIntersectionNode(node1, node2);

        System.out.println(intersectionNode);

    }




    //不太懂题意
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }
}
