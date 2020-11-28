package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionTest542 {
//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//{0,0,0},
//{0,1,0},
//{0,0,0}
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            Queue<int[]> queue = new LinkedList<>();
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                    } else {
                        matrix[i][j] = -1;
                    }
                }
            }
            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == -1) {
                        matrix[newX][newY] = matrix[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[0, 0, 0][0, 1, 0][0, 0, 0]]", twoDimensionToString(solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})));
        }

        public String twoDimensionToString(int[][] nums) {
            StringBuilder sb = new StringBuilder("[");
            for (int[] num : nums) {
                sb.append(Arrays.toString(num));
            }
            sb.append("]");
            return sb.toString();
        }
    }
}