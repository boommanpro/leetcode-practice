package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest1223 {
//有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。 
//
// 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。 
//
// 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。 
//
// 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, rollMax = [1,1,2,2,2,3]
//输出：34
//解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所
//以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
// 
//
// 示例 2： 
//
// 输入：n = 2, rollMax = [1,1,1,1,1,1]
//输出：30
// 
//
// 示例 3： 
//                     // 1 2 3 4 5 6
// 输入：n = 3, rollMax = [1,1,1,2,2,3]
//输出：181
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// rollMax.length == 6 
// 1 <= rollMax[i] <= 15 
// 
// Related Topics 动态规划 
// 👍 43 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = 1000000007;
        ;


        public int dieSimulator(int n, int[] rollMax) {
            int[][] dp = new int[n + 1][6];
            for (int j = 0; j < 6; ++j) {
                //在连续投掷的过程中 序列都为1
                for (int i = 1; i <= Math.min(n, rollMax[j]); ++i) {
                    dp[i][j] = 1;
                }
            }
            //从第二次开始算
            for (int i = 2; i <= n; ++i) {
                //当前数字是j
                for (int j = 0; j < 6; ++j) {
                    //连续投掷次数是k
                    for (int k = 1; k <= Math.min(rollMax[j], i); ++k) {
                        for (int l = 0; l < 6; ++l) {
                            //这块在之前已经计算过了
                            if (j == l) {
                                continue;
                            }
                            //dp[i-k]为 i-k次投掷为l的数字
                            dp[i][j] = (dp[i][j] + dp[i - k][l]) % MOD;
                        }
                    }
                }
            }
            return Arrays.stream(dp[n]).reduce(0, (a, b) -> (a + b) % MOD);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(34, solution.dieSimulator(2, new int[]{1, 1, 2, 2, 2, 3}));
            Assert.assertEquals(30, solution.dieSimulator(2, new int[]{1, 1, 1, 1, 1, 1}));
            Assert.assertEquals(181, solution.dieSimulator(3, new int[]{1, 1, 1, 2, 2, 3}));
            Assert.assertEquals(822005673, solution.dieSimulator(20, new int[]{8, 5, 10, 8, 7, 2}));
        }
    }
}