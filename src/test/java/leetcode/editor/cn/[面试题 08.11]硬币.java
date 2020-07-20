package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题08_11 {
//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007) 
//
// 示例1: 
//
// 
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
// 
//
// 示例2: 
//
// 
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
// 
//
// 说明： 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= n (总金额) <= 1000000 
// 
// Related Topics 动态规划 
// 👍 150 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int mod = 1000000007;

        private static final int[] coins = {1, 5, 10, 25};

        public int waysToChange(int n) {
            int[] f = new int[n + 1];
            f[0] = 1;
            for (int c = 0; c < 4; c++) {
                int coin = coins[c];
                for (int i = coin; i <= n; i++) {
                    f[i] = (f[i - coin] + f[i]) % mod;
                }
            }
            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.waysToChange(5));
            Assert.assertEquals(4, solution.waysToChange(10));
            Assert.assertEquals(13, solution.waysToChange(25));
            Assert.assertEquals(73, solution.waysToChange(61));
        }
    }
}