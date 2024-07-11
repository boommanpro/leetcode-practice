package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest2972 {
//给你一个下标从 0 开始的 正 整数数组 nums 。
//
// 如果 nums 的一个子数组满足：移除这个子数组后剩余元素 严格递增 ，那么我们称这个子数组为 移除递增 子数组。比方说，[5, 3, 4, 6, 7]
//中的 [3, 4] 是一个移除递增子数组，因为移除该子数组后，[5, 3, 4, 6, 7] 变为 [5, 6, 7] ，是严格递增的。
//
// 请你返回 nums 中 移除递增 子数组的总数目。
//
// 注意 ，剩余元素为空的数组也视为是递增的。
//
// 子数组 指的是一个数组中一段连续的元素序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,4]
//输出：10
//解释：10 个移除递增子数组分别为：[1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] 和
//[1,2,3,4]。移除任意一个子数组后，剩余元素都是递增的。注意，空数组不是移除递增子数组。
//
//
// 示例 2：
//
//
//输入：nums = [6,5,7,8]
//输出：7
//解释：7 个移除递增子数组分别为：[5], [6], [5,7], [6,5], [5,7,8], [6,5,7] 和 [6,5,7,8] 。
//nums 中只有这 7 个移除递增子数组。
//
//
// 示例 3：
//
//
//输入：nums = [8,7,6,6]
//输出：3
//解释：3 个移除递增子数组分别为：[8,7,6], [7,6,6] 和 [8,7,6,6] 。注意 [8,7] 不是移除递增子数组因为移除 [8,7] 后
//nums 变为 [6,6] ，它不是严格递增的。
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
// Related Topics数组 | 双指针 | 二分查找
//
// 👍 40, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long incremovableSubarrayCount(int[] nums) {
            long ans = 0;
            int len = nums.length;
            int l = 0;
            while (l < len - 1) {
                if (nums[l] >= nums[l + 1]) {
                    break;
                }
                l++;
            }
            if (l == len - 1) {
                return 1L * len * (len + 1) / 2;
            }

            ans += l + 2;
            for (int r = len - 1; r > 0; r--) {
                if (r < len - 1 && nums[r] >= nums[r + 1]) {
                    break;
                }

                while (l >= 0 && nums[l] >= nums[r]) {
                    l--;
                }
                ans += l + 2;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            // 测试用例1: 全部递增的情况
            assertEquals(10L, solution.incremovableSubarrayCount(new int[]{1, 2, 3, 4}));

            // 测试用例2: 包含下降的情况
            assertEquals(7L, solution.incremovableSubarrayCount(new int[]{6, 5, 7, 8}));

            // 测试用例3: 包含相等元素的情况
            assertEquals(3L, solution.incremovableSubarrayCount(new int[]{8, 7, 6, 6}));

        }

    }
}
