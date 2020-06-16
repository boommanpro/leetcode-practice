package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

class SolutionTest101 {
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索

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
        public boolean isSymmetric(TreeNode root) {
            Deque<TreeNode> nodeQueue = new LinkedList<>();
            Deque<Integer> valueQueue = new LinkedList<>();
            TreeNode curr;
            nodeQueue.offer(root);
            while (nodeQueue.size() > 0) {
                int n = nodeQueue.size();
                while (n > 0) {
                    curr = nodeQueue.poll();
                    if (curr != null) {
                        valueQueue.offerLast(curr.val);
                        nodeQueue.offerLast(curr.left);
                        nodeQueue.offerLast(curr.right);
                    } else {
                        valueQueue.offerLast(null);
                    }
                    n--;
                }
                //check valueQueue
                while (valueQueue.size() > 0) {
                    if (!Objects.equals(valueQueue.getFirst(),valueQueue.getLast()) ) {
                        return false;
                    }
                    valueQueue.pollFirst();
                    valueQueue.pollLast();
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isSymmetric(TreeNode.getTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
            Assert.assertFalse(solution.isSymmetric(TreeNode.getTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3})));

        }
    }
}