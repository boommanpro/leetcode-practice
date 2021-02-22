package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1770 {
//给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。 
//
// 初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要： 
//
// 
// 选择数组 nums 开头处或者末尾处 的整数 x 。 
// 你获得 multipliers[i] * x 分，并累加到你的分数中。 
// 将 x 从数组 nums 中移除。 
// 
//
// 在执行 m 步操作后，返回 最大 分数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3], multipliers = [3,2,1]
//输出：14
//解释：一种最优解决方案如下：
//- 选择末尾处的整数 3 ，[1,2,3] ，得 3 * 3 = 9 分，累加到分数中。
//- 选择末尾处的整数 2 ，[1,2] ，得 2 * 2 = 4 分，累加到分数中。
//- 选择末尾处的整数 1 ，[1] ，得 1 * 1 = 1 分，累加到分数中。
//总分数为 9 + 4 + 1 = 14 。 
//
// 示例 2： 
//
// 输入：nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
//输出：102
//解释：一种最优解决方案如下：
//- 选择开头处的整数 -5 ，[-5,-3,-3,-2,7,1] ，得 -5 * -10 = 50 分，累加到分数中。
//- 选择开头处的整数 -3 ，[-3,-3,-2,7,1] ，得 -3 * -5 = 15 分，累加到分数中。
//- 选择开头处的整数 -3 ，[-3,-2,7,1] ，得 -3 * 3 = -9 分，累加到分数中。
//- 选择末尾处的整数 1 ，[-2,7,1] ，得 1 * 4 = 4 分，累加到分数中。
//- 选择末尾处的整数 7 ，[-2,7] ，得 7 * 6 = 42 分，累加到分数中。
//总分数为 50 + 15 - 9 + 4 + 42 = 102 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// m == multipliers.length 
// 1 <= m <= 103 
// m <= n <= 105 
// -1000 <= nums[i], multipliers[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 28 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumScore(int[] nums, int[] multipliers) {
            int m = multipliers.length;
            int[][] dp = new int[m + 1][m + 1];
            dp[1][0] = multipliers[0] * nums[0];
            dp[0][1] = multipliers[0] * nums[nums.length - 1];
            for (int len = 2; len <= m; len++) {
                int mul = multipliers[len - 1];
                for (int l = 0; l <= len; l++) {
                    int r = len - l;
                    if (l == 0) {
                        dp[l][r] = dp[l][r - 1] + mul * nums[nums.length - r];
                        continue;
                    }
                    if (r == 0) {
                        dp[l][r] = dp[l - 1][r] + mul * nums[l - 1];
                        continue;
                    }
                    dp[l][r] = dp[l - 1][r] + mul * nums[l - 1];
                    dp[l][r] = Math.max(dp[l][r], dp[l][r - 1] + mul * nums[nums.length - r]);
                }
            }
            int max = Integer.MIN_VALUE;
            for (int l = 0; l <= m; l++) {
                max = Math.max(max, dp[l][m - l]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals(14, solution.maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
            Assert.assertEquals(102, solution.maximumScore(new int[]{-5, -3, -3, -2, 7, 1}, new int[]{-10, -5, 3, 4, 6}));
        }
    }
}