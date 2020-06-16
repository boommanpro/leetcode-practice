package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest112 {
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    class Solution {

        boolean ans;
        int sum;

        public boolean hasPathSum(TreeNode root, int sum) {
            this.sum = sum;
            this.ans = false;
            bfs(root, 0);
            return ans;
        }

        private void bfs(TreeNode root, int value) {
            if (ans) {
                return;
            }
            if (root != null) {
                int curr = root.val + value;
                if (root.left == null && root.right == null && curr == sum) {
                    ans = true;
                    return;
                }
                bfs(root.left, curr);
                bfs(root.right, curr);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertTrue(solution.hasPathSum(TreeNode.getTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
            Assert.assertFalse(solution.hasPathSum(TreeNode.getTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 3, null, null, null, 1}), 22));
        }
    }
}