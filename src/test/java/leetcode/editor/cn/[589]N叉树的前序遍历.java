package leetcode.editor.cn;

import leetcode.editor.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest589 {
//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        List<Integer> ans;
        public List<Integer> preorder(Node root) {
            ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            preOrder(root);
            return ans;
        }

        private void preOrder(Node root) {
            if (root == null) {
                return;
            }
            ans.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    preOrder(child);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            List<Node> list = new ArrayList<>();
            List<Node> subList = new ArrayList<>();
            subList.add(new Node(5));
            subList.add(new Node(6));
            list.add(new Node(3,subList));
            list.add(new Node(2));
            list.add(new Node(4));
            Node root = new Node(1, list);
            Assert.assertEquals("[1, 3, 5, 6, 2, 4]",solution.preorder(root).toString());
        }
    }
}