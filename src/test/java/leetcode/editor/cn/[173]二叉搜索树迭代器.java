package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest173 {
//实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。 
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。 
//
// 
//
// 示例： 
//
// 
//
// BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // 返回 3
//iterator.next();    // 返回 7
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 9
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 15
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 20
//iterator.hasNext(); // 返回 false 
//
// 
//
// 提示： 
//
// 
// next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。 
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。 
// 
// Related Topics 栈 树 设计

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
    class BSTIterator {

        private int index;

        private List<Integer> inOrderList;

        public BSTIterator(TreeNode root) {
            this.index = -1;
            this.inOrderList = new ArrayList<>();
            inorderTraversal(root);
        }

        private void inorderTraversal(TreeNode root) {
            if (root != null) {
                inorderTraversal(root.left);
                inOrderList.add(root.val);
                inorderTraversal(root.right);
            }

        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return inOrderList.get(++index);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return index < inOrderList.size() - 1;
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        /**
         * 二叉搜索的前序遍历就是从小到大
         */
        @Test
        public void defaultSolutionTest() {
            BSTIterator iterator = new BSTIterator(TreeNode.getTreeNode(new Integer[]{7, 3, 15, null, null, 9, 20}));
            Assert.assertEquals(3, iterator.next());     // 返回 3
            Assert.assertEquals(7, iterator.next());    // 返回 7
            Assert.assertTrue(iterator.hasNext()); // 返回 true
            Assert.assertEquals(9, iterator.next());    // 返回 9
            Assert.assertTrue(iterator.hasNext()); // 返回 true
            Assert.assertEquals(15, iterator.next());    // 返回 15
            Assert.assertTrue(iterator.hasNext()); // 返回 true
            Assert.assertEquals(20, iterator.next());    // 返回 20
            Assert.assertFalse(iterator.hasNext()); // 返回 false
        }
    }
}