package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 * link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Leetcode25Test {



    @Test
    public void leetcode25Test(){

        //      Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
        //
        //      k is a positive integer and is less than or equal to the length of the linked list.
        //
        //      If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
        //
        //      Example:
        //
        //      Given this linked list: 1->2->3->4->5
        //
        //      For k = 2, you should return: 2->1->4->3->5
        //
        //      For k = 3, you should return: 3->2->1->4->5


        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(reverseKGroup(node,2));
    }


    public ListNode reverseKGroup(ListNode head, int k) {

        int nodeLength = 0;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        while (head != null) {
            head = head.next;
            nodeLength++;
        }

        if (nodeLength < k) {
            return dummy.next;
        }


        ListNode preHead = dummy;
        ListNode left = dummy.next;
        ListNode right = left.next;


        for (int i = 0; i < nodeLength / k; i++) {

            //一次交换长度就是2
            int count = 1;
            while (count < k) {
                left.next = right.next;
                right.next = preHead.next;
                preHead.next = right;
                right = left.next;
                count++;
            }

            preHead = left;

            left = preHead.next;
            if (left != null) {
                right = left.next;
            }

        }
        return dummy.next;
    }



    public ListNode reverseKGroup2(ListNode head, int k) {
        //无需翻转
        if (k < 2) {
            return head;
        }

        //无需翻转
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode left = head;
        //计算长度
        while (left != null){
            left = left.next;
            len++;
        }
        //无需翻转
        if (k > len) {
            return head;
        }
        //res head
        ListNode res = new ListNode(0);
        res.next = head;
        //前置指针、移动指针、后置指针
        ListNode preHead = res;
        left = head;
        ListNode right = head.next;
        for (int i  = 0; i < len/k; i++){
            for (int step = 1; step < k; step++){/*翻转k-1次即已完成长度为k的一段翻转*/
                left.next = right.next;
                right.next = preHead.next;
                preHead.next = right;
                right = left.next;
            }
            /*重置指针*/
            preHead = left;
            left = right;
            if (right != null){
                right = right.next;
            }
        }
        return res.next;
    }
}
