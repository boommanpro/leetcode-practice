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

    public static ListNode fromArray(Integer[] array) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (Integer i : array) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return dummy.next;
    }


    /**
     * 只是为方便测试创建的 不允许非测试调用
     */
    public ListNode addNext(int x) {
        ListNode nextNode = new ListNode(x);
        this.next = nextNode;
        return nextNode;
    }

    public ListNode addNode(ListNode node) {
        this.next = node;
//        while (node.next != null) {
//            node = node.next;
//        }
        if (node.next != null) {
            return node.next;
        }
        return node;
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

    public String toArrayString() {
        ListNode now = this;
        StringBuilder sb = new StringBuilder("[");
        while (now != null) {
            sb.append(now.val);
            if (now.next != null) {
                sb.append(", ");
            }
            now = now.next;
        }
        return sb.append("]").toString();
    }

    public String getNegativeListNodeValue(){
        StringBuilder sb = new StringBuilder();
        getNegativeListNodeValue(this,sb);
        return sb.toString();
    }

    private void getNegativeListNodeValue(ListNode head,StringBuilder sb){
        if (head.next != null) {
             getNegativeListNodeValue(head.next, sb);
        }
         sb.append(head.val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return listNode.val == this.val;
    }

    @Override
    public int hashCode() {
        return val;
    }
}
