package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest965 {
//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树 
// 👍 67 👎 0

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

        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isUnival(root.left, root.val) && isUnival(root.right, root.val);
        }

        private boolean isUnival(TreeNode root, int val) {
            if (root == null) {
                return true;
            }
            if (root.val != val) {
                return false;
            }
            return isUnival(root.left, val) && isUnival(root.right, val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isUnivalTree(TreeNode.getTreeNode(new Integer[]{1, 1, 1, 1, 1, null, 1})));
            Assert.assertFalse(solution.isUnivalTree(TreeNode.getTreeNode(new Integer[]{2, 2, 2, 5, 2})));
        }
    }
}