package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1139 {
//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 161 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int maxLen = 0;
            int m = grid.length;
            int n = grid[0].length;
            int[][][] dp = new int[m + 1][n + 1][2];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i - 1][j - 1] == 1) {
                        dp[i][j][0] = dp[i][j - 1][0] + 1;
                        dp[i][j][1] = dp[i - 1][j][1] + 1;
                        int len = Math.min(dp[i][j][0], dp[i][j][1]);
                        while (dp[i - len + 1][j][0] < len || dp[i][j - len + 1][1] < len) {
                            len--;
                        }
                        maxLen = Math.max(maxLen, len);
                    }
                }
            }


            return maxLen * maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(9, solution.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
            Assert.assertEquals(1, solution.largest1BorderedSquare(new int[][]{{1, 1, 0, 0}}));
        }

    }
}