package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class SolutionTest1305 {
//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 142 👎 0

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
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> ans = new ArrayList<>();
            preOderRoot(root1, ans);
            preOderRoot(root2, ans);
            return ans.stream().sorted().collect(Collectors.toList());
        }

        private void preOderRoot(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                preOderRoot(root.left, ans);
            }
            ans.add(root.val);
            if (root.right != null) {
                preOderRoot(root.right, ans);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[0, 1, 1, 2, 3, 4]", solution.getAllElements(TreeNode.getTreeNode(new Integer[]{2, 1, 4}), TreeNode.getTreeNode(new Integer[]{1, 0, 3})).toString());
            Assert.assertEquals("[1, 1, 8, 8]", solution.getAllElements(TreeNode.getTreeNode(new Integer[]{1, null, 8}), TreeNode.getTreeNode(new Integer[]{8, 1})).toString());
            Assert.assertEquals("[0, 1, 5, 7]", solution.getAllElements(null, TreeNode.getTreeNode(new Integer[]{5, 1, 0, 7})).toString());
        }

    }
}