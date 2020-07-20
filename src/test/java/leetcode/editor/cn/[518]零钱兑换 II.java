package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest518 {
//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
// 👍 198 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int change(int amount, int[] coins) {
            int[] f = new int[amount + 1];
            f[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    f[i] += f[i - coin];
                }
            }
            return f[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.change(5, new int[]{1, 2, 5}));
            Assert.assertEquals(0, solution.change(3, new int[]{2}));
            Assert.assertEquals(1, solution.change(10, new int[]{10}));
        }
    }
}