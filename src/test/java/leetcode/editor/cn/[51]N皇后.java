package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
// 示例: 
//
// 输入: 4
//输出: [
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
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * N 皇后是直线横线和斜线都不能有皇后
         */

        public List<List<String>> solveNQueens(int n) {
            boolean[][] checkerboard = new boolean[n][n];
            List<List<String>> ans = new ArrayList<>();
            backTracking(ans, checkerboard, 0, n);
            return ans;
        }

        private void backTracking(List<List<String>> ans, boolean[][] checkerboard, int row, int N) {

            if (row == N) {
                ans.add(toCheckerBoard(checkerboard));
                return;
            }

            for (int i = 0; i < N; i++) {
                //摆放这一行的皇后，之前要清掉所有这一行摆放的记录，防止污染棋盘
                for (int j = 0; j < N; j++) {
                    checkerboard[row][j] = false;
                }
                checkerboard[row][i] = true;

                if (isSafety(checkerboard, row, i, N)) {
                    backTracking(ans, checkerboard, row + 1, N);
                }
            }
        }

        private List<String> toCheckerBoard(boolean[][] checkerboard) {
            List<String> result = new ArrayList<>();
            for (boolean[] booleans : checkerboard) {
                StringBuilder sb = new StringBuilder();
                for (boolean b : booleans) {
                    sb.append(b ? "Q" : ".");
                }
                result.add(sb.toString());
            }
            return result;
        }

        private static boolean isSafety(boolean[][] chess, int row, int col, int N) {
            //判断中上、左上、右上是否安全
            int step = 1;
            while (row - step >= 0) {
                if (chess[row - step][col])                //中上
                    return false;
                if (col - step >= 0 && chess[row - step][col - step])        //左上
                    return false;
                if (col + step < N && chess[row - step][col + step])        //右上
                    return false;

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
//            System.out.println(solution.solveNQueens(1));
//            System.out.println(solution.solveNQueens(2));
//            System.out.println(solution.solveNQueens(3));
            System.out.println(solution.solveNQueens(4));
//            System.out.println(solution.solveNQueens(5));
//            System.out.println(solution.solveNQueens(6));
//            System.out.println(solution.solveNQueens(7));
//            System.out.println(solution.solveNQueens(8));
        }
    }
}