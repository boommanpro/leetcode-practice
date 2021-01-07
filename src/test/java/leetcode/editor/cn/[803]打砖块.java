package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest803 {
//有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是： 
//
// 
// 一块砖直接连接到网格的顶部，或者 
// 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时 
// 
//
// 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，对应位置的砖块（若存在）会消
//失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。 
//
// 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。 
//
// 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
//输出：[2]
//解释：
//网格开始为：
//[[1,0,0,0]，
// [1,1,1,0]]
//消除 (1,0) 处加粗的砖块，得到网格：
//[[1,0,0,0]
// [0,1,1,0]]
//两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
//[[1,0,0,0],
// [0,0,0,0]]
//因此，结果为 [2] 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
//输出：[0,0]
//解释：
//网格开始为：
//[[1,0,0,0],
// [1,1,0,0]]
//消除 (1,1) 处加粗的砖块，得到网格：
//[[1,0,0,0],
// [1,0,0,0]]
//剩下的砖都很稳定，所以不会掉落。网格保持不变：
//[[1,0,0,0], 
// [1,0,0,0]]
//接下来消除 (1,0) 处加粗的砖块，得到网格：
//[[1,0,0,0],
// [0,0,0,0]]
//剩下的砖块仍然是稳定的，所以不会有砖块掉落。
//因此，结果为 [0,0] 。 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// grid[i][j] 为 0 或 1 
// 1 <= hits.length <= 4 * 104 
// hits[i].length == 2 
// 0 <= xi <= m - 1 
// 0 <= yi <= n - 1 
// 所有 (xi, yi) 互不相同 
// 
// Related Topics 并查集 
// 👍 78 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTION = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        public int[] hitBricks(int[][] grid, int[][] hits) {
            // 一块砖直接连接到网格的顶部 => 指的是r=0

            int R = grid.length, C = grid[0].length;

            int[][] A = new int[R][C];
            //先克隆一份数据 => A
            for (int r = 0; r < R; ++r) {
                A[r] = grid[r].clone();
            }
            // 将backup处理所有击落为0
            for (int[] hit : hits) {
                A[hit[0]][hit[1]] = 0;
            }

            UnionFind unionFind = new UnionFind(R * C + 1);
            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    if (A[r][c] == 1) {
                        int i = r * C + c;
                        if (r == 0)
                            unionFind.union(i, R * C);
                        //向上看
                        if (r > 0 && A[r - 1][c] == 1)
                            unionFind.union(i, (r - 1) * C + c);
                        //向左看
                        if (c > 0 && A[r][c - 1] == 1)
                            unionFind.union(i, r * C + c - 1);
                    }
                }
            }

            //----------------------------------------------------------

            int t = hits.length;

            int[] ans = new int[t--];

            while (t >= 0) {
                // 落点
                int r = hits[t][0];
                int c = hits[t][1];
                int preRoof = unionFind.top();
                // 如果原来需要击落的位置就是0的话,那么为0
                if (grid[r][c] == 0) {
                    t--;
                } else {
                    int i = r * C + c;
                    //尝试将当前和其余四个方向联合
                    for (int[] direction : DIRECTION) {
                        int nr = r + direction[0];
                        int nc = c + direction[1];
                        if (0 <= nr && nr < R && 0 <= nc && nc < C && A[nr][nc] == 1) {
                            unionFind.union(i, nr * C + nc);
                        }
                    }
                    if (r == 0) {
                        unionFind.union(i, R * C);
                    }
                    A[r][c] = 1;
                    ans[t--] = Math.max(0, unionFind.top() - preRoof - 1);
                }
            }

            return ans;
        }

        public static class UnionFind {

            int[] parent;

            int[] rank;

            int[] sz;

            public UnionFind(int N) {
                parent = new int[N];
                for (int i = 0; i < N; ++i) {
                    parent[i] = i;
                }
                rank = new int[N];
                sz = new int[N];
                Arrays.fill(sz, 1);
            }

            public int find(int v) {
                if (parent[v] != v) {
                    parent[v] = find(parent[v]);
                }
                return parent[v];
            }

            public void union(int x, int y) {
                int xr = find(x), yr = find(y);
                if (xr == yr) return;

                if (rank[xr] < rank[yr]) {
                    int tmp = yr;
                    yr = xr;
                    xr = tmp;
                }
                if (rank[xr] == rank[yr])
                    rank[xr]++;

                parent[yr] = xr;
                sz[xr] += sz[yr];
            }

            public int size(int x) {
                return sz[find(x)];
            }

            public int top() {
                //计算 R*C的sz
                return size(sz.length - 1) - 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();

            Assert.assertEquals("[2]", Arrays.toString(solution.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 1, 0}}, new int[][]{{1, 0}})));

//            Assert.assertEquals("[0, 0]", Arrays.toString(solution.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 0}}, new int[][]{{1, 1}, {1, 0}})));

        }
    }
}