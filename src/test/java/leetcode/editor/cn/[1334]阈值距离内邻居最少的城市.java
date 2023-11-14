package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest1334 {
//有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，其中 edges[i] = [fromi, toi, weighti] 代表
//fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
//
// 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
//
// 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
//
//
//
// 示例 1：
//
//
//
//
//输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
//输出：3
//解释：城市分布图如上。
//每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
//城市 0 -> [城市 1, 城市 2] 
//城市 1 -> [城市 0, 城市 2, 城市 3] 
//城市 2 -> [城市 0, 城市 1, 城市 3] 
//城市 3 -> [城市 1, 城市 2] 
//城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
//
//
// 示例 2：
//
//
//
//
//输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]],
//distanceThreshold = 2
//输出：0
//解释：城市分布图如上。 
//每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
//城市 0 -> [城市 1] 
//城市 1 -> [城市 0, 城市 4] 
//城市 2 -> [城市 3, 城市 4] 
//城市 3 -> [城市 2, 城市 4]
//城市 4 -> [城市 1, 城市 2, 城市 3] 
//城市 0 在阈值距离 2 以内只有 1 个邻居城市。
//
//
//
//
// 提示：
//
//
// 2 <= n <= 100
// 1 <= edges.length <= n * (n - 1) / 2
// edges[i].length == 3
// 0 <= fromi < toi < n
// 1 <= weighti, distanceThreshold <= 10^4
// 所有 (fromi, toi) 都是不同的。
//
//
// Related Topics图 | 动态规划 | 最短路
//
// 👍 163, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] matrix = new int[n][n];
            for (int[] ints : matrix) {
                Arrays.fill(ints, Integer.MAX_VALUE >> 1);
            }
            for (int[] edge : edges) {
                matrix[edge[0]][edge[1]] = edge[2];
                matrix[edge[1]][edge[0]] = edge[2];
            }
            for (int k = 0; k < n; k++) {
                matrix[k][k] = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
            int[] ans = new int[]{Integer.MAX_VALUE, -1};
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= distanceThreshold) {
                        cnt++;
                    }
                }
                if (cnt <= ans[0]) {
                    ans[0] = cnt;
                    ans[1] = i;
                }
            }
            return ans[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4,1}}, 2));
        }

    }
}
