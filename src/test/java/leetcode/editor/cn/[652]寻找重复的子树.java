package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

class SolutionTest652 {
//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树

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

        List<TreeNode> ans;

        Map<String, Integer> dict;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            ans = new ArrayList<>();
            dict = new HashMap<>();
            dfs(root);
            return ans;
        }

        private String dfs(TreeNode root) {
            if (root == null) {
                return "#";
            }
            String tag = String.format("%s,%s,%s", root.val, dfs(root.left), dfs(root.right));
            Integer value = dict.getOrDefault(tag, 0);
            dict.put(tag, value + 1);
            if (value + 1 == 2) {
                ans.add(root);
            }
            return tag;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            System.out.println(solution.findDuplicateSubtrees(TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4})));
        }
    }
}