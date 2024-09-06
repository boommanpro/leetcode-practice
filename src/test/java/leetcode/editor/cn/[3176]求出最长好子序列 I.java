package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3176 {
//给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在下标范围 [0, seq.length - 2] 中 最多只有 k 个
//下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
//
// 请你返回 nums 中 好 子序列 的最长长度。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,1,1,3], k = 2
//
//
// 输出：4
//
// 解释：
//
// 最长好子序列为 [1,2,1,1,3] 。
//
// 示例 2：
//
//
// 输入：nums = [1,2,3,4,5,1], k = 0
//
//
// 输出：2
//
// 解释：
//
// 最长好子序列为 [1,2,3,4,5,1] 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 500
// 1 <= nums[i] <= 10⁹
// 0 <= k <= min(nums.length, 25)
//
//
// Related Topics数组 | 哈希表 | 动态规划
//
// 👍 38, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(int[] nums, int k) {
            int n = nums.length;
            int[][] dp = new int[n][k + 1];
            int ans = 1;
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    for (int l = 0; l <= k; l++) {
                        if (nums[i] == nums[j]) {
                            dp[i][l] = Math.max(dp[i][l], dp[j][l] + 1);
                        } else if (l > 0) {
                            dp[i][l] = Math.max(dp[i][l], dp[j][l - 1] + 1);
                        }
                        ans = Math.max(ans, dp[i][l]);
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
        public void testMaximumLength_Example1() {
            int[] nums = {1, 2, 1, 1, 3};
            int k = 2;
            int expected = 4;
            assertEquals(expected, solution.maximumLength(nums, k));
        }

        @Test
        public void testMaximumLength_Example2() {
            int[] nums = {1, 2, 3, 4, 5, 1};
            int k = 0;
            int expected = 2;
            assertEquals(expected, solution.maximumLength(nums, k));
        }

        @Test
        public void testMaximumLength_Example3() {
            int[] nums = {2};
            int k = 0;
            int expected = 1;
            assertEquals(expected, solution.maximumLength(nums, k));
        }

    }
}
