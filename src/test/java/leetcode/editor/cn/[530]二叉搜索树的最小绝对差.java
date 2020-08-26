package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest530 {
//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
//
//
//
// 示例：
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//
//
//
//
// 提示：
//
//
// 树中至少有 2 个节点。
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
//相同
//
// Related Topics 树
// 👍 133 👎 0

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
        int ans;

        public int getMinimumDifference(TreeNode root) {
            ans = Integer.MAX_VALUE;
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                ans = Math.min(ans, root.val - getMaxValue(root.left));
                dfs(root.left);
            }
            if (root.right != null) {
                ans = Math.min(ans, getMinValue(root.right) - root.val);
                dfs(root.right);
            }
        }

        private int getMinValue(TreeNode right) {
            while (right.left != null) {
                right = right.left;
            }
            return right.val;
        }

        private int getMaxValue(TreeNode left) {
            while (left.right != null) {
                left = left.right;
            }
            return left.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.getMinimumDifference(TreeNode.getTreeNode(new Integer[]{4, 2, 6, 1, 3})));
            //          90
            //     69
            // 49    89
            //   52
            Assert.assertEquals(1, solution.getMinimumDifference(TreeNode.getTreeNode(new Integer[]{90, 69, null, 49, 89, null, 52, null, null, null, null})));
            Assert.assertEquals(1, solution.getMinimumDifference(TreeNode.getTreeNode(new Integer[]{1, null, 3, 2})));
        }
    }
}