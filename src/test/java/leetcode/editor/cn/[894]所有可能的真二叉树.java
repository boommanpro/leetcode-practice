package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest894 {
//给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
//
// 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
//
// 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
//
//
//
// 示例 1：
//
//
//输入：n = 7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//
//
// 示例 2：
//
//
//输入：n = 3
//输出：[[0,0,0]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
//
// Related Topics树 | 递归 | 记忆化搜索 | 动态规划 | 二叉树
//
// 👍 337, 👎 0bug 反馈 | 使用指南 | 更多配套插件
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
        private static final List<TreeNode>[] f = new ArrayList[11];

        static {
            Arrays.setAll(f,i-> new ArrayList<>());
            f[1].add(new TreeNode());
            for (int i = 2; i < f.length; i++) {
                for (int j = 1; j < i; j++) {
                    for (TreeNode left : f[j]) {
                        for (TreeNode right : f[i - j]) {
                            f[i].add(new TreeNode(0, left, right));
                        }
                    }
                }
            }
        }
        public List<TreeNode> allPossibleFBT(int n) {
            return f[n % 2 > 0 ? (n + 1) / 2 : 0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

    }
}
