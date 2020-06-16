package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest106 {
//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
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

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> memo = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                memo.put(inorder[i], i);
            }
            return buildTree(0, inorder.length - 1, 0, postorder.length - 1, memo, postorder);
        }

        private TreeNode buildTree(int is, int ie, int ps, int pe, Map<Integer, Integer> memo, int[] post) {
            if (ie < is || pe < ps) {
                return null;
            }
            int rootValue = post[pe];
            int iOrder = memo.get(rootValue);
            TreeNode root = new TreeNode(rootValue);
            root.left = buildTree(is, iOrder - 1, ps, ps - is + iOrder - 1, memo, post);
            root.right = buildTree(iOrder + 1, ie, ps - is + iOrder, pe - 1, memo, post);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[3, 9, 20, null, null, 15, 7]", solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}).toIntArrayString());
        }
    }
}