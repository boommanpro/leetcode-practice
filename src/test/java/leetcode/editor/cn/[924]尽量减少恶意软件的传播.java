package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest924 {
//在节点网络中，只有当 graph[i][j] = 1 时，每个节点 i 能够直接连接到另一个节点 j。 
//
// 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传
//播将继续，直到没有更多的节点可以被这种方式感染。 
//
// 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。 
//
// 我们可以从初始列表中删除一个节点。如果移除这一节点将最小化 M(initial)， 则返回该节点。如果有多个节点满足条件，就返回索引最小的节点。 
//
// 请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后可能仍然因恶意软件传播而受到感染。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
//输出：0
// 
//
// 示例 2： 
//
// 输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
//输出：0
// 
//
// 示例 3： 
//
// 输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 < graph.length = graph[0].length <= 300 
// 0 <= graph[i][j] == graph[j][i] <= 1 
// graph[i][i] == 1 
// 1 <= initial.length < graph.length 
// 0 <= initial[i] < graph.length 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 52 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minMalwareSpread(int[][] graph, int[] nums) {
            int N = graph.length;
            UnionFind unionFind = new UnionFind(N);
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (graph[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }
            int[] count = new int[N];
            for (int i : nums) {
                //对root进行统计,如果count[i]>1的话,哪怕消了这个块,其他的也有病毒,无济于事
                count[unionFind.find(i)]++;
            }
            int ans = -1;
            int ansSize = -1;
            for (int i : nums) {
                // 此时对病毒的感染能力做判断,能力强的且排在前面的就是答案
                int root = unionFind.find(i);
                if (count[root] == 1) {
                    int rootSize = unionFind.size(root);
                    if (rootSize > ansSize) {
                        ansSize = rootSize;
                        ans = i;
                    } else if (rootSize == ansSize && i < ans) {
                        ans = i;
                    }
                }
            }
            if (ans == -1) {
                //如果没有答案 就返回索引最小的
                ans = Arrays.stream(nums).min().getAsInt();
            }
            return ans;
        }

        public static final class UnionFind {

            int[] parents;

            int[] size;

            public UnionFind(int n) {
                parents = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
                Arrays.fill(size, 1);
            }

            public void union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return;
                }
                parents[px] = py;
                size[py] += size[px];
            }

            private int find(int v) {
                if (v != parents[v]) {
                    parents[v] = find(parents[v]);
                }
                return parents[v];
            }

            public int size(int i) {
                return size[find(i)];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[]{0, 1}));
            Assert.assertEquals(0, solution.minMalwareSpread(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, new int[]{0, 2}));
            Assert.assertEquals(1, solution.minMalwareSpread(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 2}));
            Assert.assertEquals(3, solution.minMalwareSpread(new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}}, new int[]{3, 1}));
        }
    }
}