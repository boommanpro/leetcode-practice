package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest99 {
//二叉搜索树中的两个节点被错误地交换。 
//
// 请在不改变其结构的情况下，恢复这棵树。 
//
// 示例 1: 
//
// 输入: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//输出: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
// 
//
// 示例 2: 
//
// 输入: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//输出: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3 
//
// 进阶: 
//
// 
// 使用 O(n) 空间复杂度的解法很容易实现。 
// 你能想出一个只使用常数空间的解决方案吗？ 
// 
// Related Topics 树 深度优先搜索 
// 👍 299 👎 0

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
        public void recoverTree(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            //中序遍历 获取nums
            inorder(root, nums);
            //获取swap的两个位置
            int[] swapped = findTwoSwapped(nums);
            //旋转节点
            recover(root, 2, swapped[0], swapped[1]);
        }

        public void inorder(TreeNode root, List<Integer> nums) {
            if (root == null) {
                return;
            }
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        public int[] findTwoSwapped(List<Integer> nums) {
            int n = nums.size();
            int x = -1, y = -1;
            for (int i = 0; i < n - 1; ++i) {
                if (nums.get(i + 1) < nums.get(i)) {
                    y = nums.get(i + 1);
                    if (x == -1) {
                        x = nums.get(i);
                    } else {
                        break;
                    }
                }
            }
            return new int[]{x, y};
        }

        public void recover(TreeNode root, int count, int x, int y) {
            if (root != null) {
                if (root.val == x || root.val == y) {
                    root.val = root.val == x ? y : x;
                    if (--count == 0) {
                        return;
                    }
                }
                recover(root.right, count, x, y);
                recover(root.left, count, x, y);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            //测试用例1
            TreeNode root0 = TreeNode.getTreeNode(new Integer[]{1, 3, null, null, 2});
            solution.recoverTree(root0);
            Assert.assertEquals("[3, 1, null, null, 2]", root0.toIntArrayString());
            //测试用例2
            TreeNode root1 = TreeNode.getTreeNode(new Integer[]{3, 1, 4, null, null, 2});
            solution.recoverTree(root1);
            Assert.assertEquals("[2, 1, 4, null, null, 3]", root1.toIntArrayString());
        }
    }
}