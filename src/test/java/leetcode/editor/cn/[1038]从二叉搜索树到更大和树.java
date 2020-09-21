package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1038 {
//给出二叉 搜索 树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 1 和 100 之间。 
// 每个节点的值介于 0 和 100 之间。 
// 给定的树为二叉搜索树。 
// 
//
// 
//
// 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/ 相同
// 
// Related Topics 二叉搜索树 
// 👍 80 👎 0

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

        int sum;

        public TreeNode bstToGst(TreeNode root) {
            sum = 0;
            dfs(root);
            return root;
        }

        private void dfs(TreeNode root) {
            if (root != null) {
                dfs(root.right);
                sum += root.val;
                root.val = sum;
                dfs(root.left);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8]",
                    solution.bstToGst(TreeNode.getTreeNode(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8})).toIntArrayString());
        }
    }
}