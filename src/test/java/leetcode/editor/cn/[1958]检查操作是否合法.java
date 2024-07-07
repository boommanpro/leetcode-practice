package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class SolutionTest1958 {
//给你一个下标从 0 开始的 8 x 8 网格 board ，其中 board[r][c] 表示游戏棋盘上的格子 (r, c) 。棋盘上空格用 '.' 表示，
//白色格子用 'W' 表示，黑色格子用 'B' 表示。
//
// 游戏中每次操作步骤为：选择一个空格子，将它变成你正在执行的颜色（要么白色，要么黑色）。但是，合法 操作必须满足：涂色后这个格子是 好线段的一个端点 （好线
//段可以是水平的，竖直的或者是对角线）。
//
// 好线段 指的是一个包含 三个或者更多格子（包含端点格子）的线段，线段两个端点格子为 同一种颜色 ，且中间剩余格子的颜色都为 另一种颜色 （线段上不能有任何
//空格子）。你可以在下图找到好线段的例子：
//
// 给你两个整数 rMove 和 cMove 以及一个字符 color ，表示你正在执行操作的颜色（白或者黑），如果将格子 (rMove, cMove) 变成
//颜色 color 后，是一个 合法 操作，那么返回 true ，如果不是合法操作返回 false 。
//
//
//
// 示例 1：
//
//
//
//
//输入：board = [[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".",".
//"],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],["W","B",
//"B",".","W","W","W","B"],[".",".",".","B",".",".",".","."],[".",".",".","B",".",
//".",".","."],[".",".",".","W",".",".",".","."]], rMove = 4, cMove = 3, color =
//"B"
//输出：true
//解释：'.'，'W' 和 'B' 分别用颜色蓝色，白色和黑色表示。格子 (rMove, cMove) 用 'X' 标记。
//以选中格子为端点的两个好线段在上图中用红色矩形标注出来了。
//
//
// 示例 2：
//
//
//
//
//输入：board = [[".",".",".",".",".",".",".","."],[".","B",".",".","W",".",".",".
//"],[".",".","W",".",".",".",".","."],[".",".",".","W","B",".",".","."],[".",".",
//".",".",".",".",".","."],[".",".",".",".","B","W",".","."],[".",".",".",".",".",
//".","W","."],[".",".",".",".",".",".",".","B"]], rMove = 4, cMove = 4, color =
//"W"
//输出：false
//解释：虽然选中格子涂色后，棋盘上产生了好线段，但选中格子是作为中间格子，没有产生以选中格子为端点的好线段。
//
//
//
//
// 提示：
//
//
// board.length == board[r].length == 8
// 0 <= rMove, cMove < 8
// board[rMove][cMove] == '.'
// color 要么是 'B' 要么是 'W' 。
//
//
// Related Topics数组 | 枚举 | 矩阵
//
// 👍 24, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MAX = 8;

        private static final char ERROR = 'X';
        private static final char EMPTY = '.';
        private static final char WHITE = 'W';
        private static final char BLACK = 'B';

        private static final int[][] DIRECTIONS = new int[][]{
                {0, 1,},
                {-1, 0,},
                {1, 0,},
                {0, -1,},
                {1, 1,},
                {-1, -1,},
                {1, -1,},
                {-1, 1}
        };

        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
            if (board[rMove][cMove] != '.') {
                return false;
            }
            for (int[] direction : DIRECTIONS) {
                if (checkEndpoint(board, rMove, cMove, color, direction)) {
                    return true;
                }
            }
            return false;
        }

        private boolean checkEndpoint(char[][] board, int rMove, int cMove, char color, int[] direction) {
            char start = color;
            char next = color == BLACK ? WHITE : BLACK;
            int[] endPosition = findEnd(direction[0], direction[1], rMove, cMove, board, start);
            if (board[endPosition[0]][endPosition[1]] != start) {
                return false;
            }
            int cnt = 0;
            rMove += direction[0];
            cMove += direction[1];
            while (rMove != endPosition[0] || cMove != endPosition[1]) {
                if (board[rMove][cMove] != next) {
                    return false;
                }
                cnt++;
                rMove += direction[0];
                cMove += direction[1];

            }
            return cnt >= 1;
        }

        private int[] findEnd(int addR, int addC, int rMove, int cMove, char[][] board, char target) {
            int nextX = rMove + addR;
            int nextY = cMove + addC;
            while (nextX >= 0 && nextX < MAX && nextY >= 0 && nextY < MAX) {
                if (board[nextX][nextY] == target) {
                    return new int[]{nextX, nextY};
                }
                rMove = nextX;
                cMove = nextY;
                nextX = rMove + addR;
                nextY = cMove + addC;
            }
            return new int[]{rMove, cMove};
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private Solution solution;

        @Before
        public void setUp() {
            solution = new Solution();
            //端点的定义是是什么：有一个线段的两端是相同颜色，中间是不同颜色
        }

        @Test
        public void testCheckMove_Example1() {
            char[][] board = {
                    {'.', '.', '.', 'B', '.', '.', '.', '.'},
                    {'.', '.', '.', 'W', '.', '.', '.', '.'},
                    {'.', '.', '.', 'W', '.', '.', '.', '.'},
                    {'.', '.', '.', 'W', '.', '.', '.', '.'},
                    {'W', 'B', 'B', '.', 'W', 'W', 'W', 'B'},
                    {'.', '.', '.', 'B', '.', '.', '.', '.'},
                    {'.', '.', '.', 'B', '.', '.', '.', '.'},
                    {'.', '.', '.', 'W', '.', '.', '.', '.'}
            };
            boolean result = solution.checkMove(board, 4, 3, 'B');
            Assert.assertTrue(result);
        }

        @Test
        public void testCheckMove_Example2() {
            char[][] board = {
                    {'.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', 'B', '.', '.', 'W', '.', '.', '.'},
                    {'.', '.', 'W', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', 'W', 'B', '.', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', '.'},
                    {'.', '.', '.', '.', 'B', 'W', '.', '.'},
                    {'.', '.', '.', '.', '.', '.', 'W', '.'},
                    {'.', '.', '.', '.', '.', '.', '.', 'B'}
            };
            boolean result = solution.checkMove(board, 4, 4, 'W');
            Assert.assertFalse(result);
        }

        @Test
        public void testCheckMove_Example3() {
            char[][] board = {
                    {'.', '.', 'W', '.', 'B', 'W', 'W', 'B'},
                    {'B', 'W', '.', 'W', '.', 'W', 'B', 'B'},
                    {'.', 'W', 'B', 'W', 'W', '.', 'W', 'W'},
                    {'W', 'W', '.', 'W', '.', '.', 'B', 'B'},
                    {'B', 'W', 'B', 'B', 'W', 'W', 'B', '.'},
                    {'W', '.', 'W', '.', '.', 'B', 'W', 'W'},
                    {'B', '.', 'B', 'B', '.', '.', 'B', 'B'},
                    {'.', 'W', '.', 'W', '.', 'W', '.', 'W'}
            };
            boolean result = solution.checkMove(board, 5, 4, 'W');
            Assert.assertEquals(true, result);
        }

        @Test
        public void testCheckMove_Example4() {
            char[][] board = {
                    {'B', 'B', 'B', '.', 'W', 'W', 'B', 'W'},
                    {'B', 'B', '.', 'B', '.', 'B', 'B', 'B'},
                    {'.', 'W', '.', '.', 'B', '.', 'B', 'W'},
                    {'B', 'W', '.', 'W', 'B', '.', 'B', '.'},
                    {'B', 'W', 'W', 'B', 'W', '.', 'B', 'B'},
                    {'.', '.', 'W', '.', '.', 'W', '.', '.'},
                    {'W', '.', 'W', 'B', '.', 'W', 'W', 'B'},
                    {'B', 'B', 'W', 'W', 'B', 'W', '.', '.'}
            };
            boolean result = solution.checkMove(board, 5, 6, 'B');
            Assert.assertEquals(true, result);
        }
    }
}
