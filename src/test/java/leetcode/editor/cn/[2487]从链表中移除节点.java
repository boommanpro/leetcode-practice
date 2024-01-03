package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class SolutionTest2487 {
//给你一个链表的头节点 head 。
//
// 移除每个右侧有一个更大数值的节点。
//
// 返回修改后链表的头节点 head 。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [5,2,13,3,8]
//输出：[13,8]
//解释：需要移除的节点是 5 ，2 和 3 。
//- 节点 13 在节点 5 右侧。
//- 节点 13 在节点 2 右侧。
//- 节点 8 在节点 3 右侧。
//
//
// 示例 2：
//
//
//输入：head = [1,1,1,1]
//输出：[1,1,1,1]
//解释：每个节点的值都是 1 ，所以没有需要移除的节点。
//
//
//
//
// 提示：
//
//
// 给定列表中的节点数目在范围 [1, 10⁵] 内
// 1 <= Node.val <= 10⁵
//
//
// Related Topics栈 | 递归 | 链表 | 单调栈
//
// 👍 91, 👎 0bug 反馈 | 使用指南 | 更多配套插件
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
        public ListNode removeNodes(ListNode head) {
            Deque<ListNode> stack = new LinkedList<>();
            while (head != null) {
                ListNode curr = head;
                while (!stack.isEmpty() && curr.val > stack.peek().val) {
                    stack.pop();
                }
                stack.push(curr);
                head = head.next;
            }
            ListNode prev = null;
            while (!stack.isEmpty()) {
                ListNode curr = stack.pop();
                curr.next = prev;
                prev = curr;
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
            Assert.assertEquals("[13, 8]",solution.removeNodes(ListNode.fromArray(new Integer[]{5,2,13,3,8})).toArrayString());
            Assert.assertEquals("[1, 1, 1, 1]",solution.removeNodes(ListNode.fromArray(new Integer[]{1,1,1,1})).toArrayString());
        }

    }
}
