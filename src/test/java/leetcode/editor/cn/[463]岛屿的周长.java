package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest463 {
//给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。 
//
// 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。 
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。 
//
// 
//
// 示例 : 
//
// 输入:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//
//输出: 16
//
//解释: 它的周长是下面图片中的 16 个黄色的边：
//
//
// 
// Related Topics 哈希表 
// 👍 289 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTION = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        public int islandPerimeter(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int res = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    //分别判断上下左右
                    if (grid[i][j] == 1) {
                        res += countLen(grid, i, j, row, col);
                    }
                }
            }
            //遍历上下左右 不存在的话+1 存在为0
            return res;
        }

        private int countLen(int[][] grid, int i, int j, int row, int col) {
            int ans = 4;
            for (int[] direction : DIRECTION) {
                int nextX = direction[0] + i;
                int nextY = direction[1] + j;
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && grid[nextX][nextY] == 1) {
                    ans--;
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
            Assert.assertEquals(16, solution.islandPerimeter(new int[][]{
                    {0, 1, 0, 0,},
                    {1, 1, 1, 0,},
                    {0, 1, 0, 0,},
                    {1, 1, 0, 0,},
            }));
            Assert.assertEquals(4, solution.islandPerimeter(new int[][]{
                    {0, 1,}
            }));
            Assert.assertEquals(4, solution.islandPerimeter(new int[][]{
                    {1,},
                    {0}
            }));
        }
    }
}