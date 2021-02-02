package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest417 {
//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 193 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTIONS = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };


        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return new ArrayList<>();
            }
            int m = matrix.length;
            int n = matrix[0].length;
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> input = new LinkedList<>();
            input.offer(new int[]{0, 0});
            visited[0][0] = true;
            for (int i = 1; i < m; i++) {
                input.offer(new int[]{i, 0});
                visited[i][0] = true;
            }
            for (int i = 1; i < n; i++) {
                input.offer(new int[]{0, i});
                visited[0][i] = true;
            }
            boolean[][] left = getReachable(input, visited, matrix);
            input = new LinkedList<>();
            visited = new boolean[m][n];
            input.offer(new int[]{m - 1, n - 1});
            visited[m - 1][n - 1] = true;
            for (int i = 0; i < m - 1; i++) {
                input.offer(new int[]{i, n - 1});
                visited[i][n - 1] = true;
            }
            for (int i = 0; i < n - 1; i++) {
                input.offer(new int[]{m - 1, i});
                visited[m - 1][i] = true;
            }
            boolean[][] right = getReachable(input, visited, matrix);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (left[i][j] && right[i][j]) {
                        ans.add(Arrays.asList(i, j));
                    }
                }
            }
            return ans;
        }

        private boolean[][] getReachable(Queue<int[]> input, boolean[][] visited, int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            while (!input.isEmpty()) {
                int[] start = input.poll();
                for (int[] direction : DIRECTIONS) {
                    int nextX = start[0] + direction[0];
                    int nextY = start[1] + direction[1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY] && matrix[nextX][nextY] >= matrix[start[0]][start[1]]) {
                        input.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            return visited;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]", ArrayUtils.twoDimensionCollections2String(solution.pacificAtlantic(new int[][]{
                    {1, 2, 2, 3, 5},
                    {3, 2, 3, 4, 4},
                    {2, 4, 5, 3, 1},
                    {6, 7, 4, 1, 5},
                    {5, 1, 1, 2, 4}
            })));
            Assert.assertEquals("[]", ArrayUtils.twoDimensionCollections2String(solution.pacificAtlantic(new int[][]{})));
            Assert.assertEquals("[[0, 0]]", ArrayUtils.twoDimensionCollections2String(solution.pacificAtlantic(new int[][]{{1}})));


        }
    }
}