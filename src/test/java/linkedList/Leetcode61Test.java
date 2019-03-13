package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode61Test {
    @Test
    public void leetcode61Test(){
        //      Given a linked list, rotate the list to the right by k places, where k is non-negative.
        //
        //      Example 1:
        //
        //      Input: 1->2->3->4->5->NULL, k = 2
        //      Output: 4->5->1->2->3->NULL
        //      Explanation:
        //      rotate 1 steps to the right: 5->1->2->3->4->NULL
        //      rotate 2 steps to the right: 4->5->1->2->3->NULL
        //      Example 2:
        //
        //      Input: 0->1->2->NULL, k = 4
        //      Output: 2->0->1->NULL
        //      Explanation:
        //      rotate 1 steps to the right: 2->0->1->NULL
        //      rotate 2 steps to the right: 1->2->0->NULL
        //      rotate 3 steps to the right: 0->1->2->NULL
        //      rotate 4 steps to the right: 2->0->1->NULL


        ListNode listNode = new ListNode(1);

        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println(rotateRight(listNode,2));
    }


    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null || head.next == null) {
            return head;
        }


        ListNode r = head;
        int countLength = 1;
        while (r.next != null) {
            r = r.next;
            countLength++;
        }
        k = k % countLength;
        if (k  == 0) {
            return head;
        }

        r.next = head;
        int move = countLength - k;

        while (move-- > 0) {
            head = head.next;
            r = r.next;
        }
        r.next = null;


        return head;

    }
}
