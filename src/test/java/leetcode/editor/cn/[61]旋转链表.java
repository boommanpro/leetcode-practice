package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest61 {

    //给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针
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

        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0) {
                return head;
            }
            int i = k;
            int length = 0;
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = dummy;
            while (i > 0 && curr.next != null) {
                curr = curr.next;
                i--;
            }
            ListNode newHead;
            if (curr.next != null) {
                ListNode cut = dummy;
                while (curr.next != null) {
                    curr = curr.next;
                    cut = cut.next;
                }
                newHead = cut.next;
                cut.next = null;
                curr.next = dummy.next;
                return newHead;
            }
            int nextStep;
            length = k - i;
            nextStep = length - k % length;
            if (nextStep == length) {
                return head;
            }
            ListNode cut = dummy;
            while (nextStep > 0) {
                cut = cut.next;
                nextStep--;
            }
            newHead = cut.next;
            cut.next = null;
            curr.next = dummy.next;
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
            Assert.assertEquals("45123", solution.rotateRight(node1, 2).getPositiveListNodeValue());

            ListNode node2 = new ListNode(0);
            node2.addNext(1).addNext(2);
            Assert.assertEquals("201", solution.rotateRight(node2, 4).getPositiveListNodeValue());

            ListNode node3 = new ListNode(1);
            node3.addNext(2);
            Assert.assertEquals("12", solution.rotateRight(node3, 0).getPositiveListNodeValue());

            ListNode node4 = new ListNode(1);
            node4.addNext(2);
            Assert.assertEquals("12", solution.rotateRight(node4, 2).getPositiveListNodeValue());

            ListNode node5 = new ListNode(1);
            node5.addNext(2).addNext(3).addNext(4).addNext(5);
            Assert.assertEquals("12345", solution.rotateRight(node5, 10).getPositiveListNodeValue());
        }
    }
}