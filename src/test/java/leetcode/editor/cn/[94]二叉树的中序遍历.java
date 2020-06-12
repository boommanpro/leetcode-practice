package leetcode.editor.cn;

import java.util.List;

import org.junit.Test;

class SolutionTest94 {
//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

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

        public List<Integer> inorderTraversal(TreeNode root) {
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            solution.inorderTraversal(TreeNode.getTreeNode(new Integer[]{1, null, 2, 3}));
            solution.inorderTraversal(TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}));
            solution.inorderTraversal(TreeNode.getTreeNode(new Integer[]{8, 7, 5, 4, 3, 2, 1}));
        }
    }
}