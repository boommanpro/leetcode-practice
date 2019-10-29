package leetcode.editor.cn;

import java.util.List;

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
            //如果节点数为0或1
            if (head == null || head.next == null) {
                return head;
            }
            ListNode result = new ListNode(-1);
            result.next = head;
            ListNode prev = result;
            ListNode curr;
            ListNode next;
            ListNode temp;
            while (prev.next != null && prev.next.next != null) {
                curr = prev.next;
                next = curr.next;
                temp = next.next;
                next.next = curr;
                curr.next = temp;
                prev.next = next;
                prev = curr;
            }
            return result.next;
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
            Assert.assertEquals("2143", solution.swapPairs(node1).getPositiveListNodeValue());
        }
    }
}