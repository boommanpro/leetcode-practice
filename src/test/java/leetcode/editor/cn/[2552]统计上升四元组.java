package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class SolutionTest2552 {
//给你一个长度为 n 下标从 0 开始的整数数组 nums ，它包含 1 到 n 的所有数字，请你返回上升四元组的数目。
//
// 如果一个四元组 (i, j, k, l) 满足以下条件，我们称它是上升的：
//
//
// 0 <= i < j < k < l < n 且
// nums[i] < nums[k] < nums[j] < nums[l] 。
//
//
//
//
// 示例 1：
//
// 输入：nums = [1,3,2,4,5]
//输出：2
//解释：
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 3 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 4 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//没有其他的四元组，所以我们返回 2 。
//
//
// 示例 2：
//
// 输入：nums = [1,2,3,4]
//输出：0
//解释：只存在一个四元组 i = 0 ，j = 1 ，k = 2 ，l = 3 ，但是 nums[j] < nums[k] ，所以我们返回 0 。
//
//
//
//
// 提示：
//
//
// 4 <= nums.length <= 4000
// 1 <= nums[i] <= nums.length
// nums 中所有数字 互不相同 ，nums 是一个排列。
//
//
// Related Topics树状数组 | 数组 | 动态规划 | 枚举 | 前缀和
//
// 👍 62, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countQuadruplets(int[] nums) {
            long cnt4 = 0;
            int n = nums.length;
            long[] cnt3 = new long[n];
            for (int l = 2; l < n; l++) {
                int cnt2 = 0;
                for (int j = 0; j < l; j++) {
                    if (nums[j] < nums[l]) { // 3 < 4
                        cnt4 += cnt3[j];
                        // 把 j 当作 i，把 l 当作 k，现在 nums[i] < nums[k]，即 1 < 2
                        cnt2++;
                    } else { // 把 l 当作 k，现在 nums[j] > nums[k]，即 3 > 2
                        cnt3[j] += cnt2;
                    }
                }
            }
            return cnt4;
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
        public void testCountQuadruplets_Example1() {
            int[] nums = {1, 3, 2, 4, 5};
            long expected = 2;
            assertEquals(expected, solution.countQuadruplets(nums));
        }

        @Test
        public void testCountQuadruplets_Example2() {
            int[] nums = {1, 2, 3, 4};
            long expected = 0;
            assertEquals(expected, solution.countQuadruplets(nums));
        }
    }
}
