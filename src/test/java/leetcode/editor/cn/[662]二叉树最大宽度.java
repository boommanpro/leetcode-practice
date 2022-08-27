package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

class SolutionTest662 {
//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 450 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Solution {
        public class EnhanceTreeNode {
            int position;
            TreeNode node;

            public EnhanceTreeNode(int position, TreeNode node) {
                this.position = position;
                this.node = node;
            }
        }

        public int widthOfBinaryTree(TreeNode root) {
            Queue<EnhanceTreeNode> queue = new LinkedList<>();
            queue.add(new EnhanceTreeNode(0, root));
            int ans = 0;
            while (!queue.isEmpty()) {
                int n = queue.size();
                int start = queue.peek().position;
                while (n > 0) {
                    EnhanceTreeNode curr = queue.poll();
                    TreeNode node = curr.node;
                    int width = curr.position - start + 1;
                    ans = Math.max(ans, width);
                    if (node.left != null) {
                        queue.add(new EnhanceTreeNode(curr.position * 2, node.left));
                    }
                    if (node.right != null) {
                        queue.add(new EnhanceTreeNode(curr.position * 2 + 1, node.right));
                    }
                    n--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.widthOfBinaryTree(TreeNode.getTreeNode(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7})));
        }

    }
}