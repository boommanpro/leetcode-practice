package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题17_16 {
//一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩
//师找到最优的预约集合（总预约时间最长），返回总的分钟数。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例 1： 
//
// 输入： [1,2,3,1]
//输出： 4
//解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
// 
//
// 示例 2： 
//
// 输入： [2,7,9,3,1]
//输出： 12
//解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
// 
//
// 示例 3： 
//
// 输入： [2,1,4,5,3,1,1,3]
//输出： 12
//解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
// 
// Related Topics 动态规划

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int massage(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            int[] dp = new int[n];
            System.arraycopy(nums, 0, dp, 0, nums.length);
            for (int i = 2; i < n; i++) {
                int before2 = dp[i - 2];
                int before3 = i >= 3 ? dp[i - 3] : 0;
                dp[i] = dp[i] + Math.max(before2, before3);
            }
            return Math.max(dp[n - 1], dp[n - 2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals(4, solution.massage(new int[]{1, 2, 3, 1}));
            Assert.assertEquals(4, solution.massage(new int[]{2, 1, 1, 2}));
            Assert.assertEquals(2, solution.massage(new int[]{1, 2,}));
            Assert.assertEquals(4, solution.massage(new int[]{1, 2, 3}));
            Assert.assertEquals(12, solution.massage(new int[]{2, 7, 9, 3, 1}));
            Assert.assertEquals(12, solution.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
        }
    }
}