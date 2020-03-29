package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest206 {

    //反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
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

        //1->2->3->4->5->NULL
        //

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode temp;
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

        //迭代 递归的方式反转链表
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //1->2->3  3->2->1
            ListNode temp = head.next;
            ListNode newHead = reverseList(head.next);
            head.next = null;
            temp.next = head;
            return newHead;
        }

        //其他方式
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode listNode1 = new ListNode(1);
            listNode1.addNext(2).addNext(3).addNext(4).addNext(5);
            Assert.assertEquals("54321",solution.reverseList(listNode1).getPositiveListNodeValue());

            ListNode listNode2 = new ListNode(1);
            listNode2.addNext(2).addNext(3).addNext(4).addNext(5);
            Assert.assertEquals("54321",solution.reverse(listNode2).getPositiveListNodeValue());


        }
    }
}