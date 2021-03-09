package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1782 {
//给你一个无向图，无向图由整数 n ，表示图中节点的数目，和 edges 组成，其中 edges[i] = [ui, vi] 表示 ui 和 vi 之间有一条
//无向边。同时给你一个代表查询的整数数组 queries 。 
//
// 第 j 个查询的答案是满足如下条件的点对 (a, b) 的数目： 
//
// 
// a < b 
// cnt 是与 a 或者 b 相连的边的数目，且 cnt 严格大于 queries[j] 。 
// 
//
// 请你返回一个数组 answers ，其中 answers.length == queries.length 且 answers[j] 是第 j 个查询的答
//案。 
//
// 请注意，图中可能会有 重复边 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
//输出：[6,5]
//解释：每个点对中，与至少一个点相连的边的数目如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries =
// [1,2,3,4,5]
//输出：[10,10,9,8,6]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 2 * 104 
// 1 <= edges.length <= 105 
// 1 <= ui, vi <= n 
// ui != vi 
// 1 <= queries.length <= 20 
// 0 <= queries[j] < edges.length 
// 
// Related Topics 图 
// 👍 13 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int P = (int) 1e5;

        public int[] countPairs(int n, int[][] edges, int[] queries) {
            Map<Integer, Integer> edgeCnt = new HashMap<>();
            int[] pCnt = new int[n + 1];
            for (int[] edge : edges) {
                int mux = Math.max(edge[0], edge[1]) * P + Math.min(edge[0], edge[1]);
                pCnt[edge[0]]++;
                pCnt[edge[1]]++;
                edgeCnt.put(mux, edgeCnt.getOrDefault(mux, 0) + 1);
            }
            int[] temp = Arrays.copyOf(pCnt, n + 1);
            Arrays.sort(temp);
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int l = 1;
                int r = n;
                while (l < r) {
                    while (l < r && temp[l] + temp[r] <= queries[i]) {
                        l++;
                    }
                    if (l < r) {
                        ans[i] += r - l;
                    }
                    r--;
                }
                if (ans[i] == 0) {
                    continue;
                }
                for (Map.Entry<Integer, Integer> entry : edgeCnt.entrySet()) {
                    int x = entry.getKey() / P;
                    int y = entry.getKey() % P;
                    if (pCnt[x] + pCnt[y] > queries[i] && pCnt[x] + pCnt[y] - entry.getValue() <= queries[i]) {
                        ans[i]--;
                    }
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[6, 5]", Arrays.toString(solution.countPairs(4, new int[][]{
                    {1, 2}, {2, 4}, {1, 3}, {2, 3}, {2, 1}
            }, new int[]{2, 3})));
            Assert.assertEquals("[10, 10, 9, 8, 6]", Arrays.toString(solution.countPairs(5, new int[][]{
                    {1, 5}, {1, 5}, {3, 4}, {2, 5}, {1, 3}, {5, 1}, {2, 3}, {2, 5}
            }, new int[]{1, 2, 3, 4, 5})));
        }
    }
}