package leetcode.editor.cn;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest25 {

    //给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 示例 : 
//
// 给定这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 说明 : 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
// 
// Related Topics 链表
    public static

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {
        //多定义节点 表明清晰的层次关系
        //                           K
        //pre ->waitReverseHead      waitReverseTail  next
        //pre ->reverseHead          reverseTail      next
        //                                       prev ....
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 1 || k == 0) {
                return head;
            }
            // 给定这个链表：1->2->3->4->5
            // 当 k = 2 时，应当返回: 2->1->4->3->5
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode curr = getKNode(prev, k);
            ListNode temp;
            ListNode reverseHead;
            ListNode reverseTail;
            while (curr != null) {
                reverseTail = prev.next;
                temp = curr.next;
                curr.next = null;
                reverseHead = reverse(prev.next);
                prev.next = reverseHead;
                reverseTail.next = temp;
                prev = reverseTail;
                curr = getKNode(prev, k);
            }
            return dummy.next;
        }

        private ListNode getKNode(ListNode head, int k) {
            while (head != null && k > 0) {
                head = head.next;
                k--;
            }
            return k == 0 ? head : null;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //1->2->3->4->5
            ListNode prev = null;
            ListNode curr = head;
            ListNode temp;
            while (curr != null) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

        private ListNode iterableReverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode curr = head.next;
            ListNode newHead = iterableReverse(head.next);
            head.next = null;
            curr.next = head;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode node1 = new ListNode(1);
            node1.addNext(2).addNext(3).addNext(4).addNext(5);
            Assert.assertEquals("21435", solution.reverseKGroup(node1, 2).getPositiveListNodeValue());

            ListNode node2 = new ListNode(1);
            node2.addNext(2).addNext(3).addNext(4).addNext(5);
            Assert.assertEquals("32145", solution.reverseKGroup(node2, 3).getPositiveListNodeValue());
        }
    }
}