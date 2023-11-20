package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest53 {
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
//
// Related Topics数组 | 分治 | 动态规划
//
// 👍 6455, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int ans = nums[0];
            int prev = ans;
            for (int i = 1; i < n; i++) {
                prev = Math.max(nums[i], prev + nums[i]);
                ans = Math.max(ans, prev);
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
            Assert.assertEquals(6,solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
            Assert.assertEquals(1,solution.maxSubArray(new int[]{1}));
            Assert.assertEquals(23,solution.maxSubArray(new int[]{5,4,-1,7,8}));
        }

    }
}
