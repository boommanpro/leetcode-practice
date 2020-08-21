package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SolutionTest257 {
//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 312 👎 0

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

        public List<String> binaryTreePaths(TreeNode root) {
            result = new ArrayList<>();
            dfs(root,new ArrayList<>());
            return result.stream().map(list -> list.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("->")))
                    .collect(Collectors.toList());
        }

        private void dfs(TreeNode root, List<Integer> path) {
            if (root != null && root.left == null && root.right == null) {
                List<Integer> temp = new ArrayList<>(path);
                temp.add(root.val);
                result.add(temp);
                return;
            }
            if (root == null) {
                return;
            }

            path.add(root.val);
            dfs(root.left, path);
            dfs(root.right, path);
            path.remove(path.size() - 1);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1->2->5, 1->3]", solution.binaryTreePaths(TreeNode.getTreeNode(new Integer[]{1, 2, 3, null, 5})).toString());
        }
    }
}