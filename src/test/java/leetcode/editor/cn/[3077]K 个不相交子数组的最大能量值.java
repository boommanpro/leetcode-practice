package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest3077 {
//给你一个长度为 n 下标从 0 开始的整数数组 nums 和一个 正奇数 整数 k 。
//
// x 个子数组的能量值定义为 strength = sum[1] * x - sum[2] * (x - 1) + sum[3] * (x - 2) -
//sum[4] * (x - 3) + ... + sum[x] * 1 ，其中 sum[i] 是第 i 个子数组的和。更正式的，能量值是满足 1 <= i <=
//x 的所有 i 对应的 (-1)ⁱ⁺¹ * sum[i] * (x - i + 1) 之和。
//
// 你需要在 nums 中选择 k 个 不相交子数组 ，使得 能量值最大 。
//
// 请你返回可以得到的 最大能量值 。
//
// 注意，选出来的所有子数组 不 需要覆盖整个数组。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,-1,2], k = 3
//输出：22
//解释：选择 3 个子数组的最好方式是选择：nums[0..2] ，nums[3..3] 和 nums[4..4] 。能量值为 (1 + 2 + 3) * 3
// - (-1) * 2 + 2 * 1 = 22 。
//
//
// 示例 2：
//
//
//输入：nums = [12,-2,-2,-2,-2], k = 5
//输出：64
//解释：唯一一种选 5 个不相交子数组的方案是：nums[0..0] ，nums[1..1] ，nums[2..2] ，nums[3..3] 和 nums[4
//..4] 。能量值为 12 * 5 - (-2) * 4 + (-2) * 3 - (-2) * 2 + (-2) * 1 = 64 。
//
//
// 示例 3：
//
//
//输入：nums = [-1,-2,-3], k = 1
//输出：-1
//解释：选择 1 个子数组的最优方案是：nums[0..0] 。能量值为 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
// 1 <= k <= n
// 1 <= n * k <= 10⁶
// k 是奇数。
//
//
// Related Topics数组 | 动态规划 | 前缀和
//
// 👍 11, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumStrength(int[] nums, int k) {
            int n = nums.length;
            long[] s = new long[n + 1];
            for (int i = 0; i < n; i++) {
                s[i + 1] = s[i] + nums[i];
            }
            long[][] f = new long[n + 1][k + 1];
            for (int i = 1; i <= k; i++) {
                f[i - 1][i] = Long.MIN_VALUE;
                long mx = Long.MIN_VALUE;
                int w = (i % 2 == 0 ? -1 : 1) * (k - i + 1);
                for (int j = i; j <= n - k + i; j++) {
                    mx = Math.max(mx, f[j - 1][i - 1] - s[j - 1] * w);
                    f[j][i] = Math.max(f[j - 1][i], mx + w * s[j]);
                }
            }
            return f[n][k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(22, solution.maximumStrength(new int[]{1, 2, 3, -1, 2}, 3));
            Assert.assertEquals(64, solution.maximumStrength(new int[]{12, -2, -2, -2, -2}, 5));
            Assert.assertEquals(-1, solution.maximumStrength(new int[]{-1, -2, -3}, 1));
        }

    }
}
