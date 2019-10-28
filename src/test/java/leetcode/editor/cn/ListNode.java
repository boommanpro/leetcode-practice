package leetcode.editor.cn;

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

    /**
     * 只是为方便测试创建的 不允许非测试调用
     */
    public ListNode addNext(int x) {
        ListNode nextNode = new ListNode(x);
        this.next = nextNode;
        return nextNode;
    }

    /**
     * 只是为方便测试创建的 不允许非测试调用
     */
    public String getPositiveListNodeValue() {
        ListNode now = this;
        StringBuilder sb = new StringBuilder();
        while (now != null) {
            sb.append(now.val);
            now = now.next;
        }
        return sb.toString();
    }
}
