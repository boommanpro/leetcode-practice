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

        public int totalNQueens(int n) {
            count = 0;
            boolean[][] board = new boolean[n][n];
            dfs(board, 0, n);
            return count;
        }

        private void dfs(boolean[][] board, int start, int n) {
            if (start == n) {
                count++;
                return;
            }
            for (int i = 0; i < n; i++) {
                if (isSafePosition(board, start, i)) {
                    fillSafePosition(board, start, i);
                    dfs(board, start + 1, n);
                }
            }
        }

        private void fillSafePosition(boolean[][] board, int row, int col) {
            Arrays.fill(board[row], false);
            board[row][col] = true;
        }

        private boolean isSafePosition(boolean[][] board, int row, int col) {
            int N = board.length;
            int step = 1;
            while (row - step >= 0) {
                if (board[row - step][col]) {
                    return false;
                }
                if (col - step >= 0 && board[row - step][col - step]) {
                    return false;
                }
                if (col + step < N && board[row - step][col + step]) {
                    return false;
                }
                step++;
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
        }
    }
}