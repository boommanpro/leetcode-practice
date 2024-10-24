package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class SolutionTest3180 {
//给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
//
// 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
//
//
// 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
// 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x +
//rewardValues[i]），并 标记 下标 i。
//
//
// 以整数形式返回执行最优操作能够获得的 最大 总奖励。
//
//
//
// 示例 1：
//
//
// 输入：rewardValues = [1,1,3,3]
//
//
// 输出：4
//
// 解释：
//
// 依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。
//
// 示例 2：
//
//
// 输入：rewardValues = [1,6,4,3,2]
//
//
// 输出：11
//
// 解释：
//
// 依次标记下标 0、2 和 1。总奖励为 11，这是可获得的最大值。
//
//
//
// 提示：
//
//
// 1 <= rewardValues.length <= 2000
// 1 <= rewardValues[i] <= 2000
//
//
// Related Topics数组 | 动态规划
//
// 👍 19, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTotalReward(int[] A) {
            Arrays.sort(A);
            int n = A.length;
            int max = A[n - 1] * 2 - 1;
            boolean[] dp = new boolean[max + 1];
            dp[0] = true;
            int ans = 0;
            for (int v : A) {
                for (int i = 0; i < v; i++) {
                    if (dp[i]) {
                        dp[i + v] = true;
                        ans = Math.max(ans, i + v);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testExample1() {
            int[] rewardValues = {1, 1, 3, 3};
            int expected = 4;
            assertEquals(expected, solution.maxTotalReward(rewardValues));
        }

        @Test
        public void testExample2() {
            int[] rewardValues = {1, 6, 4, 3, 2};
            int expected = 11;
            assertEquals(expected, solution.maxTotalReward(rewardValues));
        }
    }
}
