package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest105 {
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> memo = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                memo.put(inorder[i], i);
            }
            return buildTree(0, inorder.length - 1, 0, preorder.length - 1, memo, preorder);
        }

        private TreeNode buildTree(int is, int ie, int ps, int pe, Map<Integer, Integer> memo, int[] pre) {
            if (ie < is || ps < ps) {
                return null;
            }
            int root = pre[ps];
            int ri = memo.get(root);
            TreeNode node = new TreeNode(root);
            node.left = buildTree(is, ri - 1, ps + 1, ps + ri - is, memo, pre);
            node.right = buildTree(ri + 1, ie, ps + ri - is + 1, pe, memo, pre);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[3, 9, 20, null, null, 15, 7]", solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).toIntArrayString());
            Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, null, null, 8, 9, null, 10]", solution.buildTree(new int[]{1, 2, 4, 5, 8, 9, 3, 6, 10, 7}, new int[]{4, 2, 8, 5, 9, 1, 6, 10, 3, 7}).toIntArrayString());
        }
    }
}