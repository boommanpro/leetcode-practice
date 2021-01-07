package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest547 {
//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 401 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findCircleNum(int[][] isConnected) {
            //计算分组数量
            int n = isConnected.length;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(unionFind.find(i));
            }
            return set.size();
        }

        public static class UnionFind {

            int[] parents;

            public UnionFind(int n) {
                parents = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
            }

            public void union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return;
                }
                parents[px] = py;
            }

            public int find(int v) {
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
            Assert.assertEquals(2, solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
            Assert.assertEquals(3, solution.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        }
    }
}