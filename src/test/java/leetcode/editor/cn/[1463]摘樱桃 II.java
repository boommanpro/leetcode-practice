package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest1463 {
//给你一个 rows x cols 的矩阵 grid 来表示一块樱桃地。 grid 中每个格子的数字表示你能获得的樱桃数目。
//
// 你有两个机器人帮你收集樱桃，机器人 1 从左上角格子 (0,0) 出发，机器人 2 从右上角格子 (0, cols-1) 出发。
//
// 请你按照如下规则，返回两个机器人能收集的最多樱桃数目：
//
//
// 从格子 (i,j) 出发，机器人可以移动到格子 (i+1, j-1)，(i+1, j) 或者 (i+1, j+1) 。
// 当一个机器人经过某个格子时，它会把该格子内所有的樱桃都摘走，然后这个位置会变成空格子，即没有樱桃的格子。
// 当两个机器人同时到达同一个格子时，它们中只有一个可以摘到樱桃。
// 两个机器人在任意时刻都不能移动到 grid 外面。
// 两个机器人最后都要到达 grid 最底下一行。
//
//
//
//
// 示例 1：
//
//
//
// 输入：grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
//输出：24
//解释：机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
//机器人 1 摘的樱桃数目为 (3 + 2 + 5 + 2) = 12 。
//机器人 2 摘的樱桃数目为 (1 + 5 + 5 + 1) = 12 。
//樱桃总数为： 12 + 12 = 24 。
//
//
// 示例 2：
//
//
//
// 输入：grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1
//,0,2,3,0,0,6]]
//输出：28
//解释：机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
//机器人 1 摘的樱桃数目为 (1 + 9 + 5 + 2) = 17 。
//机器人 2 摘的樱桃数目为 (1 + 3 + 4 + 3) = 11 。
//樱桃总数为： 17 + 11 = 28 。
//
//
// 示例 3：
//
// 输入：grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
//输出：22
//
//
// 示例 4：
//
// 输入：grid = [[1,1],[1,1]]
//输出：4
//
//
//
//
// 提示：
//
//
// rows == grid.length
// cols == grid[i].length
// 2 <= rows, cols <= 70
// 0 <= grid[i][j] <= 100
//
//
// Related Topics数组 | 动态规划 | 矩阵
//
// 👍 106, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTIONS = new int[][]{
                {-1, -1},
                {-1, 0},
                {-1, 1}
        };

        public int cherryPickup(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][][] f = new int[m][n][n];
            for (int k = 0; k < m; k++) {
                for (int i = 0; i < n; i++) {
                    Arrays.fill(f[k][i], -1);
                }
            }
            f[0][0][n - 1] = grid[0][0] + grid[0][n - 1];
            for (int k = 1; k < m; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int[] direction1 : DIRECTIONS) {
                            for (int[] direction2 : DIRECTIONS) {
                                int x = k + direction1[0];
                                int y1 = i + direction1[1];
                                int y2 = j + direction2[1];
                                if (x >= 0 && x < m && y1 >= 0 && y1 < n && y2 >= 0 && y2 < n && f[x][y1][y2] >= 0) {
                                    f[k][i][j] = Math.max(f[k][i][j], f[x][y1][y2] + grid[k][i] + (i == j ? 0 : grid[k][j]));
                                }
                            }
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, f[m - 1][i][j]);
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
            Assert.assertEquals(24, solution.cherryPickup(new int[][]{
                    {3, 1, 1},
                    {2, 5, 1},
                    {1,5,5},
                    {2,1,1}
            }));
            Assert.assertEquals(28,solution.cherryPickup(new int[][]{
                    {1, 0, 0, 0, 0, 0, 1},
                    {2, 0, 0, 0, 0, 3, 0},
                    {2, 0, 9, 0, 0, 0, 0},
                    {0, 3, 0, 5, 4, 0, 0},
                    {1, 0, 2, 3, 0, 0, 6}
            }));
        }

    }
}
