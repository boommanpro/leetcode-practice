package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest297 {
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计

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
     class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            List<Integer> result = new ArrayList<>();
            Deque<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.offerLast(root);
            while (nodeQueue.size() > 0) {
                int n = nodeQueue.size();
                while (n > 0) {
                    TreeNode curr = nodeQueue.pollFirst();
                    if (curr != null) {
                        result.add(curr.val);
                        nodeQueue.offerLast(curr.left);
                        nodeQueue.offerLast(curr.right);
                    }else {
                        result.add(null);
                    }
                    n--;
                }
            }
            for (int i = result.size() - 1; i >= 0; i--) {
                if (result.get(i) == null) {
                    result.remove(i);
                }else {
                    return list2String(result);
                }
            }
            return list2String(result);
        }

        private String list2String(List<Integer> list) {
            return String.format("[%s]", list.stream().map(String::valueOf).collect(Collectors.joining(",")));
        }

        // Decodes your encoded data to tree.
        @SuppressWarnings("all")
        public TreeNode deserialize(String data) {
            if (data == null || data.length() <= 2) {
                return null;
            }
            List<Integer> nums = new ArrayList<>();
            String[] split = data.substring(1, data.length() - 1).split(",");
            for (String curr : split) {
                if (curr.equals("null")) {
                    nums.add(null);
                }else {
                    nums.add(Integer.valueOf(curr));
                }
            }
            int length = nums.size();
            Deque<TreeNode> nodeQueue = new LinkedList<>();
            TreeNode curr;
            TreeNode root = new TreeNode(nums.get(0));
            nodeQueue.offerLast(root);
            int startIndex = 1;
            int lineNum = 2;
            int restLength = length - startIndex;
            while (restLength > 0) {
                for (int i = startIndex; i < lineNum + startIndex; i += 2) {
                    curr = nodeQueue.pollFirst();
                    if (i == length) {
                        return root;
                    }
                    if (nums.get(i) != null) {
                        TreeNode left = new TreeNode(nums.get(i));
                        curr.left = left;
                        nodeQueue.offerLast(left);
                    }
                    if (i + 1 == length) {
                        return root;
                    }
                    if (nums.get(i + 1) != null) {
                        TreeNode right = new TreeNode(nums.get(i+1));
                        curr.right = right;
                        nodeQueue.offerLast(right);
                    }
                }
                startIndex += lineNum;
                restLength -= lineNum;
                lineNum = nodeQueue.size() * 2;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Codec solution = new Codec();
            Assert.assertEquals("[1, 2, 3, null, null, 4, 5]", solution.deserialize("[1,2,3,null,null,4,5]").toIntArrayString());
            Assert.assertEquals("[1,2,3,null,null,4,5]", solution.serialize(TreeNode.getTreeNode(new Integer[]{1, 2, 3, null, null, 4, 5})));

        }
    }
}