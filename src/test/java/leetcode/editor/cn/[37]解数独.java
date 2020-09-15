package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest37 {
//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 606 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void solveSudoku(char[][] board) {
            dfs(board, 0, 0);
        }

        private boolean dfs(char[][] board, int x, int y) {
            if (x == 9) {
                return true;
            }
            if (y == 9) {
                return dfs(board, x + 1, 0);
            }
            char curr = board[x][y];
            if (curr != '.') {
                return dfs(board, x, y + 1);
            }
            for (char i = '1'; i <= '9'; i++) {
                //放置数字
                board[x][y] = i;
                if (checkNormal(board, x, y) && dfs(board, x, y + 1)) {
                    return true;
                }
                board[x][y] = '.';
            }
            return false;
        }

        private boolean checkNormal(char[][] board, int x, int y) {
            if (!checkRow(board, x)) {
                return false;
            }
            if (!checkCol(board, y)) {
                return false;
            }
            return checkRectangle(board, x / 3, y / 3);
        }

        private boolean checkRectangle(char[][] board, int x, int y) {
            x = x * 3;
            y = y * 3;
            boolean[] visited = new boolean[9];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char curr = board[x + i][y + j];
                    if (curr == '.') {
                        continue;
                    }
                    int v = curr - '1';
                    if (visited[v]) {
                        return false;
                    }
                    visited[v] = true;
                }
            }
            return true;
        }

        private boolean checkCol(char[][] board, int y) {
            boolean[] visited = new boolean[9];
            for (int x = 0; x < 9; x++) {
                char curr = board[x][y];
                if (curr == '.') {
                    continue;
                }
                int v = curr - '1';
                if (visited[v]) {
                    return false;
                }
                visited[v] = true;
            }
            return true;
        }

        private boolean checkRow(char[][] board, int x) {
            boolean[] visited = new boolean[9];
            for (int y = 0; y < 9; y++) {
                char curr = board[x][y];
                if (curr == '.') {
                    continue;
                }
                int v = curr - '1';
                if (visited[v]) {
                    return false;
                }
                visited[v] = true;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            char[][] board = new char[][]{
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
            solution.solveSudoku(board);
            Assert.assertEquals("[[5, 3, 4, 6, 7, 8, 9, 1, 2],[6, 7, 2, 1, 9, 5, 3, 4, 8],[1, 9, 8, 3, 4, 2, 5, 6, 7],[8, 5, 9, 7, 6, 1, 4, 2, 3],[4, 2, 6, 8, 5, 3, 7, 9, 1],[7, 1, 3, 9, 2, 4, 8, 5, 6],[9, 6, 1, 5, 3, 7, 2, 8, 4],[2, 8, 7, 4, 1, 9, 6, 3, 5],[3, 4, 5, 2, 8, 6, 1, 7, 9]]", ArrayUtils.twoDimension2String(board));
        }
    }
}