package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest928 {
//(这个问题与 尽量减少恶意软件的传播 是一样的，不同之处用粗体表示。)
//
// 在节点网络中，只有当 graph[i][j] = 1 时，每个节点 i 能够直接连接到另一个节点 j。
//
// 一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传
//播将继续，直到没有更多的节点可以被这种方式感染。
//
// 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
//
// 我们可以从初始列表中删除一个节点，并完全移除该节点以及从该节点到任何其他节点的任何连接。如果移除这一节点将最小化 M(initial)， 则返回该节点。如
//果有多个节点满足条件，就返回索引最小的节点。
//
//
//
//
//
//
// 示例 1：
//
// 输出：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
//输入：0
//
//
// 示例 2：
//
// 输入：graph = [[1,1,0],[1,1,1],[0,1,1]], initial = [0,1]
//输出：1
//
//
// 示例 3：
//
// 输入：graph = [[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]], initial = [0,1]
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
// graph[i][i] = 1
// 1 <= initial.length < graph.length
// 0 <= initial[i] < graph.length
//
// Related Topics 深度优先搜索 并查集 图
// 👍 31 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMalwareSpread(int[][] matrix, int[] nums) {

            // 思路 先合并非病毒节点，然后看一个root节点被病毒感染多少次，
            // 因为只能去掉一个节点，所以如果被感染次数>1，即无价值，最终看价值数
            int N = matrix.length;
            int[] clean = new int[N];
            int[] count = new int[N];
            UnionFind unionFind = new UnionFind(N);
            Arrays.fill(clean, 1);
            for (int num : nums) {
                clean[num] = 0;
            }
            for (int i = 0; i < N; i++) {
                if (clean[i] == 1) {
                    for (int j = i + 1; j < N; j++) {
                        if (clean[j] == 1 && matrix[i][j] == 1) {
                            unionFind.union(i, j);
                        }
                    }
                }
            }

            Map<Integer, Set<Integer>> unionMap = new HashMap<>();
            for (int num : nums) {
                Set<Integer> relationNode = new HashSet<>();
                for (int i = 0; i < N; i++) {
                    if (clean[i] == 1 && matrix[i][num] == 1) {
                        int root = unionFind.find(i);
                        relationNode.add(root);
                    }

                }
                for (Integer set : relationNode) {
                    count[set]++;
                }
                unionMap.put(num, relationNode);
            }
            int ansSize = -1;
            int ans = -1;
            for (Map.Entry<Integer, Set<Integer>> entry : unionMap.entrySet()) {
                int node = entry.getKey();
                Set<Integer> relationNode = entry.getValue();
                int currSize = 0;
                for (int relation : relationNode) {
                    if (count[relation] == 1) {
                        currSize += unionFind.size(relation);
                    }
                }
                if (currSize > ansSize || (currSize == ansSize && node < ans)) {
                    ans = node;
                    ansSize = currSize;
                }
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

            public int size(int i) {
                return size[find(i)];
            }

            public boolean union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return false;
                }
                parents[px] = py;
                size[py] += size[px];
                return true;
            }

            public int find(int v) {
                if (v != parents[v]) {
                    parents[v] = find(parents[v]);
                }
                return parents[v];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.minMalwareSpread(new int[][]{
                    {1, 1, 0},
                    {1, 1, 0},
                    {0, 0, 1},
            }, new int[]{0, 1}));

            Assert.assertEquals(0, solution.minMalwareSpread(new int[][]{
                    {1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 1, 0, 1, 0, 0},
                    {0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0, 0},
                    {0, 0, 1, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1}
            }, new int[]{6, 0, 4}));

            Assert.assertEquals(1, solution.minMalwareSpread(new int[][]{
                    {1, 1, 0},
                    {1, 1, 1},
                    {0, 1, 1}
            }, new int[]{0, 1}));


            Assert.assertEquals(9, solution.minMalwareSpread(new int[][]{
                    {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 1}
            }, new int[]{2, 1, 9}));

            Assert.assertEquals(3, solution.minMalwareSpread(new int[][]{
                    {1, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 1, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 1, 1, 0, 1, 0, 0, 0},
                    {0, 1, 1, 1, 1, 0, 1, 0, 0},
                    {0, 0, 0, 1, 1, 1, 0, 0, 0},
                    {0, 0, 1, 0, 1, 1, 0, 0, 0},
                    {0, 0, 0, 1, 0, 0, 1, 1, 0},
                    {0, 0, 0, 0, 0, 0, 1, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 1, 1}
            }, new int[]{3, 7}));

        }
    }
}
