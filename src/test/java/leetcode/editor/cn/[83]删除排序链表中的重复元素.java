package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest83 {

    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
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

        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode curr = head;
            // 1->1->2
            while (curr != null && curr.next != null) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                }
                curr = curr.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode node1 = new ListNode(1);
            node1.addNext(1).addNext(2);
            Assert.assertEquals("12", solution.deleteDuplicates(node1).getPositiveListNodeValue());

            ListNode node2 = new ListNode(1);
            node2.addNext(1).addNext(2).addNext(3).addNext(3);
            Assert.assertEquals("123", solution.deleteDuplicates(node2).getPositiveListNodeValue());

            ListNode node3 = new ListNode(-1);
            node3.addNext(0).addNext(0).addNext(0).addNext(0).addNext(3).addNext(3);
            Assert.assertEquals("-103", solution.deleteDuplicates(node3).getPositiveListNodeValue());
        }
    }
}