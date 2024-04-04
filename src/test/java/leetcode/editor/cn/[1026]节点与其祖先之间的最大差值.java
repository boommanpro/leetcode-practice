package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1026 {
//给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
//
//
// （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
//输出：7
//解释：
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
//
//
// 示例 2：
//
//
//输入：root = [1,null,2,null,0,3]
//输出：3
//
//
//
//
// 提示：
//
//
// 树中的节点数在 2 到 5000 之间。
// 0 <= Node.val <= 10⁵
//
//
// Related Topics树 | 深度优先搜索 | 二叉树
//
// 👍 228, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

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
        public int maxAncestorDiff(TreeNode root) {
            return (int) maxAncestorDiff(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private long maxAncestorDiff(TreeNode root, long maxValue, long minValue) {
            if (root == null) {
                return maxValue - minValue;
            }
            long max = Math.max(root.val, maxValue);
            long min = Math.min(minValue, root.val);
            return Math.max(maxAncestorDiff(root.left, max, min), maxAncestorDiff(root.right, max, min));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.maxAncestorDiff(TreeNode.getTreeNode(new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13})));
            Assert.assertEquals(3, solution.maxAncestorDiff(TreeNode.getTreeNode(new Integer[]{1, null, 2, null, 0, 3})));
        }

    }
}
