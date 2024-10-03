package leetcode.editor.cn;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

class SolutionTest1928 {
//一个国家有 n 个城市，城市编号为 0 到 n - 1 ，题目保证 所有城市 都由双向道路 连接在一起 。道路由二维整数数组 edges 表示，其中
//edges[i] = [xi, yi, timei] 表示城市 xi 和 yi 之间有一条双向道路，耗费时间为 timei 分钟。两个城市之间可能会有多条耗费时间不同
//的道路，但是不会有道路两头连接着同一座城市。
//
// 每次经过一个城市时，你需要付通行费。通行费用一个长度为 n 且下标从 0 开始的整数数组 passingFees 表示，其中 passingFees[j]
// 是你经过城市 j 需要支付的费用。
//
// 一开始，你在城市 0 ，你想要在 maxTime 分钟以内 （包含 maxTime 分钟）到达城市 n - 1 。旅行的 费用 为你经过的所有城市 通行费
//之和 （包括 起点和终点城市的通行费）。
//
// 给你 maxTime，edges 和 passingFees ，请你返回完成旅行的 最小费用 ，如果无法在 maxTime 分钟以内完成旅行，请你返回 -
//1 。
//
//
//
// 示例 1：
//
//
//
//
//输入：maxTime = 30, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]
//], passingFees = [5,1,2,20,20,3]
//输出：11
//解释：最优路径为 0 -> 1 -> 2 -> 5 ，总共需要耗费 30 分钟，需要支付 11 的通行费。
//
//
// 示例 2：
//
//
//
//
//输入：maxTime = 29, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]
//], passingFees = [5,1,2,20,20,3]
//输出：48
//解释：最优路径为 0 -> 3 -> 4 -> 5 ，总共需要耗费 26 分钟，需要支付 48 的通行费。
//你不能选择路径 0 -> 1 -> 2 -> 5 ，因为这条路径耗费的时间太长。
//
//
// 示例 3：
//
//
//输入：maxTime = 25, edges = [[0,1,10],[1,2,10],[2,5,10],[0,3,1],[3,4,10],[4,5,15]
//], passingFees = [5,1,2,20,20,3]
//输出：-1
//解释：无法在 25 分钟以内从城市 0 到达城市 5 。
//
//
//
//
// 提示：
//
//
// 1 <= maxTime <= 1000
// n == passingFees.length
// 2 <= n <= 1000
// n - 1 <= edges.length <= 1000
// 0 <= xi, yi <= n - 1
// 1 <= timei <= 1000
// 1 <= passingFees[j] <= 1000
// 图中两个节点之间可能有多条路径。
// 图中不含有自环。
//
//
// Related Topics图 | 数组 | 动态规划
//
// 👍 76, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //1. 思路 bfs 图问题，可以根据dijkstra算法来，维护最少花费时间依次来算出所有可能性，然后剪纸算出最小花费、但是答案上是要求最小花费费用，并且数据量级还ok。
        //2. dijkstra算法 每次援用的是一个最小花费的点，能不能枚举所有情况
        //3. 图 graph 花费通行费 costPassing  花费时间 costTime 优先队列 pq
        public int minCost(int maxTime, int[][] edges, int[] passingFees) {
            int n = passingFees.length;
            int INF = Integer.MAX_VALUE / 2;
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
                graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
            }
            int[][] dp = new int[n][maxTime + 1];
            for (int[] temp : dp) {
                Arrays.fill(temp, INF);
            }
            int cNode = 0;
            int cTime = 0;
            int cPassing = passingFees[0];
            dp[cNode][cTime] = cPassing;
            int end = n - 1;
            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            pq.offer(new int[]{cNode, cTime, cPassing});
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                cNode = curr[0];
                cTime = curr[1];
                cPassing = curr[2];
                if (cNode == end) {
                    continue;
                }
                List<int[]> nextList = graph.get(cNode);
                if (nextList != null) {
                    for (int[] next : nextList) {
                        int nNode = next[0];
                        int nTime = cTime + next[1];
                        int nPassing = cPassing + passingFees[nNode];
                        if (nTime > maxTime) {
                            continue;
                        }
                        if (nPassing < dp[nNode][nTime]) {
                            pq.offer(new int[]{nNode, nTime, nPassing});
                            dp[nNode][nTime] = nPassing;
                        }
                    }
                }
            }
            int min = INF;
            for (int i = 0; i <= maxTime; i++) {
                min = Math.min(min, dp[end][i]);
            }
            return min == INF ? -1 : min;
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
        public void testMinCost() {
            // 测试用例 1
            int maxTime1 = 30;
            int[][] edges1 = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
            int[] passingFees1 = {5, 1, 2, 20, 20, 3};
            assertEquals(11, solution.minCost(maxTime1, edges1, passingFees1));

            // 测试用例 2
            int maxTime2 = 29;
            int[][] edges2 = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
            int[] passingFees2 = {5, 1, 2, 20, 20, 3};
            assertEquals(48, solution.minCost(maxTime2, edges2, passingFees2));

            // 测试用例 3
            int maxTime3 = 25;
            int[][] edges3 = {{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}};
            int[] passingFees3 = {5, 1, 2, 20, 20, 3};
            assertEquals(-1, solution.minCost(maxTime3, edges3, passingFees3));

            // 测试用例 4
            int maxTime4 = 500;
            int[][] edges4 = {{9, 7, 18}, {26, 3, 12}, {28, 45, 33}, {47, 10, 27}, {34, 18, 38},
                    {32, 13, 39}, {32, 26, 32}, {12, 0, 2}, {4, 1, 7}, {5, 3, 2},
                    {39, 25, 27}, {45, 10, 34}, {3, 19, 5}, {25, 32, 23}, {30, 10, 47},
                    {37, 2, 31}, {10, 32, 15}, {23, 14, 19}, {22, 6, 14}, {45, 39, 38},
                    {39, 21, 30}, {42, 17, 42}, {20, 17, 15}, {24, 0, 27}, {2, 46, 11},
                    {2, 24, 13}, {36, 22, 30}, {2, 1, 31}, {41, 35, 45}, {4, 19, 20},
                    {32, 27, 33}, {38, 46, 1}, {21, 11, 15}, {33, 41, 2}, {45, 18, 30},
                    {8, 33, 50}, {37, 11, 6}, {25, 17, 42}, {45, 39, 33}, {7, 4, 49},
                    {17, 42, 36}, {36, 16, 9}, {46, 25, 24}, {43, 4, 6}, {35, 13, 28},
                    {1, 28, 1}, {34, 35, 15}, {38, 1, 15}, {16, 6, 28}, {13, 0, 42},
                    {3, 30, 24}, {43, 27, 35}, {8, 0, 45}, {27, 20, 47}, {6, 16, 47},
                    {0, 34, 35}, {0, 35, 3}, {40, 11, 24}, {1, 0, 49}, {44, 20, 32},
                    {26, 12, 17}, {3, 2, 25}, {37, 25, 42}, {27, 1, 15}, {36, 25, 38},
                    {24, 47, 33}, {33, 28, 15}, {25, 43, 37}, {47, 31, 47}, {29, 10, 50},
                    {11, 1, 21}, {29, 3, 48}, {1, 25, 10}, {48, 17, 16}, {19, 24, 22},
                    {30, 7, 2}, {11, 22, 19}, {20, 42, 41}, {27, 3, 48}, {17, 0, 34},
                    {19, 14, 32}, {49, 2, 20}, {10, 3, 38}, {0, 49, 13}, {6, 3, 28},
                    {42, 23, 6}, {14, 8, 1}, {35, 16, 3}, {17, 7, 40}, {18, 7, 49},
                    {36, 35, 13}, {14, 40, 45}, {16, 33, 11}, {31, 22, 33}, {38, 15, 48},
                    {15, 14, 25}, {37, 13, 37}, {44, 32, 7}, {48, 1, 31}, {33, 12, 20},
                    {22, 26, 23}, {4, 10, 11}, {43, 28, 43}, {19, 8, 14}, {35, 31, 33},
                    {28, 27, 19}, {40, 11, 36}, {36, 43, 28}, {22, 21, 15}};
            int[] passingFees4 = {199, 505, 107, 961, 682, 400, 304, 517, 512, 18, 334, 627, 893, 412, 922, 289, 19, 161, 206, 879, 336, 831, 577, 802, 139, 348, 440, 219, 273, 691, 99, 858, 389, 955, 561, 353, 937, 904, 858, 704, 548, 497, 787, 546, 241, 67, 743, 42, 87, 137};
            assertEquals(336, solution.minCost(maxTime4, edges4, passingFees4));

        }
    }
}
