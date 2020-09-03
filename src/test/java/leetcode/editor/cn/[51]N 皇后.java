package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SolutionTest51 {
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 549 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<String>> result;

        public List<List<String>> solveNQueens(int n) {
            result = new ArrayList<>();
            boolean[][] board = new boolean[n][n];
            dfs(board, 0, n);
            return result;
        }

        private void dfs(boolean[][] board, int start, int n) {
            if (start == n) {
                result.add(board2String(board));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (checkNormal(board, start, i)) {
                    fill(board, start, i);
                    dfs(board, start + 1, n);
                }
            }
        }

        private void fill(boolean[][] board, int row, int col) {
            boolean[] rows = board[row];
            for (int i = 0; i < rows.length; i++) {
                if (col == i) {
                    rows[i] = true;
                    continue;
                }
                rows[i] = false;
            }
        }

        private boolean checkNormal(boolean[][] board, int row, int col) {
            int N = board.length;
            //判断中上、左上、右上是否安全
            int step = 1;
            while (row - step >= 0) {
                if (board[row - step][col])                //中上
                    return false;
                if (col - step >= 0 && board[row - step][col - step])        //左上
                    return false;
                if (col + step < N && board[row - step][col + step])        //右上
                    return false;

                step++;
            }
            return true;

        }


        private List<String> board2String(boolean[][] board) {
            return Arrays.stream(board).map(booleans -> {
                StringBuilder sb = new StringBuilder();
                for (boolean aBoolean : booleans) {
                    if (aBoolean) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                return sb.toString();
            }).collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]", solution.solveNQueens(4).toString());
        }
    }
}