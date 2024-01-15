package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest82 {

    //给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
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
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = dummy;
            while (curr.next != null && curr.next.next != null) {
                if (curr.next.val == curr.next.next.val) {
                    int value = curr.next.val;
                    while (curr.next.next != null && curr.next.next.val == value) {
                        curr.next.next = curr.next.next.next;
                    }
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
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
            node1.addNext(2).addNext(3).addNext(3).addNext(4).addNext(4).addNext(5);
            Assert.assertEquals("[1, 2, 5]", solution.deleteDuplicates(node1).getPositiveListNodeValue());

            ListNode node2 = new ListNode(1);
            node2.addNext(1).addNext(1).addNext(2).addNext(3);
            Assert.assertEquals("[2, 3]", solution.deleteDuplicates(node2).getPositiveListNodeValue());

            ListNode node3 = new ListNode(1);
            node3.addNext(1);
            ListNode listNode = solution.deleteDuplicates(node3);
            Assert.assertEquals("", listNode == null ? "" : listNode.getPositiveListNodeValue());
        }
    }
}
