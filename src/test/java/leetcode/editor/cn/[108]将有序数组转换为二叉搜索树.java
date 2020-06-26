package leetcode.editor.cn;

import org.junit.Test;

class SolutionTest108 {
//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索

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
            //nums是二叉平衡树的中序遍历
            return treeBuildHelper(nums,0,nums.length);
        }

        private TreeNode treeBuildHelper(int[] nums, int start, int end) {
            if (start >= end) {
                return null;
            }
            int mid = ((end - start) >> 1) + start;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = treeBuildHelper(nums, start, mid);
            root.right = treeBuildHelper(nums, mid + 1, end);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            System.out.println(solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).toIntArrayString());
        }
    }
}