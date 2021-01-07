package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1631 {
//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 106 
// 
// Related Topics 深度优先搜索 并查集 图 二分查找 
// 👍 55 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static  final int[][] DIRECTION = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        int row;

        int col;

        public int minimumEffortPath(int[][] heights) {
            //第一种 利用二分查找 不断逼近可能值
            int l = 0;
            int r = 999999;
            int ans = r;
            //为了防止走回头路
            row = heights.length;
            col = heights[0].length;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                Set<Long> set = new HashSet<>();
                if (dfs(heights, set, 0, 0, mid)) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return ans;
        }

        private boolean dfs(int[][] heights, Set<Long> set, int x, int y, int v) {
            if (x == row - 1 && y == col - 1) {
                return true;
            }
            set.add((long) (x * 1000000 + y));
            for (int[] direction : DIRECTION) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && !set.contains((long) (nextX * 1000000 + nextY)) && (Math.abs(heights[x][y] - heights[nextX][nextY]) <= v)) {
                    if (dfs(heights, set, nextX, nextY, v)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
            Assert.assertEquals(1, solution.minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
            Assert.assertEquals(0, solution.minimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}));
            Assert.assertEquals(999999, solution.minimumEffortPath(new int[][]{{1, 1000000}}));
        }
    }
}