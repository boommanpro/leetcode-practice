package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest783 {
//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 递归 
// 👍 75 👎 0

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
        int min;

        public int minDiffInBST(TreeNode root) {
            //这是一个二叉搜索树
            //左小右大
            min = Integer.MAX_VALUE;
            dfs(root);
            return min;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                int maxValue = getMaxValue(root.left);
                min = Math.min(min, root.val - maxValue);
                dfs(root.left);
            }
            if (root.right != null) {
                int minValue = getMinValue(root.right);
                min = Math.min(min, minValue - root.val);
                dfs(root.right);
            }

        }

        private int getMaxValue(TreeNode root) {
            if (root.right != null) {
                return getMaxValue(root.right);
            }
            return root.val;
        }

        private int getMinValue(TreeNode root) {
            if (root.left != null) {
                return getMinValue(root.left);
            }
            return root.val;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.minDiffInBST(TreeNode.getTreeNode(new Integer[]{4, 2, 6, 1, 3})));
            //          90
            //     69
            // 49    89
            //   52
            Assert.assertEquals(1, solution.minDiffInBST(TreeNode.getTreeNode(new Integer[]{90, 69, null, 49, 89, null, 52, null, null, null, null})));
        }
    }
}