package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest300 {
    //给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划
    public static


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int maxLength = 1;
            int length = nums.length;
            int[] dp = new int[nums.length];
            for (int i = 0; i < length; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j] && dp[i] <= j + 1) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            for (int i = 0; i < length; i++) {
                maxLength = Math.max(dp[i], maxLength);
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals(4, solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//            Assert.assertEquals(0, solution.lengthOfLIS(new int[]{}));
            Assert.assertEquals(6, solution.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        }
    }
}