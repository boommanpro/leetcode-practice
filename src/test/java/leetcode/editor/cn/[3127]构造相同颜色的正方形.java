package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class SolutionTest3127 {
//给你一个二维 3 x 3 的矩阵 grid ，每个格子都是一个字符，要么是 'B' ，要么是 'W' 。字符 'W' 表示白色，字符 'B' 表示黑色。
//
// 你的任务是改变 至多一个 格子的颜色，使得矩阵中存在一个 2 x 2 颜色完全相同的正方形。
//
//
// 如果可以得到一个相同颜色的 2 x 2 正方形，那么返回 true ，否则返回 false 。
//
//
//
//
// 示例 1：
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
// 输入：grid = [["B","W","B"],["B","W","W"],["B","W","B"]]
//
//
// 输出：true
//
// 解释：
//
// 修改 grid[0][2] 的颜色，可以满足要求。
//
// 示例 2：
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
// 输入：grid = [["B","W","B"],["W","B","W"],["B","W","B"]]
//
//
// 输出：false
//
// 解释：
//
// 只改变一个格子颜色无法满足要求。
//
// 示例 3：
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
// 输入：grid = [["B","W","B"],["B","W","W"],["B","W","W"]]
//
//
// 输出：true
//
// 解释：
//
// grid 已经包含一个 2 x 2 颜色相同的正方形了。
//
//
//
//
// 提示：
//
//
// grid.length == 3
// grid[i].length == 3
// grid[i][j] 要么是 'W' ，要么是 'B' 。
//
//
// Related Topics数组 | 枚举 | 矩阵
//
// 👍 5, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][][] DIRECTIONS = new int[][][]{
                {{-1, 0}, {0, -1}, {-1, -1}}, {{1, 0}, {0, -1}, {1, -1}}, {{1, 0}, {0, 1}, {1, 1}}, {{-1, 0}, {0, 1}, {-1, 1}},};

        public boolean canMakeSquare(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (count(grid, i, j, m, n)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean count(char[][] grid, int i, int j, int m, int n) {
            for (int[][] directions : DIRECTIONS) {
                int countB = 1;
                int countW = 1;
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (grid[x][y] == 'W') {
                        countW++;
                    }
                    if (grid[x][y] == 'B') {
                        countB++;
                    }
                }
                if (countW == 4 || countB == 4) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testCanMakeSquare1() {
            char[][] grid = {{'B', 'W', 'B'}, {'B', 'W', 'W'}, {'B', 'W', 'B'}};
            assertTrue(solution.canMakeSquare(grid));
        }

        @Test
        public void testCanMakeSquare2() {
            char[][] grid = {{'B', 'W', 'B'}, {'W', 'B', 'W'}, {'B', 'W', 'B'}};
            assertFalse(solution.canMakeSquare(grid));
        }

        @Test
        public void testCanMakeSquare3() {
            char[][] grid = {{'B', 'W', 'B'}, {'B', 'W', 'W'}, {'B', 'W', 'W'}};
            assertTrue(solution.canMakeSquare(grid));
        }

        @Test
        public void testCanMakeSquare7() {
            char[][] grid = {{'B', 'B', 'B'}, {'B', 'B', 'B'}, {'B', 'B', 'B'}};
            assertTrue(solution.canMakeSquare(grid));
        }

    }
}
