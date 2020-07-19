package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest312 {
//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 lef
//t 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划 
// 👍 439 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxCoins(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int[] val = new int[n + 2];
            System.arraycopy(nums, 0, val, 1, n);
            val[0] = val[n + 1] = 1;
            int[][] rec = new int[n + 2][n + 2];
            for (int i = 0; i <= n + 1; i++) {
                Arrays.fill(rec[i], -1);
            }
            return solve(val, rec, 0, n + 1);
        }

        private int solve(int[] val, int[][] rec, int l, int r) {
            if (l >= r - 1) {
                return 0;
            }
            if (rec[l][r] != -1) {
                return rec[l][r];
            }
            for (int i = l + 1; i < r; i++) {
                //现在是在rec中去填充气球
                int sum = val[l] * val[i] * val[r];
                //sum 应该是 填充当前节点左右两侧的气球
                sum += solve(val, rec, l, i) + solve(val, rec, i, r);
                //最终保留最大值
                rec[l][r] = Math.max(rec[l][r], sum);
            }
            return rec[l][r];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(167, solution.maxCoins(new int[]{3, 1, 5, 8}));
        }
    }
}