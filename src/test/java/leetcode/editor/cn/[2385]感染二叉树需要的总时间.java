package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest2385 {
//给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发
//。
//
// 每分钟，如果节点满足以下全部条件，就会被感染：
//
//
// 节点此前还没有感染。
// 节点与一个已感染节点相邻。
//
//
// 返回感染整棵树需要的分钟数。
//
//
//
// 示例 1：
// 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
//输出：4
//解释：节点按以下过程被感染：
//- 第 0 分钟：节点 3
//- 第 1 分钟：节点 1、10、6
//- 第 2 分钟：节点5
//- 第 3 分钟：节点 4
//- 第 4 分钟：节点 9 和 2
//感染整棵树需要 4 分钟，所以返回 4 。
//
//
// 示例 2：
// 输入：root = [1], start = 1
//输出：0
//解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 10⁵] 内
// 1 <= Node.val <= 10⁵
// 每个节点的值 互不相同
// 树中必定存在值为 start 的节点
//
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 二叉树
//
// 👍 64, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

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

        private TreeNode startNode;

        public int amountOfTime(TreeNode root, int start) {
            Map<TreeNode, TreeNode> fa = new HashMap<>();
            dfs(root, null, fa, start);
            return maxDepth(startNode, startNode, fa) - 1;
        }

        private int maxDepth(TreeNode node, TreeNode from, Map<TreeNode, TreeNode> fa) {
            if (node == null) {
                return 0;
            }
            int res = 0;
            if (node.left != from) {
                res = Math.max(res, maxDepth(node.left, node, fa));
            }
            if (node.right != from) {
                res = Math.max(res, maxDepth(node.right, node, fa));
            }
            if (fa.get(node) != from) {
                res = Math.max(res, maxDepth(fa.get(node), node, fa));
            }
            return res + 1;
        }

        private void dfs(TreeNode root, TreeNode node, Map<TreeNode, TreeNode> fa, int start) {
            if (root == null) {
                return;
            }
            fa.put(root, node);
            if (root.val == start) {
                startNode = root;
            }
            dfs(root.left, root, fa, start);
            dfs(root.right, root, fa, start);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.amountOfTime(TreeNode.getTreeNode(new Integer[]{1, 5, 3, null, 4, 10, 6, 9, 2}), 3));
            Assert.assertEquals(0, solution.amountOfTime(TreeNode.getTreeNode(new Integer[]{1}), 1));
            Assert.assertEquals(3, solution.amountOfTime(TreeNode.getTreeNode(new Integer[]{5, 2, 3, 4, null, null, null, 1}), 4));
        }

    }
}
