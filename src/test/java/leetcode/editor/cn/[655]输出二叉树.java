package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SolutionTest655 {
//给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩
//阵需要遵循以下规则： 
//
// 
// 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。 
// 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。 
// 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。 
// 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在 
//res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。 
// 继续这一过程，直到树中的所有节点都妥善放置。 
// 任意空单元格都应该包含空字符串 "" 。 
// 
//
// 返回构造得到的矩阵 res 。 
//
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2]
//输出：
//[["","1",""],
// ["2","",""]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3,null,4]
//输出：
//[["","","","1","","",""],
// ["","2","","","","3",""],
// ["","","4","","","",""]]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 2¹⁰] 内 
// -99 <= Node.val <= 99 
// 树的深度在范围 [1, 10] 内 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 183 👎 0

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
        public class Tuple {
            private TreeNode root;
            private int position;

            public Tuple(TreeNode root, int position) {
                this.root = root;
                this.position = position;
            }
        }

        public List<List<String>> printTree(TreeNode root) {
            List<List<String>> ans = new ArrayList<>();
            int m = calcDepth(root);
            int height = m - 1;
            int n = (int) (Math.pow(2, height + 1) - 1);
            for (int i = 0; i < m; i++) {
                List<String> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add("");
                }
                ans.add(row);
            }
            Queue<Tuple> queue = new LinkedList<>();
            int i = 0;
            queue.add(new Tuple(root, (n - 1) / 2));
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    Tuple curr = queue.poll();
                    TreeNode node = curr.root;
                    ans.get(i).set(curr.position, node.val + "");
                    if (node.left != null) {
                        queue.add(new Tuple(node.left, curr.position - (int) Math.pow(2, height - i - 1)));
                    }
                    if (node.right != null) {
                        queue.add(new Tuple(node.right, curr.position + (int) Math.pow(2, height - i - 1)));
                    }
                    size--;
                }
                i++;
            }
            return ans;
        }

        private int calcDepth(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 0;
            while (!queue.isEmpty()) {
                int n = queue.size();
                while (n > 0) {
                    TreeNode curr = queue.poll();
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                    n--;
                }
                depth++;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[, 1, ], [2, , ]]", solution.printTree(TreeNode.getTreeNode(new Integer[]{1, 2})).toString());
            Assert.assertEquals("[[, , , 1, , , ], [, 2, , , , 3, ], [, , 4, , , , ]]", solution.printTree(TreeNode.getTreeNode(new Integer[]{1, 2, 3, null, 4})).toString());
        }

    }
}