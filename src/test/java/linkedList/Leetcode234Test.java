package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode234Test {

    @Test
    public void leetcode234Test(){
        //    Example 1:
        //
        //    Input: 1->2
        //    Output: false
        //    Example 2:
        //
        //    Input: 1->2->2->1
        //    Output: true

        //判断链表是否是回文链表


        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        boolean palindrome = isPalindrome(node);
        System.out.println(String.format("result:%s",palindrome));
    }

    public boolean isPalindrome(ListNode head) {
        //方法1 找到链表中点 翻转剩余部分 判断是否回文

        if (head == null) {
            return true;
        }

        ListNode fast=head;
        ListNode mid = head;

        while (fast != null) {
            fast = fast.next;
            mid = mid.next;

            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode slow = reverseNodeList(mid);
        mid = head;
        while (slow != null) {
            if (mid.val != slow.val) {
                return false;
            }

            slow = slow.next;
            mid = mid.next;
        }
        return true;
    }

    public ListNode reverseNodeList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

}
