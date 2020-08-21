package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest113 {
//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 298 👎 0

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
        List<List<Integer>> result;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            List<Integer> path = new ArrayList<>();
            dfs(root, path, sum);
            return result;
        }

        private void dfs(TreeNode root, List<Integer> path, int sum) {
            if (root == null) {
                return;
            }
            if (root.val == sum && root.left == null && root.right == null) {
                List<Integer> temp = new ArrayList<>(path);
                temp.add(root.val);
                result.add(temp);
                return;
            }
            path.add(root.val);
            dfs(root.left, path, sum - root.val);
            dfs(root.right, path, sum - root.val);
            path.remove(path.size() - 1);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[5, 4, 11, 2], [5, 8, 4, 5]]", solution.pathSum(TreeNode.getTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22).toString());
            Assert.assertEquals("[]", solution.pathSum(TreeNode.getTreeNode(new Integer[]{1, 2}), 1).toString());
        }
    }
}