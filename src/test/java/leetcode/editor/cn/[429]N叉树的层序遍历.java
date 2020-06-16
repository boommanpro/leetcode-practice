package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.editor.Node;
import org.junit.Test;

class SolutionTest429 {
//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索

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

        @SuppressWarnings("all")
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            List<Integer> subList;
            Node curr;
            Deque<Node> nodeQueue = new LinkedList<>();
            nodeQueue.offer(root);
            while (nodeQueue.size() > 0) {
                int n = nodeQueue.size();
                subList = new ArrayList<>();
                while (n > 0) {
                    curr = nodeQueue.poll();
                    subList.add(curr.val);
                    if (curr.children != null) {
                        for (Node child : curr.children) {
                            nodeQueue.offer(child);
                        }
                    }
                    n--;
                }
                ans.add(subList);
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
            List<Node> children = new ArrayList<>();
            children.add(new Node(3));
            children.add(new Node(2));
            children.add(new Node(4));
            Node root = new Node(1,children);
            System.out.println(solution.levelOrder(root));
        }
    }
}