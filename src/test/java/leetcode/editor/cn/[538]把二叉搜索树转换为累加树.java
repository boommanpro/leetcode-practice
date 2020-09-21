package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest538 {
//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。 
//
// 
//
// 例如： 
//
// 输入: 原始二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
// 
//
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-s
//um-tree/ 相同 
// Related Topics 树 
// 👍 342 👎 0

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

        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            sum = 0;
            dfs(root);
            return root;
        }

        private void dfs(TreeNode root) {
            if (root != null) {
                dfs(root.right);
                sum += root.val;
                root.val = sum;
                dfs(root.left);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[18, 20, 13]", solution.convertBST(TreeNode.getTreeNode(new Integer[]{5, 2, 13})).toIntArrayString());
        }
    }
}