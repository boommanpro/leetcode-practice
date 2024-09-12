package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class SolutionTest2576 {
//给你一个下标从 0 开始的整数数组 nums 。
//
// 一开始，所有下标都没有被标记。你可以执行以下操作任意次：
//
//
// 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
//
//
// 请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,5,2,4]
//输出：2
//解释：第一次操作中，选择 i = 2 和 j = 1 ，操作可以执行的原因是 2 * nums[2] <= nums[1] ，标记下标 2 和 1 。
//没有其他更多可执行的操作，所以答案为 2 。
//
//
// 示例 2：
//
//
//输入：nums = [9,2,5,4]
//输出：4
//解释：第一次操作中，选择 i = 3 和 j = 0 ，操作可以执行的原因是 2 * nums[3] <= nums[0] ，标记下标 3 和 0 。
//第二次操作中，选择 i = 1 和 j = 2 ，操作可以执行的原因是 2 * nums[1] <= nums[2] ，标记下标 1 和 2 。
//没有其他更多可执行的操作，所以答案为 4 。
//
//
// 示例 3：
//
//
//输入：nums = [7,6,8]
//输出：0
//解释：没有任何可以执行的操作，所以答案为 0 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁹
//
//
// Related Topics贪心 | 数组 | 双指针 | 二分查找 | 排序
//
// 👍 108, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            Arrays.sort(nums);
            int len = (nums.length + 1) / 2;
            int n = nums.length;
            int ans = 0;
            int[] dp = new int[n];
            for (int i = 0; i < len; i++) {
                int p = find(nums, len, 2 * nums[i]);
                if (p == -1) {
                    break;
                }
                dp[p]++;
            }
            for (int p = nums.length - 1; p >= len; p--) {
                ans += Math.min(dp[p], nums.length - p - ans);
            }
            return ans * 2;
        }

        private int find(int[] nums, int start, int v) {
            int l = start;
            int r = nums.length - 1;
            if (nums[r] < v) {
                return -1;
            }
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[mid] < v) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
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
        public void testMaxNumOfMarkedIndicesExample1() {
            int[] nums = {3, 5, 2, 4};
            int expected = 2;
            assertEquals(expected, solution.maxNumOfMarkedIndices(nums));
        }

        @Test
        public void testMaxNumOfMarkedIndicesExample2() {
            int[] nums = {9, 2, 5, 4};
            int expected = 4;
            assertEquals(expected, solution.maxNumOfMarkedIndices(nums));
        }

        @Test
        public void testMaxNumOfMarkedIndicesExample3() {
            int[] nums = {7, 6, 8};
            int expected = 0;
            assertEquals(expected, solution.maxNumOfMarkedIndices(nums));
        }

        @Test
        public void testMaxNumOfMarkedIndicesExample4() {
            int[] nums = {1, 78, 27, 48, 14, 86, 79, 68, 77, 20, 57, 21, 18, 67, 5, 51, 70, 85, 47, 56, 22, 79, 41, 8, 39, 81, 59, 74, 14, 45, 49, 15, 10, 28, 16, 77, 22, 65, 8, 36, 79, 94, 44, 80, 72, 8, 96, 78, 39, 92, 69, 55, 9, 44, 26, 76, 40, 77, 16, 69, 40, 64, 12, 48, 66, 7, 59, 10};
            int expected = 64;
            assertEquals(expected, solution.maxNumOfMarkedIndices(nums));
        }
    }
}
