package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest450 {
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树

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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key) {
                //重组
                return buildBinarySearch(root.left, root.right);
            }
            if (key > root.val) {
                root.right = deleteNode(root.right, key);
            }else {
                root.left = deleteNode(root.left, key);
            }
            return root;
        }

        public TreeNode buildBinarySearch(TreeNode left, TreeNode right) {
            if (left == null || right == null) {
                return left == null ? right : left;
            }
            //当前节点既有左子树 又有右子树
            //有如下两种解决方案
            //1.left放到右节点的左叶子节点
            //2.right放到左节点的右叶子节点
            TreeNode node = left;
            while (node.right != null) {
                node = node.right;
            }
            node.right = right;
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[5, 4, 6, 2, null, null, 7]", solution.deleteNode(TreeNode.getTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7}), 3).toIntArrayString());
            Assert.assertEquals("[5, 2, 6, null, 4, null, 7]", solution.deleteNode(TreeNode.getTreeNode(new Integer[]{5, 3, 6, 2, 4, null, 7}), 3).toIntArrayString());

        }
    }
}