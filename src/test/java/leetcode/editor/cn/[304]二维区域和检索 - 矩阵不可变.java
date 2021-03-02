package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest304 {
//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 
//
// 示例： 
//
// 
//给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。 
// 
// Related Topics 动态规划 
// 👍 165 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {

        private final int[][] sumRange;

        private final int m;

        private final int n;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                m = 0;
                n = 0;
                sumRange = new int[1][1];
                return;
            }
             m = matrix.length;
             n = matrix[0].length;
            sumRange = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sumRange[i][j] = matrix[i - 1][j - 1] - sumRange[i - 1][j - 1] + sumRange[i - 1][j] + sumRange[i][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sumRange[row2 + 1][col2 + 1] - sumRange[row1 ][col2+1] - sumRange[row2+1][col1] + sumRange[row1][col1];
        }
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            NumMatrix matrix = new NumMatrix(new int[][]{
                    {3, 0, 1, 4, 2},
                    {5, 6, 3, 2, 1},
                    {1, 2, 0, 1, 5},
                    {4, 1, 0, 1, 7},
                    {1, 0, 3, 0, 5}
            });
            Assert.assertEquals(0, matrix.sumRegion(2, 2, 2, 2));
            Assert.assertEquals(6, matrix.sumRegion(1, 1, 1, 1));
            Assert.assertEquals(8, matrix.sumRegion(2, 1, 4, 3));
            Assert.assertEquals(11, matrix.sumRegion(1, 1, 2, 2));
            Assert.assertEquals(12, matrix.sumRegion(1, 2, 2, 4));
            Assert.assertEquals(21, matrix.sumRegion(0, 0, 2, 2));

            NumMatrix matrix1 = new NumMatrix(new int[][]{
            });

        }
    }
}