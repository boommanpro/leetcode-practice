package leetcode.editor.cn;

import org.junit.Test;

class SolutionTest2428 {
//给你一个大小为 m x n 的整数矩阵 grid 。 
//
// 按以下形式将矩阵的一部分定义为一个 沙漏 ： 
// 返回沙漏中元素的 最大 总和。 
//
// 注意：沙漏无法旋转且必须整个包含在矩阵中。 
//
// 
//
// 示例 1： 
// 输入：grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
//输出：30
//解释：上图中的单元格表示元素总和最大的沙漏：6 + 2 + 1 + 2 + 9 + 2 + 8 = 30 。
// 
//
// 示例 2： 
// 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：35
//解释：上图中的单元格表示元素总和最大的沙漏：1 + 2 + 3 + 5 + 7 + 8 + 9 = 35 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 3 <= m, n <= 150 
// 0 <= grid[i][j] <= 10⁶ 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 6 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int[][] DIRECTION = new int[][]{
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, 0},
                {1, -1},
                {1, 0},
                {1, 1}
        };

        public int maxSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int max = 0;
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int sum = 0;
                    for (int[] direction : DIRECTION) {
                        sum += grid[i + direction[0]][j + direction[1]];
                    }
                    max = Math.max(sum, max);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

    }
}