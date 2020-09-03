package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest416 {
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 378 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length < 2) {
                return false;
            }
            int n = nums.length;
            int max = nums[0];
            int sum = 0;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }
            if ((sum & 1) == 1) {
                return false;
            }
            int target = sum / 2;
            if (max > target) {
                return false;
            }
            // 动态规划计算
            // 创建二维状态数组，行：前 i个物品，列：容量（包括 0）
            boolean[][] dp = new boolean[n][target + 1];
            dp[0][nums[0]] = true;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= target; j++) {
                    dp[i][j] = dp[i - 1][j];

                    if (nums[i] == j) {
                        dp[i][nums[i]] = true;
                        continue;
                    }
                    if (nums[i] < j) {
                        dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                    }
                }
            }

            return dp[n - 1][target];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.canPartition(new int[]{1, 5, 11, 5}));
            Assert.assertFalse(solution.canPartition(new int[]{1, 2, 3, 5}));
            Assert.assertTrue(solution.canPartition(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 97, 95}));

        }
    }
}