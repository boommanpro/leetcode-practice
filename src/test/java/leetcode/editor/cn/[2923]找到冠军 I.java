package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest2923 {
//一场比赛中共有 n 支队伍，按从 0 到 n - 1 编号。
//
// 给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i,
//j ：如果 grid[i][j] == 1，那么 i 队比 j 队 强 ；否则，j 队比 i 队 强 。
//
// 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
//
// 返回这场比赛中将会成为冠军的队伍。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,1],[0,0]]
//输出：0
//解释：比赛中有两支队伍。
//grid[0][1] == 1 表示 0 队比 1 队强。所以 0 队是冠军。
//
//
// 示例 2：
//
//
//输入：grid = [[0,0,1],[1,0,1],[0,0,0]]
//输出：1
//解释：比赛中有三支队伍。
//grid[1][0] == 1 表示 1 队比 0 队强。
//grid[1][2] == 1 表示 1 队比 2 队强。
//所以 1 队是冠军。
//
//
//
//
// 提示：
//
//
// n == grid.length
// n == grid[i].length
// 2 <= n <= 100
// grid[i][j] 的值为 0 或 1
//
// 对于所有 i， grid[i][i] 等于 0.
// 对于满足 i != j 的所有 i, j ，grid[i][j] != grid[j][i] 均成立
// 生成的输入满足：如果 a 队比 b 队强，b 队比 c 队强，那么 a 队比 c 队强
//
//
// Related Topics数组 | 矩阵
//
// 👍 29, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findChampion(int[][] grid) {
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j&&grid[i][j] == 1) {
                        cnt++;
                    }
                }
                if (cnt == n - 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.findChampion(new int[][]{
                    {0, 1},
                    {0, 0}
            }));
        }

    }
}
