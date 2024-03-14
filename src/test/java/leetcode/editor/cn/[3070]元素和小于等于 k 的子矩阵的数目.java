package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest3070 {
//给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。
//
// 返回包含 grid 左上角元素、元素和小于或等于 k 的 子矩阵的数目。
//
//
//
// 示例 1：
//
//
//输入：grid = [[7,6,3],[6,6,1]], k = 18
//输出：4
//解释：如上图所示，只有 4 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 18 。
//
// 示例 2：
//
//
//输入：grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
//输出：6
//解释：如上图所示，只有 6 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 20 。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= n, m <= 1000
// 0 <= grid[i][j] <= 1000
// 1 <= k <= 10⁹
//
//
// Related Topics数组 | 矩阵 | 前缀和
//
// 👍 4, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubmatrices(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            long sum = 0;
            int ans = 0;
            int[][] matrix = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i + 1][j + 1] = grid[i][j];
                }
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
                    if (matrix[i][j] <= k) {
                        ans++;
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
            Assert.assertEquals(4,solution.countSubmatrices(new int[][]{
                    {7,6,3},
                    {6,6,1},
            },18));
            Assert.assertEquals(6, solution.countSubmatrices(new int[][]{
                    {7, 2, 9},
                    {1, 5, 0},
                    {2, 6, 6}
            }, 20));
        }

    }
}
