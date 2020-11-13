package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest328 {

    //给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//
// 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 1->3->5->2->4->NULL
// 
//
// 示例 2: 
//
// 输入: 2->1->3->5->6->4->7->NULL 
//输出: 2->3->6->7->1->5->4->NULL 
//
// 说明: 
//
// 
// 应当保持奇数节点和偶数节点的相对顺序。 
// 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。 
// 
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

        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return head;
            }
            ListNode beforeHead = new ListNode(-1);
            ListNode before = beforeHead;
            ListNode afterHead = new ListNode(-1);
            ListNode after = afterHead;
            while (head != null) {
                before.next = head;
                head = head.next;
                before = before.next;
                if (head != null) {
                    after.next = head;
                    head = head.next;
                    after = after.next;
                }
            }
            before.next = afterHead.next;
            after.next = null;
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
            node1.addNext(2).addNext(3).addNext(4).addNext(5);
            Assert.assertEquals("[1, 3, 5, 2, 4]", solution.oddEvenList(node1).getPositiveListNodeValue());
            ;

            ListNode node2 = new ListNode(2);
            node2.addNext(1).addNext(3).addNext(5).addNext(6).addNext(4).addNext(7);
            Assert.assertEquals("[2, 3, 6, 7, 1, 5, 4]", solution.oddEvenList(node2).getPositiveListNodeValue());
            ;
        }
    }
}