package leetcode.editor.cn.next;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

    public static Node build(int[] array) {
        Node head = new Node(array[0]);
        Node prev = head;
        for (int i = 1; i < array.length; i++) {
            prev.next = new Node(array[i]);
            prev = prev.next;
        }
        prev.next = head;
        return head;
    }

    @Override
    public String toString() {
        Node head = this;
        Node curr = head;
        List<Integer> ans = new ArrayList<>();
        ans.add(curr.val);
        while (curr.next != head) {
            ans.add(curr.next.val);
            curr = curr.next;
        }
        return String.format("[%s]", ans.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

}
