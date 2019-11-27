package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest148 {

    //在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
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

        //大家都喜欢用的归并排序（事实上是对链表排序的最佳方案）

        public ListNode sortList(ListNode head) {
            return mergeSort(head);
        }

        // 归并排序
        private ListNode mergeSort(ListNode head) {
            // 如果没有结点/只有一个结点，无需排序，直接返回
            if (head == null || head.next == null) return head;
            // 快慢指针找出中位点
            ListNode slowp = head, fastp = head.next.next, l, r;
            while (fastp != null && fastp.next != null) {
                slowp = slowp.next;
                fastp = fastp.next.next;
            }
            // 对右半部分进行归并排序
            r = mergeSort(slowp.next);
            // 链表判断结束的标志：末尾节点.next==null
            slowp.next = null;
            // 对左半部分进行归并排序
            l = mergeSort(head);
            return mergeList(l, r);
        }

        // 合并链表
        private ListNode mergeList(ListNode l, ListNode r) {
            // 临时头节点
            ListNode tmpHead = new ListNode(-1);
            ListNode p = tmpHead;
            while (l != null && r != null) {
                if (l.val < r.val) {
                    p.next = l;
                    l = l.next;
                } else {
                    p.next = r;
                    r = r.next;
                }
                p = p.next;
            }
            p.next = l == null ? r : l;
            return tmpHead.next;
        }

        //快排版本。头条面试被问到了（貌似提问频率还挺高的），加了很多注释，分享给大家（交换结点版本，非伪排序只交换数值）。
        public ListNode sortList0(ListNode head) {
            if (head == null || head.next == null) return head;
            // 没有条件，创造条件。自己添加头节点，最后返回时去掉即可。
            ListNode newHead = new ListNode(-1);
            newHead.next = head;
            return quickSort(newHead, null);
        }

        // 带头结点的链表快速排序
        private ListNode quickSort(ListNode head, ListNode end) {
            if (head == end || head.next == end || head.next.next == end) return head;
            // 将小于划分点的值存储在临时链表中
            ListNode tmpHead = new ListNode(-1);
            // partition为划分点，p为链表指针，tp为临时链表指针
            ListNode partition = head.next, p = partition, tp = tmpHead;
            // 将小于划分点的结点放到临时链表中
            while (p.next != end) {
                if (p.next.val < partition.val) {
                    tp.next = p.next;
                    tp = tp.next;
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            // 合并临时链表和原链表，将原链表接到临时链表后面即可
            tp.next = head.next;
            // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
            head.next = tmpHead.next;
            quickSort(head, partition);
            quickSort(partition, end);
            // 题目要求不带头节点，返回结果时去除
            return head.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            ListNode node1 = new ListNode(4);
            node1.addNext(2).addNext(1).addNext(3);
            Assert.assertEquals("1234", solution.sortList(node1).getPositiveListNodeValue());

            ListNode node2 = new ListNode(-1);
            node2.addNext(5).addNext(3).addNext(4).addNext(0);
            Assert.assertEquals("-10345", solution.sortList(node2).getPositiveListNodeValue());
        }
    }
}