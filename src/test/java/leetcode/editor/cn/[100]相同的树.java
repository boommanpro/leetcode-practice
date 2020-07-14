package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest100 {
//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索 
// 👍 396 👎 0

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

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return left && right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isSameTree(TreeNode.getTreeNode(new Integer[]{1, 2, 3}), TreeNode.getTreeNode(new Integer[]{1, 2, 3})));
            Assert.assertTrue(solution.isSameTree(TreeNode.getTreeNode(new Integer[]{1, 2}), TreeNode.getTreeNode(new Integer[]{1, 2})));
            Assert.assertFalse(solution.isSameTree(TreeNode.getTreeNode(new Integer[]{1, 2, 1}), TreeNode.getTreeNode(new Integer[]{1, 1, 2})));
            Assert.assertFalse(solution.isSameTree(TreeNode.getTreeNode(new Integer[]{1, null, 1, 1, 2}), TreeNode.getTreeNode(new Integer[]{1, null, 1, 1, 1})));
        }
    }
}