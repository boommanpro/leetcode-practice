package leetcode.editor.cn;

import leetcode.editor.cn.random.Node;
import org.junit.Test;

import java.util.HashMap;

class SolutionTest138 {
//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 
//
// 要求返回这个链表的 深拷贝。 
//
// 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
// Related Topics 哈希表 链表

    public static
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
        // HashMap which holds old nodes as keys and new nodes as its values.
        HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

        public Node copyRandomList(Node head) {

            if (head == null) {
                return null;
            }

            // If we have already processed the current node, then we simply return the cloned version of
            // it.
            if (this.visitedHash.containsKey(head)) {
                return this.visitedHash.get(head);
            }

            // Create a new node with the value same as old node. (i.e. copy the node)
            Node node = new Node(head.val, null, null);

            // Save this value in the hash map. This is needed since there might be
            // loops during traversal due to randomness of random pointers and this would help us avoid
            // them.
            this.visitedHash.put(head, node);

            // Recursively copy the remaining linked list starting once from the next pointer and then from
            // the random pointer.
            // Thus we have two independent recursive calls.
            // Finally we update the next and random pointers for the new node created.
            node.next = this.copyRandomList(head.next);
            node.random = this.copyRandomList(head.random);

            return node;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }
    }
}