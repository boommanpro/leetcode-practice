package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest980 {
//在二维网格 grid 上，有 4 种类型的方格： 
//
// 
// 1 表示起始方格。且只有一个起始方格。 
// 2 表示结束方格，且只有一个结束方格。 
// 0 表示我们可以走过的空方格。 
// -1 表示我们无法跨越的障碍。 
// 
//
// 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。 
//
// 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//输出：2
//解释：我们有以下两条路径：
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) 
//
// 示例 2： 
//
// 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//输出：4
//解释：我们有以下四条路径： 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3) 
//
// 示例 3： 
//
// 输入：[[0,1],[2,0]]
//输出：0
//解释：
//没有一条路能完全穿过每一个空的方格一次。
//请注意，起始和结束方格可以位于网格中的任意位置。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length * grid[0].length <= 20 
// 
// Related Topics 深度优先搜索 回溯算法 
// 👍 80 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int[][] DIRECTION = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };

        private int count;

        public int uniquePathsIII(int[][] grid) {
            count = 0;
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }

            //统计共计需要走多少步
            int m = grid.length;
            int n = grid[0].length;
            int needPass = 0;

            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        needPass++;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //找到入口
                    if (grid[i][j] == 1) {
                        visited[i][j] = true;
                        dfs(grid, i, j, m, n, needPass, visited);
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid, int i, int j, int m, int n, int needPass, boolean[][] visited) {
            if (grid[i][j] == -1) {
                return;
            }
            if (grid[i][j] == 2) {
                if (needPass == -1) {
                    count++;
                }
                return;
            }

            for (int[] direction : DIRECTION) {
                int x = direction[0] + i;
                int y = direction[1] + j;
                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    needPass--;
                    dfs(grid, x, y, m, n, needPass, visited);
                    needPass++;
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
            Assert.assertEquals(2, solution.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
            Assert.assertEquals(4, solution.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
            Assert.assertEquals(0, solution.uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));
        }
    }
}