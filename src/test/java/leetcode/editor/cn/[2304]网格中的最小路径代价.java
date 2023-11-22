package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.jar.JarEntry;

class SolutionTest2304 {
//给你一个下标从 0 开始的整数矩阵 grid ，矩阵大小为 m x n ，由从 0 到 m * n - 1 的不同整数组成。你可以在此矩阵中，从一个单元格移
//动到 下一行 的任何其他单元格。如果你位于单元格 (x, y) ，且满足 x < m - 1 ，你可以移动到 (x + 1, 0), (x + 1, 1), .
//.., (x + 1, n - 1) 中的任何一个单元格。注意： 在最后一行中的单元格不能触发移动。
//
// 每次可能的移动都需要付出对应的代价，代价用一个下标从 0 开始的二维数组 moveCost 表示，该数组大小为 (m * n) x n ，其中
//moveCost[i][j] 是从值为 i 的单元格移动到下一行第 j 列单元格的代价。从 grid 最后一行的单元格移动的代价可以忽略。
//
// grid 一条路径的代价是：所有路径经过的单元格的 值之和 加上 所有移动的 代价之和 。从 第一行 任意单元格出发，返回到达 最后一行 任意单元格的最小
//路径代价。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[1
//4,3]]
//输出：17
//解释：最小代价的路径是 5 -> 0 -> 1 。
//- 路径途经单元格值之和 5 + 0 + 1 = 6 。
//- 从 5 移动到 0 的代价为 3 。
//- 从 0 移动到 1 的代价为 8 。
//路径总代价为 6 + 3 + 8 = 17 。
//
//
// 示例 2：
//
//
//输入：grid = [[5,1,2],[4,0,3]], moveCost = [[12,10,15],[20,23,8],[21,7,1],[8,1,13
//],[9,10,25],[5,3,2]]
//输出：6
//解释：
//最小代价的路径是 2 -> 3 。
//- 路径途经单元格值之和 2 + 3 = 5 。
//- 从 2 移动到 3 的代价为 1 。
//路径总代价为 5 + 1 = 6 。
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 2 <= m, n <= 50
// grid 由从 0 到 m * n - 1 的不同整数组成
// moveCost.length == m * n
// moveCost[i].length == n
// 1 <= moveCost[i][j] <= 100
//
//
// Related Topics数组 | 动态规划 | 矩阵
//
// 👍 36, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
            int m = grid.length;
            int n = grid[0].length;
            int[] ans = new int[n];
            System.arraycopy(grid[0], 0, ans, 0, n);
            for (int i = 1; i < m; i++) {
                int[] temp = new int[n];
                Arrays.fill(temp, Integer.MAX_VALUE);
                for (int f = 0; f < n; f++) {
                    for (int t = 0; t < n; t++) {
                        int v = grid[i - 1][f];
                        int cost = moveCost[v][t];
                        temp[t] = Math.min(temp[t], cost + ans[f] + grid[i][t]);
                    }
                }
                ans = temp;
            }
            return Arrays.stream(ans).min().getAsInt();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(17, solution.minPathCost(new int[][]{
                    {5, 3},
                    {4, 0},
                    {2, 1}
            }, new int[][]{
                    {9, 8},
                    {1, 5},
                    {10, 12},
                    {18, 6},
                    {2, 4},
                    {14, 3},
            }));
        }

    }
}
