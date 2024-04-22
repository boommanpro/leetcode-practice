package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest3123 {
//给你一个 n 个节点的无向带权图，节点编号为 0 到 n - 1 。图中总共有 m 条边，用二维数组 edges 表示，其中 edges[i] = [ai,
// bi, wi] 表示节点 ai 和 bi 之间有一条边权为 wi 的边。
//
// 对于节点 0 为出发点，节点 n - 1 为结束点的所有最短路，你需要返回一个长度为 m 的 boolean 数组 answer ，如果 edges[i]
// 至少 在其中一条最短路上，那么 answer[i] 为 true ，否则 answer[i] 为 false 。
//
// 请你返回数组 answer 。
//
// 注意，图可能不连通。
//
//
//
// 示例 1：
//
//
//
//
// 输入：n = 6, edges = [[0,1,4],[0,2,1],[1,3,2],[1,4,3],[1,5,1],[2,3,1],[3,5,3],[4
//,5,2]]
//
//
// 输出：[true,true,true,false,true,true,true,false]
//
// 解释：
//
// 以下为节点 0 出发到达节点 5 的 所有 最短路：
//
//
// 路径 0 -> 1 -> 5 ：边权和为 4 + 1 = 5 。
// 路径 0 -> 2 -> 3 -> 5 ：边权和为 1 + 1 + 3 = 5 。
// 路径 0 -> 2 -> 3 -> 1 -> 5 ：边权和为 1 + 1 + 2 + 1 = 5 。
//
//
// 示例 2：
//
//
//
//
// 输入：n = 4, edges = [[2,0,1],[0,1,1],[0,3,4],[3,2,2]]
//
//
// 输出：[true,false,false,true]
//
// 解释：
//
// 只有一条从节点 0 出发到达节点 3 的最短路 0 -> 2 -> 3 ，边权和为 1 + 2 = 3 。
//
//
//
// 提示：
//
//
// 2 <= n <= 5 * 10⁴
// m == edges.length
// 1 <= m <= min(5 * 10⁴, n * (n - 1) / 2)
// 0 <= ai, bi < n
// ai != bi
// 1 <= wi <= 10⁵
// 图中没有重边。
//
//
// 👍 6, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean[] findAnswer(int n, int[][] edges) {
            Dijkstra dijkstra = new Dijkstra(n, edges);
            return dijkstra.getPassingEdge();
        }
        public class Dijkstra {
            private int n;

            private int m;

            List<int[]>[] g ;

            public Dijkstra(int n,int[][] edges) {
                this.n = n;
                this.m = edges.length;
                g = new List[n];
                Arrays.setAll(g, i -> new ArrayList<>());
                for (int i = 0; i < edges.length; i++) {
                    int[] edge = edges[i];
                    int x = edge[0];
                    int y = edge[1];
                    int w = edge[2];
                    g[x].add(new int[]{y, w, i});
                    g[y].add(new int[]{x, w, i});
                }
            }

            public long[] getDistance(){
                long[] f = new long[n];
                Arrays.fill(f, Long.MAX_VALUE);
                f[0] = 0;
                PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
                //distance point
                pq.offer(new long[]{0, 0});
                while (!pq.isEmpty()) {
                    long[] curr = pq.poll();
                    long dis = curr[0];
                    int x = (int) curr[1];
                    if (dis > f[x]) {
                        continue;
                    }
                    for (int[] next : g[x]) {
                        int y = next[0];
                        int w = next[1];
                        if (dis + w < f[y]) {
                            f[y] = dis + w;
                            pq.offer(new long[]{f[y], y});
                        }
                    }
                }
                return f;
            }

            public List<int[]>[] getGraph(){
                return g;
            }

            public boolean[] getPassingEdge(){
                long[] f = getDistance();
                boolean[] edges = new boolean[m];
                boolean[] points = new boolean[n];
                if (f[n - 1] == Long.MAX_VALUE) {
                    return edges;
                }
                boolean[] vis = new boolean[n];
                dfs(n - 1, g, f, vis, edges,points);
                return edges;
            }


            public boolean[] getPassingPoint(){
                long[] f = getDistance();
                boolean[] edges = new boolean[m];
                boolean[] points = new boolean[n];
                if (f[n - 1] == Long.MAX_VALUE) {
                    return points;
                }
                boolean[] vis = new boolean[n];
                dfs(n - 1, g, f, vis, edges,points);
                return points;
            }

            private void dfs(int y, List<int[]>[] g, long[] f, boolean[] vis, boolean[] edges, boolean[] points) {
                vis[y] = true;
                points[y] = true;
                for (int[] next : g[y]) {
                    int x = next[0];
                    int w = next[1];
                    int i = next[2];
                    if (w + f[x] != f[y]) {
                        continue;
                    }
                    edges[i] = true;
                    if (!vis[x]) {
                        dfs(x, g, f, vis, edges, points);
                    }
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[true, true, true, false, true, true, true, false]", Arrays.toString(solution.findAnswer(6, new int[][]{
                    {0, 1, 4},
                    {0, 2, 1},
                    {1, 3, 2},
                    {1, 4, 3},
                    {1, 5, 1},
                    {2, 3, 1},
                    {3, 5, 3},
                    {4, 5, 2}
            })));
            Assert.assertEquals("[true, false, false, true]", Arrays.toString(solution.findAnswer(4, new int[][]{
                    {2, 0, 1},
                    {0, 1, 1},
                    {0, 3, 4},
                    {3, 2, 2}
            })));
        }

    }
}
