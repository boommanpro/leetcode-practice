package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 * link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Leetcode83Test {
    @Test
    public void leetcode83Test(){
        //   Given a sorted linked list, delete all duplicates such that each element appear only once.
        //
        //   Example 1:
        //
        //   Input: 1->1->2
        //   Output: 1->2
        //   Example 2:
        //
        //   Input: 1->1->2->3->3
        //   Output: 1->2->3

        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        ListNode node1 = deleteDuplicates(node);
        System.out.println(node1);
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            while (curr.next!=null&&curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
