package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest673 {
    //给定一个未排序的整数数组，找到最长递增子序列的个数。
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 动态规划
    public static


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int len = nums.length;
            if (len == 0)
                return 0;
            int dp[] = new int[len];
            int count[] = new int[len];
            Arrays.fill(dp, 1);
            Arrays.fill(count, 1);
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = Math.max(dp[j] + 1, dp[i]);
                            count[i] = count[j];
                        } else if (dp[j] + 1 == dp[i])
                            count[i] += count[j];
                    }
                }
                max = Math.max(max, dp[i]);//找出最长递增子序列的长度是多少
            }
            int ans = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (dp[i] == max) {
                    ans += count[i];
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
//            Assert.assertEquals(2, solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
//            Assert.assertEquals(5, solution.findNumberOfLIS(new int[]{2,2,2,2,2}));

            //12357
            //12457
            //12347

            Assert.assertEquals(3, solution.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
        }
    }
}