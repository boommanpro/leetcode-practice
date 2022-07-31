package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

class SolutionTest1161 {
//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。 
//
// 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
// 
//
// 示例 2： 
//
// 
//输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 [1, 10⁴]范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 92 👎 0

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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 1;
        int max = root.val;
        int currDepth = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            int sum = 0;
            while (n > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                sum += curr.val;
                n--;
            }
            if (sum > max) {
                ans = currDepth;
                max = sum;
            }
            currDepth++;
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
            Assert.assertEquals(2,solution.maxLevelSum(TreeNode.getTreeNode(new Integer[]{989,null,10250,98693,-89388,null,null,null,-32127})));
        }
        
    }
}