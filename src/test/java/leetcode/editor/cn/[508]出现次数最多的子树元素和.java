package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionTest508 {
//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表 
// 👍 81 👎 0

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
        Map<Integer, Integer> dict;

        public int[] findFrequentTreeSum(TreeNode root) {
            dict = new HashMap<>();
            calcValue(root);
            int temp = 0;
            for (Integer occur : dict.values()) {
                temp=Math.max(temp, occur);
            }
            final int max = temp;
            return dict.entrySet().stream().filter(e -> e.getValue().equals(max)).mapToInt(Map.Entry::getKey).toArray();
        }

        private int calcValue(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int p = root.val;
            int l = calcValue(root.left);
            int r = calcValue(root.right);
            int ans = p + l + r;
            dict.put(ans, dict.getOrDefault(ans, 0) + 1);
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2, -3, 4]", Arrays.toString(solution.findFrequentTreeSum(TreeNode.getTreeNode(new Integer[]{5, 2, -3}))));
            Assert.assertEquals("[2]", Arrays.toString(solution.findFrequentTreeSum(TreeNode.getTreeNode(new Integer[]{5, 2, -5}))));
        }
    }
}