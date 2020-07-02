package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题02_08 {
//给定一个有环链表，实现一个算法返回环路的开头节点。 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
// 示例 1： 输入：head = [3,2,0,-4], pos = 1 输出：tail connects to node index 1 解释：链表中有一个环，其尾部连接到第二个节点。
//
// 示例 2： 输入：head = [1,2], pos = 0 输出：tail connects to node index 0 解释：链表中有
//一个环，其尾部连接到第一个节点。 示例 3： 输入：head = [1], pos = -1 输出：no cycle 解释：链表中没有环。 进阶： 你是否可以不
//用额外空间解决此题？ Related Topics 链表

    static
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    public class Solution {

        public ListNode detectCycle(ListNode head) {
            ListNode point = getCycleImpactPoint(head);
            if (point == null) {
                return null;
            }
            ListNode node1 = head;
            ListNode node2 = point;
            while (node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }

        /**
         * 有环快慢指针一定会碰到
         */
        public ListNode getCycleImpactPoint(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (slow != null && fast != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
                if (slow == fast) {
                    return slow;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode loop = new ListNode(2);
            ListNode root = new ListNode(3);
            root.addNode(loop);
            loop.addNode(new ListNode(0)).addNode(new ListNode(-4)).addNode(loop);
            Assert.assertTrue(loop == solution.detectCycle(root));
            Assert.assertNull(solution.detectCycle(ListNode.fromArray(new Integer[]{1, 2})));
        }
    }
}