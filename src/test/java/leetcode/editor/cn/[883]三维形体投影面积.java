package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest883 {
//在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。 
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。 
//
// 现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。 
//
// 投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。 
//
// 返回 所有三个投影的总面积 。 
//
// 
//
// 
// 
//
// 
// 
//
// 
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[[1,2],[3,4]]
//输出：17
//解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
// 
//
// 示例 2: 
//
// 
//输入：grid = [[2]]
//输出：5
// 
//
// 示例 3： 
//
// 
//输入：[[1,0],[0,2]]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 50 
// 0 <= grid[i][j] <= 50 
// 
// Related Topics 几何 数组 数学 矩阵 👍 124 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int projectionArea(int[][] grid) {
            int n = grid.length;
            //顶部
            int cnt = 0;
            //侧面
            int[] xMax = new int[n];
            int[] yMax = new int[n];
            //前面
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int v = grid[i][j];
                    if (v != 0) {
                        cnt++;
                    }
                    xMax[i] = Math.max(grid[i][j], xMax[i]);
                    yMax[j] = Math.max(grid[i][j], yMax[j]);
                }
            }
            return Arrays.stream(yMax).sum() + Arrays.stream(xMax).sum() + cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(17, solution.projectionArea(new int[][]{{1, 2}, {3, 4}}));
            Assert.assertEquals(5, solution.projectionArea(new int[][]{{2}}));
            Assert.assertEquals(8, solution.projectionArea(new int[][]{{1, 0}, {0, 2}}));
        }

    }
}