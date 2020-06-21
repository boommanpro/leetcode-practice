package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest494 {
//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int target;

        int count;

        public int findTargetSumWays(int[] nums, int S) {
            count = 0;
            target = S;
            calcTargetSum(nums, 0, 0);
            return count;
        }

        private void calcTargetSum(int[] nums, int i, int sum) {
            if (i == nums.length) {
                if (sum == target) {
                    count++;
                }
                return;
            }
            calcTargetSum(nums, i + 1, sum - nums[i]);
            calcTargetSum(nums, i + 1, sum + nums[i]);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        }
    }
}