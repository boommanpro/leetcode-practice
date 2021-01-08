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
            //logic 1. 构建临时砖块 clone from grid,将hits都消除
            //      2. 将砖块做并查集 并对根做size统计
            //      3. 从后往前加砖块 看有多少砖块union,就可以知道有多少掉落
            int row = grid.length;
            int col = grid[0].length;
            int[][] temp = new int[row][col];
            for (int i = 0; i < row; i++) {
                temp[i] = grid[i].clone();
            }
            for (int[] hit : hits) {
                int x = hit[0];
                int y = hit[1];
                temp[x][y] = 0;
            }
            UnionFind unionFind = new UnionFind(row * col + 1);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (temp[i][j] == 1) {
                        int id = i * col + j;
                        if (i == 0) {
                            unionFind.union(id, row * col);
                        }
                        if (i > 0 && temp[i - 1][j] == 1) {
                            unionFind.union(id, id - col);
                        }
                        if (j > 0 && temp[i][j - 1] == 1) {
                            unionFind.union(id, id - 1);
                        }
                    }

                }
            }
            int k = hits.length;
            int[] ans = new int[k--];
            while (k >= 0) {
                int x = hits[k][0];
                int y = hits[k][1];
                if (grid[x][y] != 0) {
                    int prev = unionFind.top();
                    int id = x * col + y;
                    if (x == 0) {
                        unionFind.union(id, row * col);
                    }
                    for (int[] direction : DIRECTION) {
                        int nextX = direction[0] + x;
                        int nextY = direction[1] + y;
                        if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && temp[nextX][nextY] == 1) {
                            unionFind.union(id, nextX * col + nextY);
                        }
                    }
                    temp[x][y] = 1;
                    int curr = unionFind.top();
                    //如果加上去后顶部有变化,需要减去自身砖
                    if (curr != prev) {
                        ans[k] = unionFind.top() - prev - 1;
                    }
                }
                k--;

            }
            return ans;
        }

        public static final class UnionFind {

            int[] parens;

            int[] size;

            public UnionFind(int n) {
                parens = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    parens[i] = i;
                }
                Arrays.fill(size, 1);
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
                parens[px] = py;
                size[py] += size[px];
                return true;
            }

            private int find(int v) {
                if (v != parens[v]) {
                    parens[v] = find(parens[v]);
                }
                return parens[v];
            }

            public int top() {
                return size[parens[parens.length - 1]];
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

            Assert.assertEquals("[0, 0]", Arrays.toString(solution.hitBricks(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 0}}, new int[][]{{1, 1}, {1, 0}})));

            Assert.assertEquals("[1, 0, 1, 0, 0]", Arrays.toString(solution.hitBricks(new int[][]{{1}, {1}, {1}, {1}, {1}}, new int[][]{{3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}})));
        }
    }
}