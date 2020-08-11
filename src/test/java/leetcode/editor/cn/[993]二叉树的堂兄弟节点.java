package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

class SolutionTest993 {
//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 83 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Solution {

        @SuppressWarnings("all")
        public boolean isCousins(TreeNode root, int x, int y) {
            if (x == y || root == null || root.val == x || root.val == y) {
                return false;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 0;
            Node[] cousins = new Node[]{null, null};
            while (!queue.isEmpty()) {
                int n = queue.size();
                depth++;
                while (n > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                        setIfEquals(node.val, node.left.val, depth, cousins, x, y);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        setIfEquals(node.val, node.right.val, depth, cousins, x, y);
                    }
                    n--;
                }
                if (checkFind(cousins)) {
                    return true;
                }
            }
            return checkFind(cousins);
        }

        private void setIfEquals(int parent, int val, int depth, Node[] cousins, int x, int y) {
            if (val == x) {
                cousins[0] = new Node(depth, parent);
            }
            if (val == y) {
                cousins[1] = new Node(depth, parent);
            }
        }

        private boolean checkFind(Node[] cousins) {
            return cousins[0] != null && cousins[1] != null
                    && cousins[0].depth == cousins[1].depth
                    && cousins[0].parent != cousins[1].parent;
        }


        static class Node {

            private final int depth;

            private final int parent;

            public Node(int depth, int parent) {
                this.depth = depth;
                this.parent = parent;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertFalse(solution.isCousins(TreeNode.getTreeNode(new Integer[]{1, 2, 3, null, 4}), 2, 3));
            Assert.assertFalse(solution.isCousins(TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4}), 4, 3));
            Assert.assertTrue(solution.isCousins(TreeNode.getTreeNode(new Integer[]{1, 2, 3, null, 4, null, 5}), 5, 4));
        }
    }
}