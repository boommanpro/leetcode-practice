package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode21Test {




    @Test
    public void leetcode21Test(){


        //       Merge two sorted linked lists and return it as a new list.
        //
        //       The new list should be made by splicing together the nodes of the first two lists.
        //
        //       Example:
        //
        //       Input: 1->2->4, 1->3->4
        //       Output: 1->1->2->3->4->4


        ListNode l1 = new ListNode(1);
         l1.next = new ListNode(2);
         l1.next.next = new ListNode(4);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);

        System.out.println(listNode);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                result.next = l1;
                result = result.next;
                l1 = l1.next;
            }else {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
            }
        }


        if (l1 != null) {
            result.next = l1;
        }else {
            result.next = l2;
        }
        return dummy.next;

    }
}
