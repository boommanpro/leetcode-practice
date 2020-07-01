package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题02_05 {
//给定两个用链表表示的整数，每个节点包含一个数位。 
// 这些数位是反向存放的，也就是个位排在链表首部。 
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 
//输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：假设这些数位是正向存放的，请再做一遍。 
//
// 示例： 
//
// 
//输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
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
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            int carry = 0;
            while (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l1 != null || l2 != null) {
                curr.next = l1 == null ? l2 : l1;
            }
            while (curr.next != null || carry != 0) {
                if (curr.next == null) {
                    curr.next = new ListNode(0);
                }
                int sum = curr.next.val + carry;
                carry = sum / 10;
                curr.next.val = sum % 10;
                curr = curr.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2, 1, 9]", solution.addTwoNumbers(ListNode.fromArray(new Integer[]{7, 1, 6}), ListNode.fromArray(new Integer[]{5, 9, 2})).getPositiveListNodeValue());
            Assert.assertEquals("[2, 1, 0, 1]", solution.addTwoNumbers(ListNode.fromArray(new Integer[]{7, 1, 7}), ListNode.fromArray(new Integer[]{5, 9, 2})).getPositiveListNodeValue());
            Assert.assertEquals("[0, 0, 1]", solution.addTwoNumbers(ListNode.fromArray(new Integer[]{7}), ListNode.fromArray(new Integer[]{3, 9})).getPositiveListNodeValue());
            Assert.assertEquals("[0, 0, 0, 0, 0, 0, 0, 0, 0, 1]", solution.addTwoNumbers(ListNode.fromArray(new Integer[]{7}), ListNode.fromArray(new Integer[]{3, 9, 9, 9, 9, 9, 9, 9, 9})).getPositiveListNodeValue());
        }
    }
}