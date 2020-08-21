package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SolutionTest404 {
//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 186 👎 0

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

        @SuppressWarnings("all")
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                while (n > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    addLeftChildren(node, result);
                    n--;
                }
            }
            return result.stream().mapToInt(Integer::intValue).sum();
        }

        private void addLeftChildren(TreeNode node, List<Integer> result) {
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result.add(node.left.val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(24, solution.sumOfLeftLeaves(TreeNode.getTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        }
    }
}