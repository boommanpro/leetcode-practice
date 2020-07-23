package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest64 {
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 571 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] f = new int[m + 1][n + 1];
            for (int i = 2; i <= m; i++) {
                f[i][0] = grid[i - 2][0] + f[i - 1][0];
            }
            for (int i = 2; i <= n; i++) {
                f[0][i] = grid[0][i - 2] + f[0][i - 1];
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
            return f[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.minPathSum(new int[][]{
                    {1, 3, 1},
                    {1, 5, 1},
                    {4, 2, 1},
            }));

            Assert.assertEquals(5, solution.minPathSum(new int[][]{
                    {1, 3, 1},
            }));

            Assert.assertEquals(6, solution.minPathSum(new int[][]{
                    {1},
                    {1},
                    {4},
            }));
        }
    }
}