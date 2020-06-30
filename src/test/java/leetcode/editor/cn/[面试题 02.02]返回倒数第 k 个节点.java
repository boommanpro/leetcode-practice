package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题02_02 {
//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
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
        public int kthToLast(ListNode head, int k) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode fast = dummy;
            ListNode curr = dummy;
            while (k > 1) {
                fast = fast.next;
                k--;
            }
            while (fast.next != null) {
                curr = curr.next;
                fast = fast.next;
            }
            return curr.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.kthToLast(ListNode.fromArray(new Integer[]{1, 2, 3, 4, 5}), 2));
            Assert.assertEquals(5, solution.kthToLast(ListNode.fromArray(new Integer[]{1, 2, 3, 4, 5}), 1));
            Assert.assertEquals(1, solution.kthToLast(ListNode.fromArray(new Integer[]{1, 2, 3, 4, 5}), 5));
        }
    }
}