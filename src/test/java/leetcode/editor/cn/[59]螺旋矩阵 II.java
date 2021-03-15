package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest59 {
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 321 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTIONS = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            int max = n * n;
            int x = 0;
            int y = 0;
            int i = 2;
            visited[x][y] = true;
            ans[x][y] = 1;
            int direction = 0;
            while (i <= max) {
                int nextX = x + DIRECTIONS[direction][0];
                int nextY = y + DIRECTIONS[direction][1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    x = nextX;
                    y = nextY;
                    ans[x][y] = i++;
                    visited[nextX][nextY] = true;
                } else {
                    direction = (direction + 1) % 4;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[1, 2, 3],[8, 9, 4],[7, 6, 5]]", ArrayUtils.twoDimension2String(solution.generateMatrix(3)));

        }
    }
}