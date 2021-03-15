package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest54 {
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 701 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTIONS = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            int x = 0;
            int y = 0;
            int max = matrix.length * matrix[0].length;

            boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            ans.add(matrix[x][y]);
            visited[x][y] = true;
            int direction = 0;
            int i = 1;
            while (i < max) {
                int nextX = x + DIRECTIONS[direction][0];
                int nextY = y + DIRECTIONS[direction][1];
                if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && !visited[nextX][nextY]) {
                    x = nextX;
                    y = nextY;
                    ans.add(matrix[x][y]);
                    visited[x][y] = true;
                    i++;
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
            Assert.assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", solution.spiralOrder(new int[][]{
                    {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
            }).toString());
            Assert.assertEquals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]", solution.spiralOrder(new int[][]{
                    {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
            }).toString());
        }
    }
}