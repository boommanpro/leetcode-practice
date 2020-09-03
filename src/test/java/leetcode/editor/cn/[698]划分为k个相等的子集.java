package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest698 {
//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 示例 1： 
//
// 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 
// Related Topics 递归 动态规划 
// 👍 225 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int n = nums.length;
            int sum = 0;
            int max = nums[0];
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            return dfs(nums, k, target, 0, 0, n, new boolean[n]);
        }

        private boolean dfs(int[] nums, int k, int target, int curr, int start, int n, boolean[] used) {
            if (k == 0) {
                return true;
            }
            if (curr == target) {
                return dfs(nums, k - 1, target, 0, 0, n, used);
            }
            for (int i = start; i < n; i++) {
                if (!used[i] && curr + nums[i] <= target) {
                    used[i] = true;
                    if (dfs(nums, k, target, curr + nums[i], i + 1, n, used)) {
                        return true;
                    }
                    used[i] = false;
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
            Assert.assertTrue(solution.canPartitionKSubsets(new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6}, 3));
        }
    }
}