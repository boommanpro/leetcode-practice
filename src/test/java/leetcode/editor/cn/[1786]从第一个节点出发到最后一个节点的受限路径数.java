package leetcode.editor.cn;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1786 {
//现有一个加权无向连通图。给你一个正整数 n ，表示图中有 n 个节点，并按从 1 到 n 给节点编号；另给你一个数组 edges ，其中每个 edges[i
//] = [ui, vi, weighti] 表示存在一条位于节点 ui 和 vi 之间的边，这条边的权重为 weighti 。 
//
// 从节点 start 出发到节点 end 的路径是一个形如 [z0, z1, z2, ..., zk] 的节点序列，满足 z0 = start 、zk = 
//end 且在所有符合 0 <= i <= k-1 的节点 zi 和 zi+1 之间存在一条边。 
//
// 路径的距离定义为这条路径上所有边的权重总和。用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离。受限路径 为满足 d
//istanceToLastNode(zi) > distanceToLastNode(zi+1) 的一条路径，其中 0 <= i <= k-1 。 
//
// 返回从节点 1 出发到节点 n 的 受限路径数 。由于数字可能很大，请返回对 109 + 7 取余 的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
//输出：3
//解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。三条受限路径分别是：
//1) 1 --> 2 --> 5
//2) 1 --> 2 --> 3 --> 5
//3) 1 --> 3 --> 5
// 
//
// 示例 2： 
//
// 
//输入：n = 7, edges = [[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,5,3],[2,
//6,4]]
//输出：1
//解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。唯一一条受限路径是：1 --> 3 --> 7 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 104 
// n - 1 <= edges.length <= 4 * 104 
// edges[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 1 <= weighti <= 105 
// 任意两个节点之间至多存在一条边 
// 任意两个节点之间至少存在一条路径 
// 
// Related Topics 图 动态规划 
// 👍 23 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static final int MOD = (int) (1e9) + 7;

        public int countRestrictedPaths(int n, int[][] edges) {
            Map<Integer, List<int[]>> adjacentMatrix = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                adjacentMatrix.put(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjacentMatrix.get(edge[0]).add(new int[]{edge[1], edge[2]});
                adjacentMatrix.get(edge[1]).add(new int[]{edge[0], edge[2]});
            }
            int[] minDistance = new int[n + 1];
            Arrays.fill(minDistance, Integer.MAX_VALUE);
            minDistance[n] = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{n, 0});
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] curr = queue.poll();
                    int id = curr[0];
                    int cost = curr[1];
                    for (int[] next : adjacentMatrix.get(id)) {
                        int nextId = next[0];
                        int sumCost = next[1] + cost;
                        if (sumCost < minDistance[nextId]) {
                            minDistance[nextId] = sumCost;
                            queue.add(new int[]{nextId, sumCost});
                        }
                    }
                }
            }
            int[] ans = new int[n + 1];
            ans[n] = 1;
            PriorityQueue<int[]> minDistanceQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            for (int i = 1; i <= n; i++) {
                minDistanceQueue.add(new int[]{i, minDistance[i]});
            }
            while (!minDistanceQueue.isEmpty()) {
                int[] curr = minDistanceQueue.poll();
                int id = curr[0];
                int cost = curr[1];
                for (int[] next : adjacentMatrix.get(id)) {
                    int nextId = next[0];
                    int nextCost = minDistance[nextId];
                    if (cost > nextCost) {
                        ans[id] += ans[nextId];
                        ans[id] %= MOD;
                    }
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
            Assert.assertEquals(3, solution.countRestrictedPaths(5, new int[][]{
                    {1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}
            }));
            Assert.assertEquals(1, solution.countRestrictedPaths(7, new int[][]{
                    {1, 3, 1}, {4, 1, 2}, {7, 3, 4}, {2, 5, 3}, {5, 6, 1}, {6, 7, 2}, {7, 5, 3}, {2, 6, 4}
            }));
            Assert.assertEquals(4, solution.countRestrictedPaths(6, new int[][]{
                    {6, 2, 9}, {2, 1, 7}, {6, 5, 10}, {4, 3, 1}, {3, 1, 8}, {4, 6, 4}, {5, 1, 7}, {1, 4, 7}, {4, 5, 3}, {3, 6, 6}, {5, 3, 9}, {1, 6, 6}, {3, 2, 2}, {5, 2, 8}
            }));
        }
    }
}