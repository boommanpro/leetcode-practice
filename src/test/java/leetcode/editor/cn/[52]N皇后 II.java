package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest52 {
//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 144 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int count;

        int N;

        public int totalNQueens(int n) {
            count = 0;
            N = n;
            boolean[][] board = new boolean[n][n];
            dfs(board, 0);
            return count;
        }

        private void dfs(boolean[][] board, int start) {
            if (start == N) {
                count++;
                return;
            }
            for (int i = 0; i < N; i++) {
                if (checkSuccess(board, start, i)) {
                    board[start][i] = true;
                    dfs(board, start + 1);
                    board[start][i] = false;
                }
            }
        }

        private boolean checkSuccess(boolean[][] board, int row, int col) {
            //不能在同一列
            //不能在同一对角
            for (int i = 0; i < row; i++) {
                if (board[i][col]) {
                    return false;
                }
            }
            int l = 0, r = 0;
            for (int i = row-1; i >= 0; i--) {
                l--;
                r++;
                if (col + l >= 0 && board[i][col + l]) {
                    return false;
                }
                if (col + r < N && board[i][col + r]) {
                    return false;
                }
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
            Assert.assertEquals(2, solution.totalNQueens(4));
            Assert.assertEquals(10, solution.totalNQueens(5));
            Assert.assertEquals(4, solution.totalNQueens(6));
            Assert.assertEquals(40, solution.totalNQueens(7));
            Assert.assertEquals(92, solution.totalNQueens(8));
            Assert.assertEquals(352, solution.totalNQueens(9));
        }
    }
}