package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题02_06 {
//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
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

        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            //找到中间节点
            ListNode mid = findMid(head);
            //reverse
            ListNode reverse = reverse(mid);
            //判断两个节点一致
            return isValEquals(reverse, head);
        }

        private ListNode reverse(ListNode curr) {
            ListNode prev = null;
            ListNode temp;
            while (curr != null) {
                temp = curr.next;
                curr.next = null;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

        private boolean isValEquals(ListNode first, ListNode second) {
            while (first != null && second != null) {
                if (first.val != second.val) {
                    return false;
                }
                first = first.next;
                second = second.next;
            }
            return true;
        }

        private ListNode findMid(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (slow.next != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast.next != null) {
                    fast = fast.next;
                }
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertFalse(solution.isPalindrome(ListNode.fromArray(new Integer[]{1, 2})));
            Assert.assertFalse(solution.isPalindrome(ListNode.fromArray(new Integer[]{1, 2, 3, 4, 2, 1})));
            Assert.assertTrue(solution.isPalindrome(ListNode.fromArray(new Integer[]{2, 2})));
            Assert.assertTrue(solution.isPalindrome(ListNode.fromArray(new Integer[]{1, 2, 2, 1})));
            Assert.assertTrue(solution.isPalindrome(ListNode.fromArray(new Integer[]{1, 2, 3, 2, 1})));
            Assert.assertTrue(solution.isPalindrome(ListNode.fromArray(new Integer[]{1})));
            Assert.assertTrue(solution.isPalindrome(ListNode.fromArray(new Integer[]{})));
        }
    }
}