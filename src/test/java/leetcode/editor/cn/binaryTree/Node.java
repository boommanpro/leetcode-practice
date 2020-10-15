package leetcode.editor.cn.binaryTree;

import java.util.*;

/**
 * @author wangqimeng
 * @date 2020/6/17 10:09
 */
public class Node {

    public int val;

    public Node left;

    public Node right;

    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @SuppressWarnings("all")
    public static Node getNode(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            throw new ArrayStoreException("数据异常,请检查数据是否有效.");
        }
        Node curr;
        Node root = new Node(nums[0]);
        Deque<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int length = nums.length;
        int startIndex = 1;
        int lineNum = 2;
        int restLength = length - startIndex;
        while (restLength > 0) {
            for (int i = startIndex; i < startIndex + lineNum; i += 2) {
                curr = nodeQueue.pollFirst();
                if (i == length) {
                    return root;
                }
                if (nums[i] != null) {
                    curr.left = new Node(nums[i]);
                    nodeQueue.offerLast(curr.left);
                }
                if (i + 1 == length) {
                    return root;
                }
                if (nums[i + 1] != null) {
                    curr.right = new Node(nums[i + 1]);
                    nodeQueue.offerLast(curr.right);
                }

            }
            startIndex += lineNum;
            restLength -= lineNum;
            lineNum = nodeQueue.size() * 2;
        }
        return root;
    }

    public String toInString() {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n > 0) {
                Node temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                result.add(temp.val);
                n--;
            }
        }
        return result.toString();
    }
}
