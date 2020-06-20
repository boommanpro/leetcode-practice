package leetcode.editor.cn;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

class SolutionTest200 {
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            int sum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    //如果此时有值为 '1' 说明至少有一个岛屿
                    if (grid[i][j] == '1') {
                        sum++;
                        grid[i][j] = '0';
                        Queue<Integer> queue = new LinkedList<>();
                        queue.offer(i * n + j);
                        while (!queue.isEmpty()) {
                            int id = queue.remove();
                            //第几行
                            int row = id / n;
                            //第几列
                            int col = id % n;
                            if (row + 1 < m && grid[row + 1][col] == '1') {
                                queue.add((row + 1) * n + col);
                                grid[row + 1][col] = '0';
                            }
                            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                                queue.add((row - 1) * n + col);
                                grid[row - 1][col] = '0';
                            }
                            if (col + 1 < n && grid[row][col + 1] == '1') {
                                queue.add(row * n + col + 1);
                                grid[row][col + 1] = '0';
                            }
                            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                                queue.add(row * n + col - 1);
                                grid[row][col - 1] = '0';
                            }
                        }
                    }
                }
            }
            return sum;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {
        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.numIslands(str2CharArray("11000\n11000\n00100\n00011")));
            Assert.assertEquals(1, solution.numIslands(str2CharArray("11110\n11010\n11000\n00000")));
        }

        private char[][] str2CharArray(String str) {
            String[] split = str.split("\n");
            int m = split.length;
            int n = split[0].length();
            char[][] result = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = split[i].charAt(j);
                }
            }
            return result;
        }
    }
}