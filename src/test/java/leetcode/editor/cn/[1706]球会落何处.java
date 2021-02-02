package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest1706 {
//用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。 
//
// 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。 
//
// 
// 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。 \
// 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。 /
// 
//
// 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就
//会卡住。 
//
// 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 
//-1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-
//1,-1]]
//输出：[1,-1,-1,-1,-1]
//解释：示例如图：
//b0 球开始放在第 0 列上，最终从箱子底部第 1 列掉出。
//b1 球开始放在第 1 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
//b2 球开始放在第 2 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
//b3 球开始放在第 3 列上，会卡在第 2、3 列和第 0 行之间的 "V" 形里。
//b4 球开始放在第 4 列上，会卡在第 2、3 列和第 1 行之间的 "V" 形里。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[-1]]
//输出：[-1]
//解释：球被卡在箱子左侧边上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]
//]
//输出：[0,1,2,3,4,-1]
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// grid[i][j] 为 1 或 -1 
// 
// Related Topics 动态规划 
// 👍 12 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findBall(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            UnionFind unionFind = new UnionFind((m + 1) * n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int v = grid[i][j];
                    if (j + v < 0 || j + v >= n) {
                        continue;
                    }
                    // 判断是否 V型
                    if (grid[i][j + v] != v) {
                        continue;
                    }
                    unionFind.union(calcId(i, j, n), calcId(i + 1, j + v, n));
                }
            }

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int target = unionFind.find(calcId(0, i, n));
                if (target / n == m) {
                    ans[i] = target % n;
                } else {
                    ans[i] = -1;
                }
            }
            return ans;
        }


        private int calcId(int x, int y, int col) {
            return x * col + y;
        }


        public static final class UnionFind {
            int[] parents;

            public UnionFind(int n) {
                parents = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
            }

            public boolean union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return false;
                }
                if (px > py) {
                    int temp = py;
                    py = px;
                    px = temp;
                }
                parents[px] = py;
                return true;
            }

            private int find(int v) {
                if (v != parents[v]) {
                    parents[v] = find(parents[v]);
                }
                return parents[v];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1, -1, -1, -1, -1]", Arrays.toString(solution.findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}})));
            Assert.assertEquals("[0, 1, 2, 3, 4, -1]", Arrays.toString(solution.findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}})));
            Assert.assertEquals("[-1, -1, 1, -1, -1, -1, -1, 10, 11, -1, -1, 12, 13, -1, -1, -1, -1, -1, 17, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]",
                    Arrays.toString(solution.findBall(new int[][]{{1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, 1, -1, -1, -1, -1, -1, 1},
                            {-1, 1, 1, 1, -1, -1, -1, -1, 1, 1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, 1, -1, 1, 1},
                            {1, -1, -1, -1, -1, 1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1, -1, 1, -1, 1, -1, -1, 1, -1, 1, -1, 1, 1, -1, -1, 1, 1, -1, 1, -1}}
                    )));
        }
    }
}