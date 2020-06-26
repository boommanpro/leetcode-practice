package leetcode.editor.cn;

import leetcode.editor.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest590 {
//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
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

        public List<Integer> postorder(Node root) {
            ans = new ArrayList<>();
            postOrder(root);
            return ans;
        }

        private void postOrder(Node root) {
            if (root == null) {
                return;
            }
            if (root.children != null) {
                for (Node child : root.children) {
                    postOrder(child);
                }
            }
            ans.add(root.val);
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
            Assert.assertEquals("[5, 6, 3, 2, 4, 1]",solution.postorder(root).toString());
        }
    }
}