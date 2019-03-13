package linkedList;

import org.junit.Test;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode237Test {
    @Test
    public void leetcode237Test(){
        //     Example 1:
        //
        //     Input: head = [4,5,1,9], node = 5
        //     Output: [4,1,9]
        //     Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
        //     Example 2:
        //
        //     Input: head = [4,5,1,9], node = 1
        //     Output: [4,5,9]
        //     Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
    }

    public void deleteNode(ListNode node)
    {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
