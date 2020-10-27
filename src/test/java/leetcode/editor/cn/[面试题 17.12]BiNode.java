package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题17_12 {
//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 树 二叉搜索树 递归 
// 👍 47 👎 0

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

        public TreeNode convertBiNode(TreeNode root) {
            if (root == null) {
                return null;
            }
            //二叉搜索树 => 链表树(满足二叉搜索树性质)
            List<TreeNode> orderList = new ArrayList<>();
            // 中序遍历是升序
            dfs(root, orderList);
            TreeNode prev = orderList.get(0);
            prev.left = null;
            for (int i = 1; i < orderList.size(); i++) {
                TreeNode curr = orderList.get(i);
                prev.right = curr;
                prev = curr;
                prev.left = null;
            }
            return orderList.get(0);
        }

        private void dfs(TreeNode root,List<TreeNode> orderList) {
            if (root != null) {
                dfs(root.left, orderList);
                orderList.add(root);
                dfs(root.right, orderList);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[0, null, 1, null, 2, null, 3, null, 4, null, 5, null, 6]", solution.convertBiNode(TreeNode.getTreeNode(new Integer[]{4, 2, 5, 1, 3, null, 6, 0})).toIntArrayString());
        }
    }
}