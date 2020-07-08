package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest152 {
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 648 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int max = nums[0];
            int min = nums[0];
            int ans = nums[0];
            for (int i = 1; i < n; i++) {
                int temp = max;
                max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
                min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
                if (max > ans) {
                    ans = max;
                }
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
            Assert.assertEquals(6, solution.maxProduct(new int[]{2, 3, -2, 4}));
            Assert.assertEquals(0, solution.maxProduct(new int[]{-2, 0, -1}));
            Assert.assertEquals(48, solution.maxProduct(new int[]{2, 3, -2, 4, -1}));
        }
    }
}