package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest141 {
//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针

    public static
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
    class Solution {

        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head;

            while (slow != null && fast != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                }
                if (slow == fast) {
                    return true;
                }
            }
            //其实是要找到pos

            //如果出现next为null一定是无环链表
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode head = new ListNode(3);
            ListNode nextHead = new ListNode(2);
            head.next = nextHead;
            nextHead.addNext(0).addNext(-4).addNode(nextHead);
            Assert.assertTrue(solution.hasCycle(head));

            ListNode head2 = new ListNode(1);
            head2.addNext(2).addNode(head2);
            Assert.assertTrue(solution.hasCycle(head2));
            Assert.assertFalse(solution.hasCycle(new ListNode(1)));
        }
    }
}