package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest741 {
//给你一个 n x n 的网格 grid ，代表一块樱桃地，每个格子由以下三种数字的一种来表示：
//
//
// 0 表示这个格子是空的，所以你可以穿过它。
// 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
// -1 表示这个格子里有荆棘，挡着你的路。
//
//
// 请你统计并返回：在遵守下列规则的情况下，能摘到的最多樱桃数：
//
//
// 从位置 (0, 0) 出发，最后到达 (n - 1, n - 1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为 0 或者 1 的格子）；
//
// 当到达 (n - 1, n - 1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
// 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为 0 ）；
// 如果在 (0, 0) 和 (n - 1, n - 1) 之间不存在一条可经过的路径，则无法摘到任何一个樱桃。
//
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,1,-1],[1,0,-1],[1,1,1]]
//输出：5
//解释：玩家从 (0, 0) 出发：向下、向下、向右、向右移动至 (2, 2) 。
//在这一次行程中捡到 4 个樱桃，矩阵变成 [[0,1,-1],[0,0,-1],[0,0,0]] 。
//然后，玩家向左、向上、向上、向左返回起点，再捡到 1 个樱桃。
//总共捡到 5 个樱桃，这是最大可能值。
//
//
// 示例 2：
//
//
//输入：grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
//输出：0
//
//
//
//
// 提示：
//
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 50
// grid[i][j] 为 -1、0 或 1
// grid[0][0] != -1
// grid[n - 1][n - 1] != -1
//
//
// Related Topics数组 | 动态规划 | 矩阵
//
// 👍 446, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int[][] f = new int[n + 1][n + 1];
            for (int[] r : f) {
                Arrays.fill(r, Integer.MIN_VALUE);
            }
            f[1][1] = grid[0][0];
            for (int t = 1; t < n * 2 - 1; t++) {
                for (int j = Math.min(t, n - 1); j >= Math.max(t - n + 1, 0); j--) {
                    for (int k = Math.min(t, n - 1); k >= j; k--) {
                        if (grid[t - j][j] < 0 || grid[t - k][k] < 0) {
                            f[j + 1][k + 1] = Integer.MIN_VALUE;
                        } else {
                            f[j + 1][k + 1] = Math.max(
                                    Math.max(f[j + 1][k + 1], f[j + 1][k]),
                                    Math.max(f[j][k + 1], f[j][k])
                            )
                                    + grid[t - j][j] + (k != j ? grid[t - k][k] : 0);
                        }
                    }
                }
            }
            return Math.max(f[n][n], 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.cherryPickup(new int[][]{
                    {0, 1, -1},
                    {1, 0, -1},
                    {1, 1, 1}
            }));
        }

    }
}
