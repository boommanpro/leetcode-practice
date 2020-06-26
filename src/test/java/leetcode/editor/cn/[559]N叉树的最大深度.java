package leetcode.editor.cn;

import leetcode.editor.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest559 {
//给定一个 N 叉树，找到其最大深度。 
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 我们应返回其最大深度，3。 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总不会超过 5000。 
// Related Topics 树 深度优先搜索 广度优先搜索

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {

        private int depth;

        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            depth = 0;
            nodeDepth(root, 0);
            return depth;
        }

        private void nodeDepth(Node root, int n) {
            if (root == null) {
                depth = Math.max(n, depth);
                return;
            }
            if (root.children == null || root.children.isEmpty()) {
                depth = Math.max(n + 1, depth);
                return;
            }

            for (Node child : root.children) {
                nodeDepth(child, n + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            List<Node> list = new ArrayList<>();
            List<Node> subList = new ArrayList<>();
            subList.add(new Node(5));
            subList.add(new Node(6));
            list.add(new Node(3, subList));
            list.add(new Node(2));
            list.add(new Node(4));
            Node root = new Node(1, list);
            Assert.assertEquals(3, solution.maxDepth(root));
        }
    }
}