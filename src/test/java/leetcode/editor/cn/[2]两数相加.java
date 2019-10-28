package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest2 {

    //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// 输入：(1 -> 8 ) + (0)
//输出：1-> 8
//原因：81 + 0 = 81
// Related Topics 链表 数学
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

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int add = 0;
            int sum;
            ListNode result = new ListNode(0);
            ListNode curr = result;
            while (l1 != null || l2 != null || add != 0) {
                sum = 0;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                sum += add;
                add = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }

            return result.next;
        }

        //链表反转
        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode temp = head.next;
            ListNode newHead = reverse(head.next);
            head.next = null;
            temp.next = head;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode listNode1 = new ListNode(2);
            listNode1.addNext(4).addNext(3);

            ListNode listNode2 = new ListNode(5);
            listNode2.addNext(6).addNext(4);
            ListNode resultNode1 = solution.addTwoNumbers(listNode1, listNode2);
            Assert.assertEquals("708", resultNode1.getPositiveListNodeValue());

            ListNode listNode3 = new ListNode(5);
            ListNode listNode4 = new ListNode(5);
            ListNode resultNode2 = solution.addTwoNumbers(listNode3, listNode4);
            Assert.assertEquals("01", resultNode2.getPositiveListNodeValue());

            ListNode listNode5 = new ListNode(1);
            listNode5.addNext(8);
            ListNode listNode6 = new ListNode(0);
            ListNode resultNode3 = solution.addTwoNumbers(listNode5, listNode6);
            Assert.assertEquals("18", resultNode3.getPositiveListNodeValue());
        }
    }
}