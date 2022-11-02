package leetcode.editor.cn;

import org.junit.Test;

class SolutionTest2447 {
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的子数组中元素的最大公因数等于 k 的子数组数目。 
//
// 子数组 是数组中一个连续的非空序列。 
//
// 数组的最大公因数 是能整除数组中所有元素的最大整数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [9,3,1,2,6,3], k = 3
//输出：4
//解释：nums 的子数组中，以 3 作为最大公因数的子数组如下：
//- [9,3,1,2,6,3]
//- [9,3,1,2,6,3]
//- [9,3,1,2,6,3]
//- [9,3,1,2,6,3]
// 
//
// 示例 2： 
//
// 输入：nums = [4], k = 7
//输出：0
//解释：不存在以 7 作为最大公因数的子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i], k <= 10⁹ 
// 
//
// Related Topics 数组 数学 数论 👍 17 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarrayGCD(int[] nums, int k) {
            int n = nums.length;
            int[][] dp = new int[n][n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                dp[i][i] = nums[i];
                if (dp[i][i] == k) {
                    ans++;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = gcd(dp[i][j - 1], nums[j]);
                    if (dp[i][j] == k) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private int gcd(int a, int b) {
            if (a < b) {
                return gcd(b, a);
            }
            return a % b == 0 ? b : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

    }
}