package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode82Test {
    @Test
    public void leetcode82Test(){
        //     Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
        //
        //     Example 1:
        //
        //     Input: 1->2->3->3->4->4->5
        //     Output: 1->2->5
        //     Example 2:
        //
        //     Input: 1->1->1->2->3
        //     Output: 2->3

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(4);
        ListNode node1 = deleteDuplicates(node);

        System.out.println(deleteDuplicates(node1));
    }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                while (curr.next != null && curr.next.val == curr.val) {
                    curr.next = curr.next.next;
                }
            }else {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;

        }

        prev.next = curr;
        return dummy.next;
    }
}
