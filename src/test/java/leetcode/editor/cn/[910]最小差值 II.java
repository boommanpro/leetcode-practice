package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

class SolutionTest910 {
//给你一个整数数组 nums，和一个整数 k 。
//
// 对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。
//
// nums 的 分数 是 nums 中最大元素和最小元素的差值。
//
// 在更改每个下标对应的值之后，返回 nums 的最小 分数 。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1], k = 0
//输出：0
//解释：分数 = max(nums) - min(nums) = 1 - 1 = 0 。
//
//
// 示例 2：
//
//
//输入：nums = [0,10], k = 2
//输出：6
//解释：将数组变为 [2, 8] 。分数 = max(nums) - min(nums) = 8 - 2 = 6 。
//
//
// 示例 3：
//
//
//输入：nums = [1,3,6], k = 3
//输出：3
//解释：将数组变为 [4, 6, 3] 。分数 = max(nums) - min(nums) = 6 - 3 = 3 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 10⁴
// 0 <= k <= 10⁴
//
//
// Related Topics贪心 | 数组 | 数学 | 排序
//
// 👍 252, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestRangeII(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            int ans = nums[n - 1] - nums[0];
            for (int i = 1; i < n; i++) {
                int mx = Math.max(nums[i - 1] + k, nums[n - 1] - k);
                int mn = Math.min(nums[0] + k, nums[i] - k);
                ans = Math.min(ans, mx - mn);
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

    }
}
