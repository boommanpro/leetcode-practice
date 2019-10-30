package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest143 {

    //给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
    //1->2->3
    //1->3->2
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

        public void reorderList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return;
            }
            //思路 找到链表的中点,反转后边链表
            //重新拼接起来
            ListNode origin = new ListNode(-1);
            origin.next = head;
            ListNode mid = findMid(head);
            ListNode after = reverse(mid.next);
            mid.next = null;
            ListNode temp;
            while (head != null && after != null) {
                temp = head.next;
                head.next = after;
                after = after.next;
                if (temp != null) {
                    head.next.next = temp;
                }
                head = temp;
            }
        }

        private ListNode findMid(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode fast = dummy, slow = dummy;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = null;
            ListNode temp;
            while (head != null) {
                temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode node1 = new ListNode(1);
            node1.addNext(2).addNext(3).addNext(4);
            solution.reorderList(node1);
            Assert.assertEquals("1423", node1.getPositiveListNodeValue());

            ListNode node2 = new ListNode(1);
            node2.addNext(2).addNext(3).addNext(4).addNext(5);
            solution.reorderList(node2);
            Assert.assertEquals("15243", node2.getPositiveListNodeValue());

            ListNode node3 = new ListNode(1);
            solution.reorderList(node3);
            Assert.assertEquals("1", node3.getPositiveListNodeValue());
        }
    }
}