package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest剑指Offer_42 {
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 113 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] > 0) {
                    nums[i] = nums[i] + nums[i - 1];
                }
                max = Math.max(max, nums[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
            Assert.assertEquals(-1, solution.maxSubArray(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4}));
        }
    }
}