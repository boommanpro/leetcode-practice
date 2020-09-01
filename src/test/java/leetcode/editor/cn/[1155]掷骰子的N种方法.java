package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1155 {
//这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
//
// 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
//
// 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。
//
//
//
// 示例 1：
//
// 输入：d = 1, f = 6, target = 3
//输出：1
//
//
// 示例 2：
//
// 输入：d = 2, f = 6, target = 7
//输出：6
//
//
// 示例 3：
//
// 输入：d = 2, f = 5, target = 10
//输出：1
//
//
// 示例 4：
//
// 输入：d = 1, f = 2, target = 3
//输出：0
//
//
// 示例 5：
//
// 输入：d = 30, f = 30, target = 500
//输出：222616187
//
//
//
// 提示：
//
//
// 1 <= d, f <= 30
// 1 <= target <= 1000
//
// Related Topics 动态规划
// 👍 52 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = 1000000007;

        public int numRollsToTarget(int d, int f, int target) {
            int[][] dp = new int[d + 1][target + 1];
            for (int i = 1; i <= f && i <= target; i++) {
                dp[1][i] = 1;
            }
            for (int i = 2; i <= d; i++) {
                for (int j = i; j <= i * f && j <= target; j++) {
                    for (int l = 1; l <= f && j - l >= 0; l++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                    }
                }
            }
            return dp[d][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.numRollsToTarget(1, 6, 3));
            Assert.assertEquals(6, solution.numRollsToTarget(2, 6, 7));
            Assert.assertEquals(1, solution.numRollsToTarget(2, 5, 10));
            Assert.assertEquals(0, solution.numRollsToTarget(1, 2, 3));
            Assert.assertEquals(222616187, solution.numRollsToTarget(30, 30, 500));
        }
    }
}