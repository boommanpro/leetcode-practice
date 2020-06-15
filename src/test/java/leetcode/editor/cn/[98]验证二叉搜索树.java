package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest98 {
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索

    public static
            //leetcode submit region begin(Prohibit modification and deletion)

            /**
             * Definition for a binary tree node.
             * public class TreeNode {
             * int val;
             * TreeNode left;
             * TreeNode right;
             * TreeNode(int x) { val = x; }
             * }
             */
    class Solution {

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) {
                return true;
            }
            if (root.val >= maxVal || root.val <= minVal) {
                return false;
            }
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertFalse(solution.isValidBST(TreeNode.getTreeNode(new Integer[]{1, 1})));
            Assert.assertTrue(solution.isValidBST(TreeNode.getTreeNode(new Integer[]{2, 1, 3})));
            Assert.assertTrue(solution.isValidBST(TreeNode.getTreeNode(new Integer[]{5, 1, 7, null, null, 6, 8})));
            Assert.assertFalse(solution.isValidBST(TreeNode.getTreeNode(new Integer[]{5, 1, 4, null, null, 3, 6})));
            Assert.assertFalse(solution.isValidBST(TreeNode.getTreeNode(new Integer[]{10, 5, 15, null, null, 6, 20})));
        }
    }
}