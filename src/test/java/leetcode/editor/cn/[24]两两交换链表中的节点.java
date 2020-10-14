package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest24 {

    //给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
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

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode curr = prev.next;
            while (curr != null && curr.next != null) {
                ListNode next = curr.next;
                ListNode tail = next.next;
                prev.next = next;
                curr.next = tail;
                next.next = curr;

                prev = curr;
                curr = prev.next;
            }
            return dummy.next;
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
            Assert.assertEquals("[2, 1, 4, 3]", solution.swapPairs(node1).getPositiveListNodeValue());
            ListNode node2 = new ListNode(1);
            node2.addNext(2).addNext(3).addNext(4).addNext(5).addNext(6).addNext(7).addNext(8).addNext(9);
            Assert.assertEquals("[2, 1, 4, 3, 6, 5, 8, 7, 9]", solution.swapPairs(node2).getPositiveListNodeValue());
        }
    }
}