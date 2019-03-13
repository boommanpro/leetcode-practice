package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 * link:
 */
public class Leetcode24Test {




    @Test
    public void leetcode24Test() {

        //      Given a linked list, swap every two adjacent nodes and return its head.
        //
        //      You may not modify the values in the list's nodes, only nodes itself may be changed.
        //
        //
        //
        //      Example:
        //
        //      Given 1->2->3->4, you should return the list as 2->1->4->3.


        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(swapPairs2(head));
    }





    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;

        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode preHead = dummyHead;
        ListNode left = dummyHead.next;
        ListNode right = left.next;

        while (left != null && left.next != null) {

            left.next = right.next;

            right.next = left;

            preHead.next = right;

            //一轮交换完毕

            preHead = left;

            left = preHead.next;
            if (left != null) {
                right = left.next;
            }
        }

        return dummyHead.next;
    }


    //csdn:https://blog.csdn.net/ma_chen_qq/article/details/80112607

    public ListNode swapPairs2(ListNode head) {

        if (head == null)
            return null;

        //表头节点，默认链表中的数据都为正数
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode left = preHead;
        ListNode mid = head;
        if (head.next == null)               //如果只有一个节点，直接返回这个节点
            return head;
        ListNode right = head.next;

        while (mid != null && mid.next != null) {

            mid.next = right.next;     //交换节点的过程
            right.next = mid;
            left.next = right;

            left = mid;                //移动节点的过程
            mid = left.next;
            if (mid != null)            //注意细节：首先要保证mid不为null，才能将mid.next赋值给right。
                right = mid.next;


        }

        return preHead.next;

    }

}
