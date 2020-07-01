package leetcode.editor.cn;

import java.util.Stack;

import org.junit.Test;

class SolutionTest面试题02_04 {
//编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
//分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。 
//
// 示例: 
//
// 输入: head = 3->5->8->5->10->2->1, x = 5
//输出: 3->1->2->10->5->5->8
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
            Stack<ListNode> stack = new Stack<>();
            ListNode curr = head;
            int n = 0;
            while (curr != null) {
                stack.push(curr);
                curr = curr.next;
                n++;
            }
            curr = head;
            int i = 0;
            while (curr != null && i < n) {
                if (curr.val >= x) {
                    ListNode temp = stack.pop();
                    n--;
                    while (!stack.isEmpty() && temp != null && temp.val >= x && i < n) {
                        temp = stack.pop();
                        n--;
                    }
                    if (temp != null) {
                        int t = temp.val;
                        temp.val = curr.val;
                        curr.val = t;
                    }
                }
                curr = curr.next;
                i++;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            System.out.println(solution.partition(ListNode.fromArray(new Integer[]{3, 5, 8, 5, 10, 2, 1}), 5).getPositiveListNodeValue());
        }
    }
}