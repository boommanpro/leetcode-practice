package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest764 {
//在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 
//grid[xi][yi] == 0 
//
// 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。 
//
// 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
//由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, mines = [[4, 2]]
//输出: 2
//解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: n = 1, mines = [[0, 0]]
//输出: 0
//解释: 没有加号标志，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= mines.length <= 5000 
// 0 <= xi, yi < n 
// 每一对 (xi, yi) 都 不重复 
// 
//
// Related Topics 数组 动态规划 👍 185 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int orderOfLargestPlusSign(int n, int[][] mines) {

            int[][] grid = new int[n][n];
            for (int[] row : grid) {
                Arrays.fill(row, 1);
            }
            for (int[] mine : mines) {
                grid[mine[0]][mine[1]] = 0;
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    max = Math.max(max, find(grid, i, j, n));
                }
            }
            return max;
        }

        private static final int[][] DIRECTIONS = new int[][]{
                {0, -1},
                {0, 1},
                {-1, 0},
                {1, 0},
        };

        private int find(int[][] grid, int i, int j, int n) {
            int k = 1;
            while (true) {
                for (int[] direction : DIRECTIONS) {
                    int x = direction[0] * k + i;
                    int y = direction[1] * k + j;
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) {
                        return k;
                    }
                }
                k++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
            Assert.assertEquals(0, solution.orderOfLargestPlusSign(1, new int[][]{{0, 0}}));
            Assert.assertEquals(1, solution.orderOfLargestPlusSign(2, new int[][]{{0, 0}, {0, 1}, {1, 0}}));
        }

    }
}