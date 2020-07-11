package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest123 {
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划 
// 👍 437 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) {
                return 0;
            }
            int n = prices.length;
            int maxOperation = 2;
            //0是不持有股票 1 是持有股票
            int[][][] f = new int[n][maxOperation][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < maxOperation; j++) {
                    f[i][j][1] = -prices[i];
                }
            }
            for (int i = 1; i < n; i++) {
                f[i][0][0] = Math.max(f[i - 1][0][0], f[i - 1][0][1] + prices[i]);
                f[i][0][1] = Math.max(f[i - 1][0][1], -prices[i]);
                for (int j = 1; j < maxOperation; j++) {
                    f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + prices[i]);
                    f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - prices[i]);
                }
            }
            return f[n - 1][maxOperation - 1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.maxProfit(new int[]{0, 3, 1, 4}));
            Assert.assertEquals(6, solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
            Assert.assertEquals(4, solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
            Assert.assertEquals(0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        }
    }
}