package leetcode.editor.cn;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest421 {
//给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。 
//
// 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i, j < n 。 
//
// 你能在O(n)的时间解决这个问题吗？ 
//
// 示例: 
//
// 
//输入: [3, 10, 5, 25, 2, 8]
//
//输出: 28
//
//解释: 最大的结果是 5 ^ 25 = 28.
// 
// Related Topics 位运算 字典树

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 异或基础知识
         * 0和任意值x 异或之后还是 x
         * 如果ab相同 ab异或结果为0
         */
        public int findMaximumXOR(int[] nums) {
            // Compute length L of max number in a binary representation
            int maxNum = nums[0];
            for (int num : nums) maxNum = Math.max(maxNum, num);
            int L = (Integer.toBinaryString(maxNum)).length();

            // zero left-padding to ensure L bits for each number
            int n = nums.length, bitmask = 1 << L;
            String[] strNums = new String[n];
            for (int i = 0; i < n; ++i) {
                strNums[i] = Integer.toBinaryString(bitmask | nums[i]).substring(1);
            }

            TrieNode trie = new TrieNode();
            int maxXor = 0;
            for (String num : strNums) {
                TrieNode node = trie, xorNode = trie;
                int currXor = 0;
                for (Character bit : num.toCharArray()) {
                    // insert new number in trie
                    if (node.children.containsKey(bit)) {
                        node = node.children.get(bit);
                    } else {
                        TrieNode newNode = new TrieNode();
                        node.children.put(bit, newNode);
                        node = newNode;
                    }

                    // compute max xor of that new number
                    // with all previously inserted
                    Character toggledBit = bit == '1' ? '0' : '1';
                    if (xorNode.children.containsKey(toggledBit)) {
                        currXor = (currXor << 1) | 1;
                        xorNode = xorNode.children.get(toggledBit);
                    } else {
                        currXor = currXor << 1;
                        xorNode = xorNode.children.get(bit);
                    }
                }
                maxXor = Math.max(maxXor, currXor);
            }

            return maxXor;
        }

        static class TrieNode {

            HashMap<Character, TrieNode> children = new HashMap<>();

            public TrieNode() {
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(28, solution.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        }
    }
}