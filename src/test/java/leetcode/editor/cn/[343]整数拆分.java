package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest343 {
//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 291 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int integerBreak(int n) {
            int[] f = new int[n + 1];
            f[1] = 1;
            for (int i = 2; i <= n; i++) {
                calcFn(i, f);
            }
            return f[n];
        }

        private void calcFn(int n, int[] f) {
            for (int i = 1; i < n; i++) {
                f[n] = Math.max(Math.max(i * f[n - i], f[n]), i * (n - i));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.integerBreak(2));
            Assert.assertEquals(2, solution.integerBreak(3));
            Assert.assertEquals(4, solution.integerBreak(4));
            Assert.assertEquals(6, solution.integerBreak(5));
            Assert.assertEquals(9, solution.integerBreak(6));
            Assert.assertEquals(12, solution.integerBreak(7));
            Assert.assertEquals(36, solution.integerBreak(10));
        }
    }
}