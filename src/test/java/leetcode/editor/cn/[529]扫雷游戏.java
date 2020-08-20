package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class SolutionTest529 {
//让我们一起来玩扫雷游戏！ 
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）
//地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。 
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板： 
//
// 
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。 
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。 
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 示例 2： 
//
// 输入: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 
//
// 注意： 
//
// 
// 输入矩阵的宽和高的范围为 [1,50]。 
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。 
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。 
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 103 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final char BOOM = 'M';

        private static final char EMPTY = 'E';

        private static final char EMPTY_CONVERT = 'B';

        private static final char FAILURE = 'X';

        private final int[][] DIRECTION = new int[][]{
                {0, 1},
                {0, -1},
                {1, 1},
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 0},
                {-1, 0}
        };


        @SuppressWarnings("all")
        public char[][] updateBoard(char[][] board, int[] click) {
            // 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
            //
            //
            // 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
            // 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
            // 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
            // 如果在此次点击中，若无更多方块可被揭露，则返回面板。
            int m = board.length;
            int n = board[0].length;
            //如果开始位置就是雷  就返回失败

            Set<Integer> visited = new HashSet<>();
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(click);

            while (!queue.isEmpty()) {
                int cap = queue.size();
                while (cap > 0) {
                    click = queue.poll();
                    int x = click[0];
                    int y = click[1];
                    visited.add(calcUnique(x, y, m, n));
                    char currChar = board[x][y];
                    if (currChar == BOOM) {
                        board[x][y] = FAILURE;
                        return board;
                    } else if (currChar == EMPTY) {
                        //搜索当前点周围雷的个数
                        int count = 0;
                        for (int[] direction : DIRECTION) {
                            int nextX = x + direction[0];
                            int nextY = y + direction[1];
                            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && board[nextX][nextY] == BOOM) {
                                count++;
                            }
                        }

                        if (count == 0) {
                            board[x][y] = EMPTY_CONVERT;
                            for (int[] direction : DIRECTION) {
                                int nextX = x + direction[0];
                                int nextY = y + direction[1];
                                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && !visited.contains(calcUnique(nextX, nextY, m, n))) {
                                    queue.offer(new int[]{nextX, nextY});
                                }
                            }
                        } else {
                            board[x][y] = (char) (count + '0');
                        }
                    }
                    cap--;
                }

            }
            return board;
        }

        private int calcUnique(int x, int y, int m, int n) {
            return x * Math.max(m, n) + y;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[B, 1, E, 1, B],[B, 1, M, 1, B],[B, 1, 1, 1, B],[B, B, B, B, B]]", ArrayUtils.twoDimension2String(
                    solution.updateBoard(new char[][]
                    {{'B', '1', 'E', '1', 'B'},
                    {'B', '1', 'M', '1', 'B'},
                    {'B', '1', '1', '1', 'B'},
                    {'B', 'B', 'B', 'B', 'B'}},
                            new int[]{3,0})));
            Assert.assertEquals("[[B, 1, E, 1, B],[B, 1, X, 1, B],[B, 1, 1, 1, B],[B, B, B, B, B]]", ArrayUtils.twoDimension2String(
                    solution.updateBoard(new char[][]
                    {{'B', '1', 'E', '1', 'B'},
                    {'B', '1', 'M', '1', 'B'},
                    {'B', '1', '1', '1', 'B'},
                    {'B', 'B', 'B', 'B', 'B'}},
                            new int[]{1,2})));
        }
    }
}