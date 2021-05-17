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
            // 分别表示当前节点值 深度 父辈节点值
            if (root == null || root.val == x || root.val == y) {
                return false;
            }
            int[] X = new int[]{x, -1, -1};
            int[] Y = new int[]{y, -1, -1};
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 1;
            while (!queue.isEmpty()) {
                int n = queue.size();
                while (n > 0) {
                    n--;
                    TreeNode curr = queue.poll();
                    if (curr.left != null) {
                        queue.add(curr.left);
                        if (curr.left.val == x) {
                            X[1] = depth;
                            X[2] = curr.val;
                        }
                        if (curr.left.val == y) {
                            Y[1] = depth;
                            Y[2] = curr.val;
                        }
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                        if (curr.right.val == x) {
                            X[1] = depth;
                            X[2] = curr.val;
                        }
                        if (curr.right.val == y) {
                            Y[1] = depth;
                            Y[2] = curr.val;
                        }
                    }
                }
                if (X[1] != -1 || Y[1] != -1) {
                    if (X[2] == Y[2] || (X[2] == -1 || Y[2] == -1)) {
                        return false;
                    } else {
                        return true;
                    }
                }
                depth++;
            }
            return false;
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