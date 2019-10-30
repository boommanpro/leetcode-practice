package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest234 {

    //请判断一个链表是否为回文链表。
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
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

        public boolean isPalindrome(ListNode head) {
            ListNode mid = findMid(head);
            ListNode curr = reverse(mid.next);
            while (curr != null) {
                if (curr.val != head.val) {
                    return false;
                }
                curr = curr.next;
                head = head.next;
            }
            return true;
        }

        //找到中间节点
        //1->2->3->4->5

        //1->2->3->4->5->6
        private ListNode findMid(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = null;
            while (head != null) {
                ListNode temp = head.next;
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
            node1.addNext(2);
            Assert.assertFalse(solution.isPalindrome(node1));


            ListNode node2 = new ListNode(1);
            node2.addNext(2).addNext(2).addNext(1);
            Assert.assertTrue(solution.isPalindrome(node2));


            ListNode node3 = new ListNode(1);
            node3.addNext(2).addNext(3).addNext(2).addNext(1);
            Assert.assertTrue(solution.isPalindrome(node3));


            ListNode node4 = new ListNode(1);
            node4.addNext(0).addNext(1);
            Assert.assertTrue(solution.isPalindrome(node4));

        }
    }
}