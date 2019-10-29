package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest203 {

    //删除链表中等于给定值 val 的所有节点。
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
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
        //1->2->1->1->1
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = dummy;
            while (curr != null && curr.next != null) {
                while (curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
                curr = curr.next;
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
            node1.addNext(2).addNext(6).addNext(3).addNext(4).addNext(5).addNext(6);
            Assert.assertEquals("12345", solution.removeElements(node1, 6).getPositiveListNodeValue());

            ListNode node2 = new ListNode(1);
            node2.addNext(1);
            ListNode nodeResult2 = solution.removeElements(node2, 1);
            Assert.assertEquals("", nodeResult2 == null ? "" : nodeResult2.getPositiveListNodeValue());

            ListNode node3 = new ListNode(1);
            node3.addNext(2).addNext(1).addNext(1).addNext(1);
            ListNode nodeResult3 = solution.removeElements(node3, 1);
            Assert.assertEquals("2", nodeResult3 == null ? "" : nodeResult3.getPositiveListNodeValue());
        }
    }
}