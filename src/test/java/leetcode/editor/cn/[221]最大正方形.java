package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest221 {
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 634 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximalSquare(char[][] matrix) {
            int ans = 0;
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return ans;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] dp = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = j > 0 ? dp[i][j - 1] + 1 : 1;
                        int width = dp[i][j];
                        for (int k = i; k >= 0; k--) {
                            width = Math.min(width, dp[k][j]);
                            if (width == i - k + 1) {
                                ans = Math.max(ans, width * (i - k + 1));
                            }
                        }
                    }
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
            Assert.assertEquals(4, solution.maximalSquare(new char[][]{
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            }));
            Assert.assertEquals(1, solution.maximalSquare(new char[][]{
                    {'0', '1'},
                    {'1', '0'},
            }));
            Assert.assertEquals(0, solution.maximalSquare(new char[][]{
                    {'0'},
            }));
        }
    }
}