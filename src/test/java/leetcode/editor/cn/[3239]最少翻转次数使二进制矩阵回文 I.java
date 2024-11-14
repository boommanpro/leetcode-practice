package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3239 {
//给你一个 m x n 的二进制矩阵 grid 。
//
// 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
//
// 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
//
// 请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。
//
//
//
// 示例 1：
//
//
// 输入：grid = [[1,0,0],[0,0,0],[0,0,1]]
//
//
// 输出：2
//
// 解释：
//
//
//
// 将高亮的格子翻转，得到所有行都是回文的。
//
// 示例 2：
//
//
// 输入：grid = [[0,1],[0,1],[0,0]]
//
//
// 输出：1
//
// 解释：
//
//
//
// 将高亮的格子翻转，得到所有列都是回文的。
//
// 示例 3：
//
//
// 输入：grid = [[1],[0]]
//
//
// 输出：0
//
// 解释：
//
// 所有行已经是回文的。
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m * n <= 2 * 10⁵
// 0 <= grid[i][j] <= 1
//
//
// Related Topics数组 | 双指针 | 矩阵
//
// 👍 2, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFlips(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int ans0 = 0;
            for (int i = 0; i < m; i++) {
                ans0 += minFlip(grid[i]);
            }
            int ans1 = 0;
            for (int j = 0; j < n; j++) {
                int[] row = new int[m];
                for (int i = 0; i < m; i++) {
                    row[i] = grid[i][j];
                }
                ans1 += minFlip(row);
            }
            return Math.min(ans0, ans1);
        }

        private int minFlip(int[] row) {
            int cnt = 0;
            for (int i = 0; i < row.length / 2; i++) {
                if (row[i] != row[row.length - 1 - i]) {
                    cnt++;
                }
            }
            return cnt;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void testAllRowsPalindrome() {
            int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 1}};
            assertEquals(2, solution.minFlips(grid));
        }

        @Test
        public void testAllColumnsPalindrome() {
            int[][] grid = {{0, 1}, {0, 1}, {0, 0}};
            assertEquals(1, solution.minFlips(grid));
        }

        @Test
        public void testAlreadyPalindrome() {
            int[][] grid = {{1}, {0}};
            assertEquals(0, solution.minFlips(grid));
        }
    }
}
