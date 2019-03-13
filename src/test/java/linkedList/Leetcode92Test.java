package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description link:https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class Leetcode92Test {




    @Test
    public void leetcode92Test() {
        //    Reverse a linked list from position m to n. Do it in one-pass.
        //
        //    Note: 1 ≤ m ≤ n ≤ length of list.
        //
        //    Example:
        //
        //    Input: 1->2->3->4->5->NULL, m = 2, n = 4
        //    Output: 1->4->3->2->5->NULL

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = reverseBetween2(listNode, 2, 4);
        System.out.println(listNode1);
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {

        int startReversePosition = m;
        int endReversePosition = n;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node2 = head;
        while (n >0) {

            node2 = node2.next;
            n--;
        }


        ListNode reverseStart = dummy;
        ListNode node1 = dummy;
        while (m > 0) {
            node1 = reverseStart;
            reverseStart = reverseStart.next;
            m--;
        }

        int i = endReversePosition - startReversePosition+1;

        ListNode prev = node2;

        while (i > 0) {
            ListNode temp = reverseStart.next;

            reverseStart.next = prev;
            prev = reverseStart;
            reverseStart = temp;
            i--;
        }

        node1.next = prev;

        return dummy.next;
    }


    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode ans = new ListNode(0), a = ans, b = head;
        ans.next = head;
        while(head.next != null){
            if (m > 1){
                if (m == 2) {
                    a = head;
                }
                m--;
                n--;
                head = head.next;
            }else {
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = a.next;
                a.next = temp;
                if (n-- == 2) return ans.next;
            }
        }
        return ans.next;
    }
}
