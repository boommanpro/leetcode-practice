package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest109 {
//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 296 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
        public TreeNode sortedListToBST(ListNode head) {
            //将有序链表转数组
            int[] nums = transform(head);
            //然后将题目转化为有序数组->平衡二叉树
            return buildBst(nums, 0, nums.length - 1);
        }

        private TreeNode buildBst(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }
            int mid = ((r - l) >> 1) + l;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildBst(nums, l, mid - 1);
            root.right = buildBst(nums, mid + 1, r);
            return root;
        }

        private int[] transform(ListNode head) {
            List<Integer> array = new ArrayList<>();
            while (head != null) {
                array.add(head.val);
                head = head.next;
            }
            return array.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[0, -3, 9, -10, null, 5]", solution.sortedListToBST(ListNode.fromArray(new Integer[]{-10, -3, 0, 5, 9})).toIntArrayString());
        }
    }
}