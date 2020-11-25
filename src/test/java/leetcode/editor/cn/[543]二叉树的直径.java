package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest543 {
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 549 👎 0

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

        int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 0;
            depth(root);
            return ans;
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int L = depth(root.left);
            int R = depth(root.right);
            ans = Math.max(L + R,ans) ;
            return Math.max(L, R) + 1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.diameterOfBinaryTree(TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4, 5})));
        }
    }
}