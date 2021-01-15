package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest368 {
//给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。 
//
//
// 如果有多个目标子集，返回其中任何一个均可。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2] (当然, [1,3] 也正确)
// 
//
// 示例 2: 
//
// 输入: [1,2,4,8]
//输出: [1,2,4,8]
// 
// Related Topics 数学 动态规划 
// 👍 188 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int[][] dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                dp[i][0] = -1;
                dp[i][1] = 1;
            }
            int[] status = new int[]{0, 1};
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] % nums[i] == 0) {
                        if (dp[i][1] + 1 > dp[j][1]) {
                            dp[j][1] = dp[i][1] + 1;
                            dp[j][0] = i;
                            if (dp[j][1] > status[1]) {
                                status[0] = j;
                                status[1] = dp[j][1];
                            }
                        }

                    }
                }
            }
            List<Integer> ans = new ArrayList<>();
            int i = status[0];
            while (i >= 0) {
                ans.add(nums[i]);
                i = dp[i][0];
            }
            Collections.reverse(ans);
            return ans;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1, 2]", solution.largestDivisibleSubset(new int[]{1, 2, 3}).toString());
            Assert.assertEquals("[1, 2, 4, 8]", solution.largestDivisibleSubset(new int[]{1, 2, 3, 4, 6, 8}).toString());
            Assert.assertEquals("[1]", solution.largestDivisibleSubset(new int[]{1}).toString());
            Assert.assertEquals("[4, 8, 240]", solution.largestDivisibleSubset(new int[]{4, 8, 10, 240}).toString());
        }
    }
}