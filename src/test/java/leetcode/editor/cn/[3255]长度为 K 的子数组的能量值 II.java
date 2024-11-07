package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

class SolutionTest3255 {
//给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
//
// 一个数组的 能量值 定义为：
//
//
// 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
// 否则为 -1 。
//
//
// 你需要求出 nums 中所有长度为 k 的 子数组 的能量值。
//
// 请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能
//量值。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,3,4,3,2,5], k = 3
//
//
// 输出：[3,4,-1,-1,-1]
//
// 解释：
//
// nums 中总共有 5 个长度为 3 的子数组：
//
//
// [1, 2, 3] 中最大元素为 3 。
// [2, 3, 4] 中最大元素为 4 。
// [3, 4, 3] 中元素 不是 连续的。
// [4, 3, 2] 中元素 不是 上升的。
// [3, 2, 5] 中元素 不是 连续的。
//
//
// 示例 2：
//
//
// 输入：nums = [2,2,2,2,2], k = 4
//
//
// 输出：[-1,-1]
//
// 示例 3：
//
//
// 输入：nums = [3,2,3,2,3,2], k = 2
//
//
// 输出：[-1,3,-1,3,-1]
//
//
//
// 提示：
//
//
// 1 <= n == nums.length <= 10⁵
// 1 <= nums[i] <= 10⁶
// 1 <= k <= n
//
//
// Related Topics数组 | 滑动窗口
//
// 👍 24, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] resultsArray(int[] nums, int k) {
            if (k == 1) {
                return nums;
            }
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            Arrays.fill(ans, -1);
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                cnt = (nums[i] == nums[i - 1] + 1) ? cnt + 1 : 1;
                if (cnt >= k) {
                    ans[i - k + 1] = nums[i];
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
            int[] nums1 = {1, 2, 3, 4, 3, 2, 5};
            int k1 = 3;
            int[] expected1 = {3, 4, -1, -1, -1};
            assertArrayEquals(expected1, solution.resultsArray(nums1, k1));

            int[] nums2 = {2, 2, 2, 2, 2};
            int k2 = 4;
            int[] expected2 = {-1, -1};
            assertArrayEquals(expected2, solution.resultsArray(nums2, k2));

            int[] nums3 = {3, 2, 3, 2, 3, 2};
            int k3 = 2;
            int[] expected3 = {-1, 3, -1, 3, -1};
            assertArrayEquals(expected3, solution.resultsArray(nums3, k3));

            int[] nums4 = {1};
            int k4 = 1;
            int[] expected4 = {1};
            assertArrayEquals(expected4, solution.resultsArray(nums4, k4));
        }

    }
}
