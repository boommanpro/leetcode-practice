package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest449 {
//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化
//为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 
// 👍 102 👎 0

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
        @SuppressWarnings("all")
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();
            queue.offer(root);
            result.add(root.val);
            while (!queue.isEmpty()) {
                int n = queue.size();
                while (n > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                        result.add(node.left.val);
                    }else {
                        result.add(null);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        result.add(node.right.val);
                    }else {
                        result.add(null);
                    }
                    n--;
                }
            }
            return result.stream().map(new Function<Integer, String>() {
                @Override
                public String apply(Integer integer) {
                    return integer==null?"null":integer.toString();
                }
            }).collect(Collectors.joining(","));
        }

        // Decodes your encoded data to tree.
        @SuppressWarnings("all")
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            }
            List<Integer> input = Arrays.stream(data.split(",")).map(new Function<String, Integer>() {
                @Override
                public Integer apply(String s) {
                    return s.equals("null")?null:Integer.parseInt(s);
                }
            }).collect(Collectors.toList());
            int len = input.size();
            TreeNode root = new TreeNode(input.get(0));
            int lineNum = 2;
            int curr = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty() && curr < len) {
                int n = queue.size();
                while (n > 0 && curr < len) {
                    TreeNode node = queue.poll();
                    if (input.get(curr) == null) {
                        node.left = null;
                    } else {
                        node.left = new TreeNode(input.get(curr));
                        queue.offer(node.left);
                    }
                    curr++;
                    if (curr < len) {
                        if (input.get(curr) == null) {
                            node.right = null;
                        } else {
                            node.right = new TreeNode(input.get(curr));
                            queue.offer(node.right);
                        }
                    }
                    curr++;
                    n--;
                }
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
            Codec codec = new Codec();
            String serialize = codec.serialize(TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4, 5, 6}));
            Assert.assertEquals("[1, 2, 3, 4, 5, 6]", codec.deserialize(serialize).toIntArrayString());


            String serialize1 = codec.serialize(TreeNode.getTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7}));
            Assert.assertEquals("[3, 9, 20, null, null, 15, 7]", codec.deserialize(serialize1).toIntArrayString());
        }
    }
}