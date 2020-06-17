package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.editor.cn.binaryTree.Node;
import org.junit.Test;

class SolutionTest116 {
//给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 示例： 
//
// 
//
// 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"ri
//ght":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right
//":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left"
//:null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":nu
//ll,"next":null,"right":null,"val":7},"val":3},"val":1}
//
//输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4
//","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next"
//:null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":
//null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":
//"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"va
//l":1}
//
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
// 
//
// 
//
// 提示： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
// Related Topics 树 深度优先搜索

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {

        @SuppressWarnings("all")
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Deque<Node> nodeQueue = new LinkedList<>();
            nodeQueue.offerLast(root);
            Node curr;
            Deque<Node> rowQueue = new LinkedList<>();
            while (nodeQueue.size() > 0) {
                int n = nodeQueue.size();
                while (n > 0) {
                    curr = nodeQueue.pollFirst();
                    if (curr.left != null) {
                        nodeQueue.offerLast(curr.left);
                        rowQueue.offerLast(curr.left);
                    }
                    if (curr.right != null) {
                        nodeQueue.offerLast(curr.right);
                        rowQueue.offerLast(curr.right);
                    }
                    n--;
                }
                linkAndClearRowQueue(rowQueue);
            }
            return root;
        }

        public void linkAndClearRowQueue(Deque<Node> rowQueue) {
            if (rowQueue.size() == 0) {
                return;
            }
            Node pre = rowQueue.pollFirst();
            Node next;
            while (rowQueue.size() > 0) {
                next = rowQueue.pollFirst();
                pre.next = next;
                pre = next;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            System.out.println(solution.connect(Node.getNode(new Integer[]{1, 2, 3, 4, 5, 6, 7})));
        }
    }
}