package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest86 {

    //给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
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

        public ListNode partition(ListNode head, int x) {
            ListNode beforeHead = new ListNode(-1);
            ListNode before = beforeHead;
            ListNode afterHead = new ListNode(-1);
            ListNode after = afterHead;
            ListNode curr = head;
            while (curr != null) {
                if (curr.val < x) {
                    before.next = curr;
                    before = before.next;
                } else {
                    after.next = curr;
                    after = after.next;
                }
                curr=curr.next;
            }
            after.next = null;
            before.next = afterHead.next;
            return beforeHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode node1 = new ListNode(1);
            node1.addNext(4).addNext(3).addNext(2).addNext(5).addNext(2);
            Assert.assertEquals("122435", solution.partition(node1, 3).getPositiveListNodeValue());
        }
    }
}