package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

class SolutionTest3112 {
//给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间
//有一条需要 lengthi 单位时间通过的无向边。
//
// 同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。
//
// 注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。
//
// 请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么
//answer[i] 为 -1 。
//
//
//
// 示例 1：
//
//
//
//
// 输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
//
//
// 输出：[0,-1,4]
//
// 解释：
//
// 我们从节点 0 出发，目的是用最少的时间在其他节点消失之前到达它们。
//
//
// 对于节点 0 ，我们不需要任何时间，因为它就是我们的起点。
// 对于节点 1 ，我们需要至少 2 单位时间，通过 edges[0] 到达。但当我们到达的时候，它已经消失了，所以我们无法到达它。
// 对于节点 2 ，我们需要至少 4 单位时间，通过 edges[2] 到达。
//
//
// 示例 2：
//
//
//
//
// 输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,3,5]
//
//
// 输出：[0,2,3]
//
// 解释：
//
// 我们从节点 0 出发，目的是用最少的时间在其他节点消失之前到达它们。
//
//
// 对于节点 0 ，我们不需要任何时间，因为它就是我们的起点。
// 对于节点 1 ，我们需要至少 2 单位时间，通过 edges[0] 到达。
// 对于节点 2 ，我们需要至少 3 单位时间，通过 edges[0] 和 edges[1] 到达。
//
//
// 示例 3：
//
//
// 输入：n = 2, edges = [[0,1,1]], disappear = [1,1]
//
//
// 输出：[0,-1]
//
// 解释：
//
// 当我们到达节点 1 的时候，它恰好消失，所以我们无法到达节点 1 。
//
//
//
// 提示：
//
//
// 1 <= n <= 5 * 10⁴
// 0 <= edges.length <= 10⁵
// edges[i] == [ui, vi, lengthi]
// 0 <= ui, vi <= n - 1
// 1 <= lengthi <= 10⁵
// disappear.length == n
// 1 <= disappear[i] <= 10⁵
//
//
// Related Topics图 | 数组 | 最短路 | 堆（优先队列）
//
// 👍 4, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] minimumTime(int n, int[][] edges, int[] disappear) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }

            for (int[] edge : edges) {
                int x = edge[0];
                int y = edge[1];
                int cost = edge[2];
                map.get(x).add(new int[]{y, cost});
                map.get(y).add(new int[]{x, cost});
            }
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            queue.add(new int[]{0, 0});
            ans[0] = 0;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int p = curr[0];
                int cost = curr[1];
                //一个节点可能会被重复添加、所以需要判断
                if (cost != ans[p]) {
                    continue;
                }
                for (int[] next : map.get(p)) {
                    if (next[1] + cost < disappear[next[0]] && (ans[next[0]] == -1 || next[1] + cost < ans[next[0]])) {
                        ans[next[0]] = next[1] + cost;
                        queue.add(new int[]{next[0], cost + next[1]});
                    }
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testExample1() {
            int n = 3;
            int[][] edges = {{0, 1, 2}, {1, 2, 1}, {0, 2, 4}};
            int[] disappear = {1, 1, 5};
            int[] expected = {0, -1, 4};
            assertArrayEquals(expected, solution.minimumTime(n, edges, disappear));
        }

        @Test
        public void testExample2() {
            int n = 3;
            int[][] edges = {{0, 1, 2}, {1, 2, 1}, {0, 2, 4}};
            int[] disappear = {1, 3, 5};
            int[] expected = {0, 2, 3};
            assertArrayEquals(expected, solution.minimumTime(n, edges, disappear));
        }

        @Test
        public void testExample3() {
            int n = 2;
            int[][] edges = {{0, 1, 1}};
            int[] disappear = {1, 1};
            int[] expected = {0, -1};
            assertArrayEquals(expected, solution.minimumTime(n, edges, disappear));
        }

        @Test
        public void testWithSevenNodes() {
            int n = 7;
            int[][] edges = {
                    {1, 4, 3}, // Node 1 to Node 4 with cost 3
                    {3, 4, 2}, // Node 3 to Node 4 with cost 2
                    {2, 5, 5}, // Node 2 to Node 5 with cost 5
                    {3, 3, 10} // Node 3 to Node 3 with cost 10 (self-loop)
            };
            int[] disappear = {10, 1, 13, 1, 7, 1, 19}; // Disappear times for nodes 0 to 6

            // Expected results
            int[] expectedResults = {0, -1, -1, -1, -1, -1, -1};

            // Call the method under test
            int[] results = solution.minimumTime(n, edges, disappear);

            // Assert that the results match the expected results
            assertArrayEquals(expectedResults, results);
        }

        @Test
        public void testCustomCase() {
            int n = 5;
            int[][] edges = {
                    {0, 3, 10}, // From node 0 to node 3 with cost 10
                    {2, 3, 2},  // From node 2 to node 3 with cost 2
                    {3, 3, 6},  // Self-loop at node 3 with cost 6
                    {3, 3, 9},  // Another self-loop at node 3 with cost 9
                    {1, 3, 2},  // From node 1 to node 3 with cost 2
                    {3, 0, 4}   // From node 3 to node 0 with cost 4
            };
            int[] disappear = {17, 17, 17, 8, 20}; // Disappear times for nodes 0 to 4

            // Expected results
            int[] expectedResults = {0, 6, 6, 4, -1};

            // Call the method under test
            int[] results = solution.minimumTime(n, edges, disappear);

            // Assert that the results match the expected results
            assertArrayEquals(expectedResults, results);
        }

        @Test
        public void testSelfLoopsAndNoReachableNodes() {
            int n = 1; // There are two nodes: 0 and 1
            int[][] edges = {
                    {0, 0, 1}, // Self-loop at node 0 with cost 1
                    {0, 0, 7}, // Another self-loop at node 0 with cost 7
                    {0, 0, 4}, // Another self-loop at node 0 with cost 4
                    {0, 0, 7}, // Duplicate self-loop at node 0 with cost 7
                    {0, 0, 8}, // Another self-loop at node 0 with cost 8
                    {0, 0, 6}, // Another self-loop at node 0 with cost 6
                    {0, 0, 8}, // Duplicate self-loop at node 0 with cost 8
                    {0, 0, 2}, // Another self-loop at node 0 with cost 2
                    {0, 0, 6}  // Another self-loop at node 0 with cost 6
            };
            int[] disappear = {14}; // Node 0 never disappears, node 1 disappears at time 14

            // Expected results
            int[] expectedResults = {0}; // Node 0 has no cost to itself, and node 1 cannot be reached before it disappears

            // Call the method under test
            int[] results = solution.minimumTime(n, edges, disappear);

            // Assert that the results match the expected results
            assertArrayEquals(expectedResults, results);
        }

    }
}
