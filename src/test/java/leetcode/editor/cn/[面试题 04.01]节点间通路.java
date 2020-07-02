package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SolutionTest面试题04_01 {
//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。 
//
// 示例1: 
//
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
// 
//
// 示例2: 
//
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
//1, 3], [2, 3], [3, 4]], start = 0, target = 4
// 输出 true
// 
//
// 提示： 
//
// 
// 节点数量n在[0, 1e5]范围内。 
// 节点编号大于等于 0 小于 n。 
// 图中可能存在自环和平行边。 
// 
// Related Topics 图

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
            // 将矩阵转为邻接表
            List<Integer>[] adj = new ArrayList[n];
            for (int[] edge : graph) {
                int from = edge[0];
                int to = edge[1];
                if (adj[from] == null)
                    adj[from] = new ArrayList<>();
                adj[from].add(to);
            }
            // 建一个函数进行广度遍历
            return hasPath(n, adj, start, target);
        }

        private boolean hasPath(int n, List<Integer>[] adj, int start, int target) {
            // 维护一个队列：从0的链表访问，访问过程中0能到达的节点继续入列
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(start);
            // 维护一个数组：对已经入列的节点，不再重复处理
            boolean[] visited = new boolean[n];
            visited[start] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();
                // 不断从队列中取节点得到新的可访问链表，对链表上的可访问节点中判断是否有target
                for (int i = 0; i < size; i++) {
                    int node = queue.poll();
                    List<Integer> nextList = adj[node];
                    if (nextList == null) {
                        continue;
                    }
                    for (Integer next : nextList) {
                        // 遍历过程中有target则直接返回true, 否则最终返回false
                        if (next == target) {
                            return true;
                        }
                        // 已经入列的节点，不再重复处理
                        if (visited[next]) {
                            continue;
                        }
                        // 用数组标记新的节点
                        visited[next] = true;
                        // 访问过程中0能到达的节点继续入列
                        queue.add(next);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.findWhetherExistsPath(3, new int[][]{{0, 1}, {0, 2}, {1, 2}, {1, 2}}, 0, 2));
            Assert.assertTrue(solution.findWhetherExistsPath(5, new int[][]{{0, 1}, {0, 2}, {0, 4}, {0, 4}, {0, 1}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4));
        }
    }
}