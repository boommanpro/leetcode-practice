package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest92 {

    //反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
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

        // 输入: 1->2->3->4->5->NULL, m = 2, n = 4
        // 输出: 1->4->3->2->5->NULL
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (m == n) {
                return head;
            }
            //构建虚拟节点  (-1)
            ListNode dummy = new ListNode(-1);
            ListNode tail;
            dummy.next = head;
            //                tail                              end
            //dummy leftHead  startReverse          endReverse
            ListNode leftHead = findKNode(dummy, m - 1);
            ListNode rightEnd = findKNode(leftHead, n - m + 1);
            ListNode end = rightEnd.next;
            rightEnd.next = null;
            tail = leftHead.next;
            leftHead.next = reverse(leftHead.next);
            tail.next = end;
            return dummy.next;
        }

        private ListNode findKNode(ListNode head, int k) {
            while (k > 0) {
                head = head.next;
                k--;
            }
            return head;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = null;
            ListNode curr = head;
            ListNode temp;
            //1->2->3->4
            while (curr != null) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
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
            node1.addNext(2).addNext(3).addNext(4).addNext(5);
            Assert.assertEquals("14325", solution.reverseBetween(node1, 2, 4).getPositiveListNodeValue());
        }
    }
}