package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest147 {

    //对链表进行插入排序。
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表
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

        /**
         * 插入排序的思想是:
         */

        public ListNode insertionSortList(ListNode head) {
            ListNode dummy = new ListNode(-1);
            ListNode temp;
            ListNode curr = head;
            ListNode insert;
            while (curr != null) {
                insert = dummy;
                temp = curr.next;
                //-1 3 4
                while (insert.next != null && insert.next.val < curr.val) {
                    insert = insert.next;
                }
                curr.next = insert.next;
                insert.next = curr;
                //找到当前curr应在插在链表的哪个位置
                curr = temp;
            }
            return dummy.next;
        }

        public ListNode insertionSortList1(ListNode head) {

            if (head == null || head.next == null) return head;
            ListNode curr = head;
            ListNode next = head.next;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            while (next != null) {
                int temp = next.val;
                if (curr.val < temp) {
                    //如果上一位已经比它小了，表示已经排好顺序了，不用排
                    next = next.next;
                    curr = curr.next;
                } else {
                    //拿出curr从头开始比较
                    curr.next = next.next;//直接先讲p连到后面
                    ListNode f = dummy;
                    while (f.next.val < next.val) {
                        //肯定会碰到那个比他大的，不然就不会进入这里饿了
                        f = f.next;
                    }
                    next.next = f.next;
                    f.next = next;
                    //插入
                    next = curr.next;
                }
            }
            return dummy.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    //TODO 多加练习
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();

            ListNode node3 = new ListNode(4);
            node3.addNext(3).addNext(2).addNext(1);
            Assert.assertEquals("1234", solution.insertionSortList(node3).getPositiveListNodeValue());

            ListNode node1 = new ListNode(4);
            node1.addNext(2).addNext(1).addNext(3);
            Assert.assertEquals("1234", solution.insertionSortList(node1).getPositiveListNodeValue());

            ListNode node2 = new ListNode(-1);
            node2.addNext(5).addNext(3).addNext(4).addNext(0);
            Assert.assertEquals("-10345", solution.insertionSortList(node2).getPositiveListNodeValue());
        }
    }
}