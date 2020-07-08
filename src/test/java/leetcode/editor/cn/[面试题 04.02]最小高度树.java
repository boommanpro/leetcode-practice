package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题04_02 {
//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3 
//  9        /   /      -10  5 Related Topics 树 深度优先搜索 
// 👍 36 👎 0

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

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            int n = nums.length;
            return buildBST(nums, 0, n);
        }

        private TreeNode buildBST(int[] nums, int start, int end) {
            if (start >= end) {
                return null;
            }
            int mid = ((end - start) >> 1) + start;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildBST(nums, start, mid);
            root.right = buildBST(nums, mid + 1, end);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[0, -3, 9, -10, null, 5]", solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).toIntArrayString());
        }
    }
}