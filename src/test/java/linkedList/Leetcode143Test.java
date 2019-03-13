package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 *
 * link: https://leetcode.com/problems/reorder-list/
 */
public class Leetcode143Test {
    @Test
    public void leetcode143Test(){
        //    Given a singly linked list L: L0→L1→…→Ln-1→Ln,
        //    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
        //
        //    You may not modify the values in the list's nodes, only nodes itself may be changed.
        //
        //    Example 1:
        //
        //    Given 1->2->3->4, reorder it to 1->4->2->3.
        //    Example 2:
        //
        //    Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

        ListNode node = new ListNode(1);

        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        reorderList(node);
        System.out.println(node);
    }

    public void reorderList(ListNode head) {

        if(head==null||head.next==null){
            return;
        }

        ListNode curr = head;
        ListNode mid = midPosition(head);
        ListNode after = reverse(mid);

        while (after.next != null) {
            ListNode temp = curr.next;
            curr.next = after;
            after = after.next;
            curr.next.next = temp;
            curr = temp;
        }
    }

    //求中心点 利用哪种算法?

    public ListNode midPosition(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            }else {
                break;

            }
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}
