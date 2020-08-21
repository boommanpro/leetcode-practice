package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest129 {
//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 183 👎 0

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

        List<String> allPath;

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            allPath = new ArrayList<>();
            dfs(root, new StringBuilder());
            if (allPath.isEmpty()) {
                return 0;
            }
            int result = 0;
            for (String s : allPath) {
                result += Integer.parseInt(s);
            }
            return result;
        }

        private void dfs(TreeNode root, StringBuilder path) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                String temp = path.toString();
                allPath.add(temp + root.val);
                return;
            }
            path.append(root.val);
            dfs(root.left, path);
            dfs(root.right, path);
            int end = path.length();
            int start = end - 1;
            path.delete(start, end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(25, solution.sumNumbers(TreeNode.getTreeNode(new Integer[]{1, 2, 3})));
            Assert.assertEquals(1026, solution.sumNumbers(TreeNode.getTreeNode(new Integer[]{4, 9, 0, 5, 1})));
        }
    }
}