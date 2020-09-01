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
            int[][] f = new int[m][n];
            int maxArea = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        if (j == 0) {
                            f[i][j] = 1;
                        } else {
                            f[i][j] = f[i][j - 1] + 1;
                        }

                        //计算面积
                        int width = f[i][j];
                        for (int k = i; k >= 0; k--) {
                            width = Math.min(width, f[k][j]);
                            maxArea = Math.max(maxArea, (i - k + 1) * width);
                        }
                    }
                }
            }
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.maximalRectangle(new char[][]{
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            }));
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