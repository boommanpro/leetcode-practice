package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest445 {

    //给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
//
// 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 进阶: 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 示例: 
//
// 
//输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出: 7 -> 8 -> 0 -> 7
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

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1.val == 0) {
                return l2;
            }
            if (l2.val == 0) {
                return l1;
            }
            l1 = reverse(l1);
            l2 = reverse(l2);
            int add = 0;
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            while (add != 0 || l1 != null || l2 != null) {
                int sum = add;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                add = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }

            return reverse(dummy.next);
        }
        //先把两个链表长度补齐 然后递归调用
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            addLinkList(l1, l2);
            if (cout != 0) {
                ListNode node = new ListNode(cout);
                node.next = l1;
                return node;
            }
            return l1;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = null;
            ListNode temp;
            while (head != null) {
                temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }

         int cout = 0;

        private void addLinkList(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null)
                return;
            if (l1.next != null && l2.next != null)
                addLinkList(l1.next, l2.next);
            int Sum = l1.val + l2.val + cout;
            if (Sum >= 10) {
                cout = 1;
                l1.val = Sum % 10;
            } else {
                cout = 0;
                l1.val = Sum;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode node1 = new ListNode(7);
            node1.addNext(2).addNext(4).addNext(3);

            ListNode node2 = new ListNode(5);
            node2.addNext(6).addNext(4);
            Assert.assertEquals("7807", solution.addTwoNumbers(node1, node2).getPositiveListNodeValue());


            ListNode node3 = new ListNode(1);
            node3.addNext(2).addNext(4).addNext(5);

            ListNode node4 = new ListNode(9);
            node4.addNext(2).addNext(4).addNext(5);
            Assert.assertEquals("10490", solution.addTwoNumbers1(node3, node4).getPositiveListNodeValue()
            );
        }
    }
}