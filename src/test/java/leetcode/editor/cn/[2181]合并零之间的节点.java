package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest2181 {
//给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
//
// 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。
//
// 返回修改后链表的头节点 head 。
//
//
//
// 示例 1：
//
//
//输入：head = [0,3,1,0,4,5,2,0]
//输出：[4,11]
//解释：
//上图表示输入的链表。修改后的链表包含：
//- 标记为绿色的节点之和：3 + 1 = 4
//- 标记为红色的节点之和：4 + 5 + 2 = 11
//
//
// 示例 2：
//
//
//输入：head = [0,1,0,3,0,2,2,0]
//输出：[1,3,4]
//解释：
//上图表示输入的链表。修改后的链表包含：
//- 标记为绿色的节点之和：1 = 1
//- 标记为红色的节点之和：3 = 3
//- 标记为黄色的节点之和：2 + 2 = 4
//
//
//
//
// 提示：
//
//
// 列表中的节点数目在范围 [3, 2 * 10⁵] 内
// 0 <= Node.val <= 1000
// 不 存在连续两个 Node.val == 0 的节点
// 链表的 开端 和 末尾 节点都满足 Node.val == 0
//
//
// Related Topics链表 | 模拟
//
// 👍 55, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode dummy = head;
            int sum = 0;
            while (head.next != null) {
                if (head.next.val != 0) {
                    sum += head.next.val;
                    head.next = head.next.next;
                }else {
                    head.next.val = sum;
                    sum = 0;
                    head = head.next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        // 辅助方法用于创建链表
        private ListNode createLinkedList(int... values) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            for (int value : values) {
                current.next = new ListNode(value);
                current = current.next;
            }
            return dummy.next;
        }

        // 辅助方法用于打印链表
        private String printLinkedList(ListNode head) {
            StringBuilder sb = new StringBuilder();
            while (head != null) {
                sb.append(head.val).append(" ");
                head = head.next;
            }
            return sb.toString().trim();
        }

        @Test
        public void testMergeNodes_Example1() {
            ListNode head = createLinkedList(0, 3, 1, 0, 4, 5, 2, 0);
            ListNode result = solution.mergeNodes(head);
            String expected = "4 11";
            assertEquals(expected, printLinkedList(result));
        }

        @Test
        public void testMergeNodes_Example2() {
            ListNode head = createLinkedList(0, 1, 0, 3, 0, 2, 2, 0);
            ListNode result = solution.mergeNodes(head);
            String expected = "1 3 4";
            assertEquals(expected, printLinkedList(result));
        }
    }
}
