package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class SolutionTest2104 {
//给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。 
//
// 返回 nums 中 所有 子数组范围的 和 。 
//
// 子数组是数组中一个连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：4
//解释：nums 的 6 个子数组如下所示：
//[1]，范围 = 最大 - 最小 = 1 - 1 = 0 
//[2]，范围 = 2 - 2 = 0
//[3]，范围 = 3 - 3 = 0
//[1,2]，范围 = 2 - 1 = 1
//[2,3]，范围 = 3 - 2 = 1
//[1,2,3]，范围 = 3 - 1 = 2
//所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,3]
//输出：4
//解释：nums 的 6 个子数组如下所示：
//[1]，范围 = 最大 - 最小 = 1 - 1 = 0
//[3]，范围 = 3 - 3 = 0
//[3]，范围 = 3 - 3 = 0
//[1,3]，范围 = 3 - 1 = 2
//[3,3]，范围 = 3 - 3 = 0
//[1,3,3]，范围 = 3 - 1 = 2
//所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
// 
//
// 示例 3： 
//
// 
//输入：nums = [4,-2,-3,4,1]
//输出：59
//解释：nums 中所有子数组范围的和是 59
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？ 
// Related Topics 栈 数组 单调栈 👍 194 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public long subArrayRanges(int[] nums) {
            int n = nums.length;
            int[] max = getRangeCount(nums, true);
            int[] min = getRangeCount(nums, false);
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += (long) (max[i] - min[i]) * nums[i];
            }
            return ans;
        }

        private int[] getRangeCount(int[] nums, boolean max) {
            int n = nums.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && (max ? nums[i] >= nums[stack.peek()] : nums[i] <= nums[stack.peek()])) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && (max ? nums[i] > nums[stack.peek()] : nums[i] < nums[stack.peek()])) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = (i - left[i]) * (right[i] - i);
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
            Assert.assertEquals(4, solution.subArrayRanges(new int[]{1, 2, 3}));
            Assert.assertEquals(4, solution.subArrayRanges(new int[]{1, 3, 3}));
            Assert.assertEquals(59, solution.subArrayRanges(new int[]{4, -2, -3, 4, 1}));
            Assert.assertEquals(21, solution.subArrayRanges(new int[]{3, 2, 1, 1, 2, 3}));
            Assert.assertEquals(6, solution.subArrayRanges(new int[]{3, 1, 3}));
        }

    }
}