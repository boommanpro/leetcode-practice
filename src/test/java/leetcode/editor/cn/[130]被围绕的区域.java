package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest130 {
//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 285 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final char TAG = 'A';
        private static final char O = 'O';
        private static final char X = 'X';

        private static final int[][] DIRECTION = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
        };

        public void solve(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                dfs(board, i, 0, m, n);
                dfs(board, i, n - 1, m, n);
            }
            for (int i = 0; i < n; i++) {
                dfs(board, 0, i, m, n);
                dfs(board, m-1, i, m, n);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == TAG) {
                        board[i][j] = O;
                    } else if (board[i][j] == O) {
                        board[i][j] = X;
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j, int m, int n) {
            if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != O) {
                return;
            }
            board[i][j] = TAG;
            for (int[] direction : DIRECTION) {
                int x = direction[0] + i;
                int y = direction[1] + j;
                dfs(board, x, y, m, n);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            char[][] board0 = new char[][]{
                    {'X', 'X', 'X', 'X'},
                    {'X', 'O', 'O', 'X'},
                    {'X', 'X', 'O', 'X'},
                    {'X', 'O', 'X', 'X'},
            };
            solution.solve(board0);
            Assert.assertEquals("[[X, X, X, X],[X, X, X, X],[X, X, X, X],[X, O, X, X]]", ArrayUtils.twoDimension2String(board0));
        }
    }
}