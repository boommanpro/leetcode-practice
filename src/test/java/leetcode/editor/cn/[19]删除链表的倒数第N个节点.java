package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest19 {

    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
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

        public ListNode removeNthFromEnd(ListNode head, int n) {

            //统计链表长度
            ListNode curr = head;
            int length = 0;
            while (curr != null) {
                length++;
                curr = curr.next;
            }
            // 给定一个链表: 1->2->3->4->5, 和 n = 2.
            //当删除了倒数第二个节点后，链表变为 1->2->3->5.
            curr = head;
            if (n == length) {
                return head.next;
            }
            int headLength = length - n;

            while (headLength > 1) {
                curr = curr.next;
                headLength--;
            }
            curr.next = curr.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode node = new ListNode(1);
            node.addNext(2).addNext(3).addNext(4).addNext(5);
            Assert.assertEquals("1235", solution.removeNthFromEnd(node, 2).getPositiveListNodeValue());
        }
    }
}