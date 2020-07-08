package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题04_04 {
//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
// 示例 1: 给定二叉树 [3,9,20,null,null,15,7]     3    / \   9  20     /  \    15   7 返回 true 。
// 示例 2: 给定二叉树 [1,2,2,3,3,null,null,4,4]       1      / \     2   2    / \   3   3  / \ 4   4 返回 fal
//se 。 Related Topics 树 深度优先搜索 
// 👍 23 👎 0

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

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(calcTreeDepth(root.left, 0) - calcTreeDepth(root.right, 0)) <= 1) {
                return isBalanced(root.left) && isBalanced(root.right);
            }
            return false;
        }

        private int calcTreeDepth(TreeNode root, int depth) {
            if (root == null) {
                return depth;
            }
            int l = calcTreeDepth(root.left, depth + 1);
            int r = calcTreeDepth(root.right, depth + 1);
            return Math.max(l, r);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isBalanced(TreeNode.getTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
            Assert.assertFalse(solution.isBalanced(TreeNode.getTreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        }
    }
}