package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class SolutionTest1019 {
//给定一个长度为 n 的链表 head 
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为 n 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
//
// Related Topics 栈 数组 链表 单调栈 👍 290 👎 0

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
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            int n = list.size();
            int[] ans = new int[n];
            TreeMap<Integer, List<Integer>> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int v = list.get(i);
                List<Integer> temp = map.getOrDefault(v, new ArrayList<>());
                temp.add(i);
                map.put(v, temp);
                while (map.lowerEntry(v) != null) {
                    Map.Entry<Integer, List<Integer>> entry = map.lowerEntry(v);
                    for (Integer p : entry.getValue()) {
                        ans[p] = v;
                    }
                    map.remove(entry.getKey());
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
            Assert.assertEquals("[5, 5, 0]", Arrays.toString(solution.nextLargerNodes(ListNode.fromArray(new Integer[]{2,1,5}))));
            Assert.assertEquals("[7,0,5,5,0]", Arrays.toString(solution.nextLargerNodes(ListNode.fromArray(new Integer[]{2,7,4,3,5}))));
        }

    }
}