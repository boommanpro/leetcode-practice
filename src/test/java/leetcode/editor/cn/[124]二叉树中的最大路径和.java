package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest124 {
//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索 
// 👍 662 👎 0

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

        int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return res;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMax = Math.max(0, dfs(root.left));         // 左孩子贡献
            int rightMax = Math.max(0, dfs(root.right));        // 右孩子贡献
            res = Math.max(res, root.val + leftMax + rightMax); // 更新res
            return root.val + Math.max(leftMax, rightMax);      // 返回当前节点的总贡献
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.maxPathSum(TreeNode.getTreeNode(new Integer[]{1, 2, 3})));
            Assert.assertEquals(42, solution.maxPathSum(TreeNode.getTreeNode(new Integer[]{-10, 9, 20, null, null, 15, 7})));
        }
    }
}