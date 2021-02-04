package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest643 {
//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 140 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            if (k > nums.length) {
                return -1;
            }
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            double ans = sum / (double) k;
            for (int i = 1; i < nums.length - k + 1; i++) {
                sum -= nums[i - 1];
                sum += nums[i + k - 1];
                ans = Math.max(ans, sum / (double) k);
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
            Assert.assertEquals(12.75, solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 0.0001);
        }
    }
}