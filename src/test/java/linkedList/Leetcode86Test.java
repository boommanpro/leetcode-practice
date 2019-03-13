package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 *
 * link: https://leetcode.com/problems/partition-list/
 */
public class Leetcode86Test {
    @Test
    public void leetcode86TEst(){
        //   Given a linked list and a value x, partition(划分) it such that all nodes less than x come before nodes greater than or equal to x.
        //
        //   You should preserve(保留) the original relative order of the nodes in each of the two partitions.
        //
        //   Example:
        //
        //   Input: head = 1->4->3->2->5->2, x = 3
        //   Output: 1->2->2->4->3->5

        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        ListNode partition = partition(node, 3);
        System.out.println(partition);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode(-1);
        ListNode before = beforeDummy;

        ListNode afterDummy = new ListNode(-1);
        ListNode after = afterDummy;

        while (head != null) {

            if (head.val < x) {
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;
        before.next = afterDummy.next;

        return beforeDummy.next;
    }


}
