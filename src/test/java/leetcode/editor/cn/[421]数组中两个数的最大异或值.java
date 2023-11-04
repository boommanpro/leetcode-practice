package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
            int max = Arrays.stream(nums).max().getAsInt();
            int len = Integer.toBinaryString(max).length();
            int ans = 0;
            for (int k = len - 1; k >= 0; k--) {
                Set<Integer> seen = new HashSet<>();
                for (int num : nums) {
                    seen.add(num >> k);
                }
                ans <<= 1;
                int nextAns = ans + 1;
                for (int num : nums) {
                    if (seen.contains((num >> k) ^ nextAns)) {
                        ans = nextAns;
                        break;
                    }
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
            Assert.assertEquals(28, solution.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        }
    }
}
