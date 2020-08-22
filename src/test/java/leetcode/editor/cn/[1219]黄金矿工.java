package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1219 {
//你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄
//金数量；如果该单元格是空的，那么就是 0。 
//
// 为了使收益最大化，矿工需要按以下规则来开采黄金： 
//
// 
// 每当矿工进入一个单元，就会收集该单元格中的所有黄金。 
// 矿工每次可以从当前位置向上下左右四个方向走。 
// 每个单元格只能被开采（进入）一次。 
// 不得开采（进入）黄金数目为 0 的单元格。 
// 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。 
// 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
//输出：24
//解释：
//[[0,6,0],
// [5,8,7],
// [0,9,0]]
//一种收集最多黄金的路线是：9 -> 8 -> 7。
// 
//
// 示例 2： 
//
// 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//输出：28
//解释：
//[[1,0,7],
// [2,0,6],
// [3,4,5],
// [0,3,0],
// [9,0,20]]
//一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 15 
// 0 <= grid[i][j] <= 100 
// 最多 25 个单元格中有黄金。 
// 
// Related Topics 回溯算法 
// 👍 48 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTION = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        int max = 0;

        public int getMaximumGold(int[][] grid) {
            max = 0;
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) {
                        visited[i][j] = true;
                        dfs(i, j, grid, visited, grid[i][j], m, n);
                        visited[i][j] = false;
                    }
                }
            }
            return max;
        }

        private void dfs(int i, int j, int[][] grid, boolean[][] visited, int sum, int m, int n) {
            if (sum > max) {
                max = sum;
            }
            for (int[] direction : DIRECTION) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != 0 && !visited[x][y]) {
                    visited[x][y] = true;
                    dfs(x, y, grid, visited, sum + grid[x][y], m, n);
                    visited[x][y] = false;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(24, solution.getMaximumGold(new int[][]{
                    {0, 6, 0},
                    {5, 8, 7},
                    {0, 9, 0}
            }));

            Assert.assertEquals(28, solution.getMaximumGold(new int[][]{
                    {1, 0, 7},
                    {2, 0, 6},
                    {3, 4, 5},
                    {0, 3, 0},
                    {9, 0, 20}
            }));
        }
    }
}