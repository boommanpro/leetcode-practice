package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest437 {
//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树

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

        int count = 0;

        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            int p = dfs(root, sum);
            int l = pathSum(root.left, sum);
            int r = pathSum(root.right, sum);
            return p + l + r;
        }

        private int dfs(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            int p = root.val == sum ? 1 : 0;
            int l = dfs(root.left, sum - root.val);
            int r = dfs(root.right, sum - root.val);
            return p + l + r;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.pathSum(TreeNode.getTreeNode(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8));
            Assert.assertEquals(2, solution.pathSum(TreeNode.getTreeNode(new Integer[]{1, null, 2, null, 3, null, 4, null, 5}), 3));
            ;
        }
    }
}