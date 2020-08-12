package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest79 {
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 510 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTION = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        public boolean exist(char[][] board, String word) {
            if (word == null || word.isEmpty()) {
                return true;
            }
            if (board == null || board.length == 0 || board[0].length == 0) {
                return false;
            }
            char[] words = word.toCharArray();
            char start = words[0];
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //找到入口
                    if (board[i][j] == start) {
                        //dfs搜索
                        visited[i][j] = true;
                        if (dfs(board, i, j, words, 1, words.length, visited, m, n)) {
                            return true;
                        }
                        visited[i][j] = false;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, char[] words, int curr, int len, boolean[][] visited, int m, int n) {
            if (len == curr) {
                return true;
            }
            for (int[] direction : DIRECTION) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && words[curr] == board[x][y]) {
                    visited[x][y] = true;
                    if (dfs(board, x, y, words, curr + 1, len, visited, m, n)) {
                        return true;
                    }
                    visited[x][y] = false;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            char[][] board0 = new char[][]{
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            };
            Assert.assertTrue(solution.exist(board0, "ABCCED"));
            Assert.assertTrue(solution.exist(board0, "SEE"));
            Assert.assertFalse(solution.exist(board0, "ABCB"));
        }
    }
}