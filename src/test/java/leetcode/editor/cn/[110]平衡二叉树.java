package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest110 {
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
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
        /**
         * 同样，在定义中， 我们提到了高度平衡的二叉树一个特性: 每个节点的两个子树的深度不会相差超过1。我们也可以根据这个性质，递归地验证树。
         * 正如我们之前提到的, 一个有N个节点的平衡二搜索叉树的高度总是logN。因此，我们可以计算节点总数和树的高度，以确定这个二叉搜索树是否为高度平衡的。
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (Math.abs(calcMaxDepth(root.left, 0) - calcMaxDepth(root.right, 0)) <= 1) {
                return isBalanced(root.left)&&isBalanced(root.right);
            }
            //分别计算 二叉树的左右节点的最大最大深度,然后他们的深度差要<=1
            return false;
        }

        private boolean isHeightBalanced(TreeNode root) {
            int num = calcNodeCount(root);
            //二叉树的高度
            int h = calcMaxDepth(root, 0) - 1;
            if (h > double2Int(Math.log(num) / Math.log(2))) {
                return false;
            }
            return true;
        }

        private int double2Int(double d) {
            int ans = (int) d;
            if (d > ans) {
                return ans + 1;
            }
            return ans;
        }

        private int calcNodeCount(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = calcNodeCount(root.left);
            int right = calcNodeCount(root.right);
            return right + left + 1;
        }

        private int calcMaxDepth(TreeNode root, int depth) {
            if (root == null) {
                return depth;
            }
            int left = calcMaxDepth(root.left, depth + 1);
            int right = calcMaxDepth(root.right, depth + 1);
            return Math.max(left, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isBalanced(TreeNode.getTreeNode(new Integer[]{1})));
            Assert.assertTrue(solution.isBalanced(TreeNode.getTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
            Assert.assertFalse(solution.isBalanced(TreeNode.getTreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
            Assert.assertTrue(solution.isBalanced(null));
            Assert.assertFalse(solution.isBalanced(TreeNode.getTreeNode(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4})));
            Assert.assertTrue(solution.isBalanced(TreeNode.getTreeNode(new Integer[]{1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5})));
        }
    }
}