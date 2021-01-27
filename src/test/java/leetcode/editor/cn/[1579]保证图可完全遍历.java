package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest1579 {
//Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3 种类型的边： 
//
// 
// 类型 1：只能由 Alice 遍历。 
// 类型 2：只能由 Bob 遍历。 
// 类型 3：Alice 和 Bob 都可以遍历。 
// 
//
// 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请
//你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图
//是可以完全遍历的。 
//
// 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
//输出：2
//解释：如果删除 [1,1,2] 和 [1,1,3] 这两条边，Alice 和 Bob 仍然可以完全遍历这个图。再删除任何其他的边都无法保证图可以完全遍历。所
//以可以删除的最大边数是 2 。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
//输出：0
//解释：注意，删除任何一条边都会使 Alice 和 Bob 无法完全遍历这个图。
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
//输出：-1
//解释：在当前图中，Alice 无法从其他节点到达节点 4 。类似地，Bob 也不能达到节点 1 。因此，图无法完全遍历。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// 1 <= edges.length <= min(10^5, 3 * n * (n-1) / 2) 
// edges[i].length == 3 
// 1 <= edges[i][0] <= 3 
// 1 <= edges[i][1] < edges[i][2] <= n 
// 所有元组 (typei, ui, vi) 互不相同 
// 
// Related Topics 并查集 
// 👍 46 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumEdgesToRemove(int n, int[][] edges) {
            int N = n + 1;
            UnionFind unionFindA = new UnionFind(N);
            UnionFind unionFindB = new UnionFind(N);
            int cnt = 0;
            for (int[] edge : edges) {
                if (edge[0] == 3) {
                    if (!unionFindA.union(edge[1], edge[2]) & !unionFindB.union(edge[1], edge[2])) {
                        cnt++;
                    }
                }
            }
            for (int[] edge : edges) {
                if (edge[0] == 1) {
                    if (!unionFindA.union(edge[1], edge[2])) {
                        cnt++;
                    }
                } else if (edge[0] == 2) {
                    if (!unionFindB.union(edge[1], edge[2])) {
                        cnt++;
                    }
                }
            }
            if (unionFindA.isAll() && unionFindB.isAll()) {
                return cnt;
            }
            return -1;
        }

        public static final class UnionFind {
            int[] parents;
            int[] size;

            public UnionFind(int n) {
                parents = new int[n];
                size = new int[n];
                Arrays.fill(size, 1);
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
            }

            public boolean union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return false;
                }
                if (px < py) {
                    int temp = py;
                    py = px;
                    px = temp;
                }
                size[py] += size[px];
                parents[px] = py;
                return true;
            }

            private int find(int v) {
                if (v != parents[v]) {
                    parents[v] = find(parents[v]);
                }
                return parents[v];
            }

            public boolean isAll() {
                return size[1] == size.length - 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}));
            Assert.assertEquals(0, solution.maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}}));
            Assert.assertEquals(-1, solution.maxNumEdgesToRemove(4, new int[][]{{3, 2, 3}, {1, 1, 2}, {2, 3, 4}}));
        }
    }
}