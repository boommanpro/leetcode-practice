package linkedList;

import lombok.Data;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@Data
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
