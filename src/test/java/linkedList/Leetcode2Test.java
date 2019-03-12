package linkedList;

import lombok.Data;
import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode2Test {


    @Test
    public void leetcode2Test() {
        //You are given two non-empty linked lists representing two non-negative integers.
        //
        //The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
        //
        //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        //
        //Example:
        //
        //Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        //Output: 7 -> 0 -> 8
        //Explanation: 342 + 465 = 807.


        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);

        System.out.println(listNode);
    }


    @Data
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int add = 0;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        result.next = null;

        while (l1 != null || l2 != null || add != 0) {

            if (l1 != null) {

                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += add;
            add = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
            sum = 0;
        }
        return dummy.next;

    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        int add = 0;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        result.next = null;
        while (l1 != null && l2 != null) {

            int val1 = l1.val;
            int val2 = l2.val;

            int sum = val1 + val2 + add;

            add = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;


        }

        while (l1 != null) {
            int val1 = l1.val;
            int sum = val1 + add;
            add = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val2 = l2.val;
            int sum = val2 + add;
            add = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
            l2 = l2.next;
        }

        if (add != 0) {
            result.next = new ListNode(add);
            result = result.next;
        }

        return dummy.next;
    }


}
