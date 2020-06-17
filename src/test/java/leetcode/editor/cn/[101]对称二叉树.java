package leetcode.editor.cn;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest101 {
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索

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

        public boolean isSymmetric(TreeNode root) {
            return symmetric(root, root);
        }

        private boolean symmetric(TreeNode left, TreeNode right) {
            if (Objects.isNull(left)&&Objects.isNull(right)) {
                return true;
            }
            if (Objects.isNull(left) || Objects.isNull(right)) {
                return false;
            }
            if (!Objects.equals(left.val, right.val)) {
                return false;
            }
            return symmetric(left.left, right.right) && symmetric(left.right, right.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isSymmetric(TreeNode.getTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
            Assert.assertFalse(solution.isSymmetric(TreeNode.getTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3})));
            Assert.assertFalse(solution.isSymmetric(TreeNode.getTreeNode(new Integer[]{1,2,3})));

        }
    }
}