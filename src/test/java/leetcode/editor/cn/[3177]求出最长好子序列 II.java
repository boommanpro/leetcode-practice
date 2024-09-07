package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

class SolutionTest3177 {
//给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在范围下标范围 [0, seq.length - 2] 中存在 不超过
//k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
//
// 请你返回 nums 中 好 子序列 的最长长度
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
// 1 <= nums.length <= 5 * 10³
// 1 <= nums[i] <= 10⁹
// 0 <= k <= min(50, nums.length)
//
//
// Related Topics数组 | 哈希表 | 动态规划
//
// 👍 25, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(int[] nums, int k) {
            int n = nums.length;
            int[] max = new int[k + 1];
            Map<Integer, int[]> map = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int v = nums[i];
                int[] prev = map.computeIfAbsent(v, x -> new int[k + 1]);
                int[] temp = Arrays.copyOf(max, k + 1);
                for (int l = 0; l <= k; l++) {
                    prev[l] = prev[l] + 1;
                    if (l > 0) {
                        prev[l] = Math.max(prev[l], max[l - 1] + 1);
                    }
                    temp[l] = Math.max(temp[l], prev[l]);
                    ans = Math.max(ans, temp[l]);

                }
                max = temp;
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
            int[] nums = {1};
            int k = 0;
            int expected = 1;
            assertEquals(expected, solution.maximumLength(nums, k));
        }
    }
}
