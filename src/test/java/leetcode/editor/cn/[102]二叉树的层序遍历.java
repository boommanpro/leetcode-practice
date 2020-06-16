package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

class SolutionTest102 {
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

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

        @SuppressWarnings("all")
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> subList;
            TreeNode curr ;
            Deque<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);
            while (nodeQueue.size() > 0) {
                int n = nodeQueue.size();
                subList = new ArrayList<>();
                while (n > 0) {
                    curr = nodeQueue.poll();
                    if (curr != null) {
                        subList.add(curr.val);
                        nodeQueue.offer(curr.left);
                        nodeQueue.offer(curr.right);
                    }
                    n--;
                }
                if (subList.size() > 0) {
                    ans.add(subList);
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
            System.out.println(solution.levelOrder(TreeNode.getTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        }
    }
}