package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest743 {
//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 
// 👍 378 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            int INF = Integer.MAX_VALUE / 2;
            if (times.length < n - 1) {
                return -1;
            }
            int[][] path = new int[n][n];
            for (int[] arr : path) {
                Arrays.fill(arr, INF);
            }
            for (int[] time : times) {
                path[time[0] - 1][time[1] - 1] = time[2];
            }
            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            dist[k - 1] = 0;
            boolean[] used = new boolean[n];
            for (int i = 0; i < n; i++) {
                int x = -1;
                for (int y = 0; y < n; y++) {
                    if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                        x = y;
                    }
                }
                used[x] = true;
                for (int y = 0; y < n; y++) {
                    dist[y] = Math.min(dist[y], dist[x] + path[x][y]);
                }
            }
            int v = Arrays.stream(dist).max().orElse(INF);
            return v == INF ? -1 : v;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.networkDelayTime(new int[][]{
                    {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
            }, 4, 2));
        }
    }
}