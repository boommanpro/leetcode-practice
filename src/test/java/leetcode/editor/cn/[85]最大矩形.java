package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest85 {
//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 569 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] row = new int[m + 1][n + 1];
            int[][] col = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        row[i][j] = row[i][j - 1] + 1;
                        col[i][j] = col[i - 1][j] + 1;
                    }
                }
            }
            int max = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        max = Math.max(calcMaxArea(i, j, row, col), max);
                    }
                }
            }
            return max;
        }

        private int calcMaxArea(int i, int j, int[][] row, int[][] col) {
            int rowLength = row[i][j];
            int colLength = col[i][j];
            int temp = 1;
            while (temp < colLength) {
                rowLength = Math.min(rowLength, row[i - temp ][j]);
                temp++;
            }
            temp = 1;
            while (temp < rowLength) {
                colLength = Math.min(colLength, col[i][j - temp ]);
                temp++;
            }
            return rowLength * colLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals(6, solution.maximalRectangle(new char[][]{
//                    {'1', '0', '1', '0', '0'},
//                    {'1', '0', '1', '1', '1'},
//                    {'1', '1', '1', '1', '1'},
//                    {'1', '0', '0', '1', '0'}
//            }));
            Assert.assertEquals(9, solution.maximalRectangle(new char[][]{
                    {'0', '1', '1', '0', '1'},
                    {'1', '1', '0', '1', '0'},
                    {'0', '1', '1', '1', '0'},
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '1', '1', '1'},
                    {'0', '0', '0', '0', '0'}
            }));
        }
    }
}