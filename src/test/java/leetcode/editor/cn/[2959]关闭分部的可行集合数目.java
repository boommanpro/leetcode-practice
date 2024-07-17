package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class SolutionTest2959 {
//一个公司在全国有 n 个分部，它们之间有的有道路连接。一开始，所有分部通过这些道路两两之间互相可以到达。
//
// 公司意识到在分部之间旅行花费了太多时间，所以它们决定关闭一些分部（也可能不关闭任何分部），同时保证剩下的分部之间两两互相可以到达且最远距离不超过
//maxDistance 。
//
// 两个分部之间的 距离 是通过道路长度之和的 最小值 。
//
// 给你整数 n ，maxDistance 和下标从 0 开始的二维整数数组 roads ，其中 roads[i] = [ui, vi, wi] 表示一条从
//ui 到 vi 长度为 wi的 无向 道路。
//
// 请你返回关闭分部的可行方案数目，满足每个方案里剩余分部之间的最远距离不超过 maxDistance。
//
// 注意，关闭一个分部后，与之相连的所有道路不可通行。
//
// 注意，两个分部之间可能会有多条道路。
//
//
//
// 示例 1：
//
//
//
//
//输入：n = 3, maxDistance = 5, roads = [[0,1,2],[1,2,10],[0,2,10]]
//输出：5
//解释：可行的关闭分部方案有：
//- 关闭分部集合 [2] ，剩余分部为 [0,1] ，它们之间的距离为 2 。
//- 关闭分部集合 [0,1] ，剩余分部为 [2] 。
//- 关闭分部集合 [1,2] ，剩余分部为 [0] 。
//- 关闭分部集合 [0,2] ，剩余分部为 [1] 。
//- 关闭分部集合 [0,1,2] ，关闭后没有剩余分部。
//总共有 5 种可行的关闭方案。
//
//
// 示例 2：
//
//
//
//
//输入：n = 3, maxDistance = 5, roads = [[0,1,20],[0,1,10],[1,2,2],[0,2,2]]
//输出：7
//解释：可行的关闭分部方案有：
//- 关闭分部集合 [] ，剩余分部为 [0,1,2] ，它们之间的最远距离为 4 。
//- 关闭分部集合 [0] ，剩余分部为 [1,2] ，它们之间的距离为 2 。
//- 关闭分部集合 [1] ，剩余分部为 [0,2] ，它们之间的距离为 2 。
//- 关闭分部集合 [0,1] ，剩余分部为 [2] 。
//- 关闭分部集合 [1,2] ，剩余分部为 [0] 。
//- 关闭分部集合 [0,2] ，剩余分部为 [1] 。
//- 关闭分部集合 [0,1,2] ，关闭后没有剩余分部。
//总共有 7 种可行的关闭方案。
//
//
// 示例 3：
//
//
//输入：n = 1, maxDistance = 10, roads = []
//输出：2
//解释：可行的关闭分部方案有：
//- 关闭分部集合 [] ，剩余分部为 [0] 。
//- 关闭分部集合 [0] ，关闭后没有剩余分部。
//总共有 2 种可行的关闭方案。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10
// 1 <= maxDistance <= 10⁵
// 0 <= roads.length <= 1000
// roads[i].length == 3
// 0 <= ui, vi <= n - 1
// ui != vi
// 1 <= wi <= 1000
// 一开始所有分部之间通过道路互相可以到达。
//
//
// Related Topics位运算 | 图 | 枚举 | 最短路 | 堆（优先队列）
//
// 👍 29, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MAX = Integer.MAX_VALUE >> 1;

        public int numberOfSets(int n, int maxDistance, int[][] roads) {
            int ans = 0;
            for (int mask = 0; mask < (1 << n); mask++) {
                boolean[] point = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if ((1 << i & mask) != 0) {
                        point[i] = true;
                    }
                }
                int[][] dp = new int[n][n];
                for (int[] arr : dp) {
                    Arrays.fill(arr, MAX);
                }
                for (int i = 0; i < n; i++) {
                    dp[i][i] = 0;
                }
                for (int[] road : roads) {
                    int x = road[0];
                    int y = road[1];
                    int dis = road[2];
                    if (point[x] && point[y]) {
                        dp[x][y] = dp[y][x] = Math.min(dp[x][y], dis);
                    }
                }
                ans += floyd(n, point, dp);
                ans += sum(n, point, maxDistance, dp);
            }
            return ans;
        }

        private int floyd(int n, boolean[] point, int[][] dp) {
            for (int k = 0; k < n; k++) {
                if (!point[k]) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    if (!point[i]) {
                        continue;
                    }
                    for (int j = i + 1; j < n; j++) {
                        if (!point[j]) {
                            continue;
                        }
                        dp[i][j] = dp[j][i] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }

            }
            return 0;
        }

        private int sum(int n, boolean[] point, int maxDistance, int[][] dp) {
            for (int i = 0; i < n; i++) {
                if (!point[i]) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (!point[j]) {
                        continue;
                    }
                    if (dp[i][j] > maxDistance) {
                        return 0;
                    }

                }

            }
            return 1;
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
            int maxDistance = 5;
            int[][] roads = {{0, 1, 2}, {1, 2, 10}, {0, 2, 10}};
            assertEquals(5, solution.numberOfSets(n, maxDistance, roads));
        }

        @Test
        public void testExample2() {
            int n = 3;
            int maxDistance = 5;
            int[][] roads = {{0, 1, 20}, {0, 1, 10}, {1, 2, 2}, {0, 2, 2}};
            assertEquals(7, solution.numberOfSets(n, maxDistance, roads));
        }

        @Test
        public void testExample3() {
            int n = 1;
            int maxDistance = 10;
            int[][] roads = {};
            assertEquals(2, solution.numberOfSets(n, maxDistance, roads));
        }

        @Test
        public void testProvidedData() {
            int n = 10;
            int maxDistance = 430;
            int[][] roads = {{3, 2, 237}, {3, 1, 79}, {6, 1, 84}, {6, 1, 103}, {9, 6, 453}, {3, 1, 342}, {3, 1, 201}, {8, 0, 439}, {7, 5, 467}, {4, 3, 99}, {8, 7, 146}, {8, 7, 335}, {6, 1, 512}, {1, 0, 498}, {5, 3, 241}, {5, 2, 202}, {4, 1, 443}, {2, 0, 69}, {2, 1, 450}, {6, 3, 352}, {2, 0, 438}, {4, 0, 95}, {6, 1, 257}, {5, 1, 271}, {8, 1, 80}, {9, 1, 452}, {3, 1, 57}, {9, 7, 361}, {8, 4, 105}};
            assertEquals(118, solution.numberOfSets(n, maxDistance, roads));
        }
    }
}
