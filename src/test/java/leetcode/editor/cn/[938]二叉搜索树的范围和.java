package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest938 {
//给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。 
//
// 二叉搜索树保证具有唯一的值。 
//
// 
//
// 示例 1： 
//
// 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
//               10
//            5     15
//         3    7      18

//输出：32
// 
//
// 示例 2： 
//
// 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 树中的结点数量最多为 10000 个。 
// 最终的答案保证小于 2^31。 
// 
// Related Topics 树 递归 
// 👍 130 👎 0

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

        public int rangeSumBST(TreeNode root, int L, int R) {
            ans = 0;
            range(root, L, R);
            return ans;
        }

        private void range(TreeNode root, int min, int max) {
            if (root == null) {
                return;
            }
            if (root.val >= min && root.val <= max) {
                ans += root.val;    // 符合范围，加起来
                range(root.left, min, max);
                range(root.right, min, max);

            }
            if (root.val < min) {
                range(root.right, min, max);
            }
            if (root.val > max) {
                range(root.left, min, max);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(32, solution.rangeSumBST(TreeNode.getTreeNode(new Integer[]{10, 5, 15, 3, 7, null, 18}), 7, 15));
            Assert.assertEquals(23, solution.rangeSumBST(TreeNode.getTreeNode(new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6}), 6, 10));
        }
    }
}