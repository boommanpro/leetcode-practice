package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

class SolutionTest959 {
//在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。 
//
// （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。 
//
// 返回区域的数目。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：
//[
//  " /",
//  "/ "
//]
//输出：2
//解释：2x2 网格如下：
// 
//
// 示例 2： 
//
// 输入：
//[
//  " /",
//  "  "
//]
//输出：1
//解释：2x2 网格如下：
// 
//
// 示例 3： 
//
// 输入：
//[
//  "\\/",
//  "/\\"
//]
//输出：4
//解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
//2x2 网格如下：
// 
//
// 示例 4： 
//
// 输入：
//[
//  "/\\",
//  "\\/"
//]
//输出：5
//解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
//2x2 网格如下：
// 
//
// 示例 5： 
//
// 输入：
//[
//  "//",
//  "/ "
//]
//输出：3
//解释：2x2 网格如下：
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 30 
// grid[i][j] 是 '/'、'\'、或 ' '。 
// 
// Related Topics 深度优先搜索 并查集 图 
// 👍 110 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 字符内容只有 '/'  '\'  ' '  三种
        public int regionsBySlashes(String[] grid) {
            int N = grid.length;
            int n = N * N * 4;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int id = 4 * (i * N + j);
                    char val = grid[i].charAt(j);
                    if (val != '/') {
                        unionFind.union(id, id + 1);
                        unionFind.union(id + 2, id + 3);
                    }
                    if (val != '\\') {
                        unionFind.union(id, id + 3);
                        unionFind.union(id + 1, id + 2);
                    }
                    if (i + 1 < N) {
                        unionFind.union(id + 1, 4 * ((i + 1) * N + j) + 3);
                    }
                    if (i - 1 >= 0) {
                        unionFind.union(id + 3, 4 * ((i - 1) * N + j) + 1);
                    }
                    if (j + 1 < N) {
                        unionFind.union(id + 2, 4 * (i * N + j + 1));
                    }
                    if (j - 1 >= 0) {
                        unionFind.union(id, 4 * (i * N + j - 1) + 2);
                    }

                }
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(unionFind.find(i));
            }
            return set.size();
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
            Assert.assertEquals(2, solution.regionsBySlashes(new String[]{" /", "/ "}));
            Assert.assertEquals(1, solution.regionsBySlashes(new String[]{" /", "  "}));
            Assert.assertEquals(4, solution.regionsBySlashes(new String[]{"\\\\/", "/\\\\"}));
            Assert.assertEquals(5, solution.regionsBySlashes(new String[]{"/\\", "\\/"}));
            Assert.assertEquals(3, solution.regionsBySlashes(new String[]{"//", "/ "}));
        }
    }
}