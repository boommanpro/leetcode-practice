package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class SolutionTest1766 {
//给你一个 n 个节点的树（也就是一个无环连通无向图），节点编号从 0 到 n - 1 ，且恰好有 n - 1 条边，每个节点有一个值。树的 根节点 为 0
//号点。
//
// 给你一个整数数组 nums 和一个二维数组 edges 来表示这棵树。nums[i] 表示第 i 个点的值，edges[j] = [uj, vj] 表示节
//点 uj 和节点 vj 在树中有一条边。
//
// 当 gcd(x, y) == 1 ，我们称两个数 x 和 y 是 互质的 ，其中 gcd(x, y) 是 x 和 y 的 最大公约数 。
//
// 从节点 i 到 根 最短路径上的点都是节点 i 的祖先节点。一个节点 不是 它自己的祖先节点。
//
// 请你返回一个大小为 n 的数组 ans ，其中 ans[i]是离节点 i 最近的祖先节点且满足 nums[i] 和 nums[ans[i]] 是 互质的
//，如果不存在这样的祖先节点，ans[i] 为 -1 。
//
//
//
// 示例 1：
//
//
//
//
//输入：nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]
//输出：[-1,0,0,1]
//解释：上图中，每个节点的值在括号中表示。
//- 节点 0 没有互质祖先。
//- 节点 1 只有一个祖先节点 0 。它们的值是互质的（gcd(2,3) == 1）。
//- 节点 2 有两个祖先节点，分别是节点 1 和节点 0 。节点 1 的值与它的值不是互质的（gcd(3,3) == 3）但节点 0 的值是互质的(gcd(
//2,3) == 1)，所以节点 0 是最近的符合要求的祖先节点。
//- 节点 3 有两个祖先节点，分别是节点 1 和节点 0 。它与节点 1 互质（gcd(3,2) == 1），所以节点 1 是离它最近的符合要求的祖先节点。
//
//
//
// 示例 2：
//
//
//
//
//输入：nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
//输出：[-1,0,-1,0,0,0,-1]
//
//
//
//
// 提示：
//
//
// nums.length == n
// 1 <= nums[i] <= 50
// 1 <= n <= 10⁵
// edges.length == n - 1
// edges[j].length == 2
// 0 <= uj, vj < n
// uj != vj
//
//
// Related Topics树 | 深度优先搜索 | 广度优先搜索 | 数组 | 数学 | 数论
//
// 👍 63, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MX = 51;
        private static final int[][] coprime = new int[MX][MX];

        static {
            for (int i = 1; i < MX; i++) {
                int k = 0;
                for (int j = 1; j < MX; j++) {
                    if (gcd(i, j) == 1) {
                        coprime[i][k++] = j;
                    }
                }
            }
        }

        private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        public int[] getCoprimes(int[] nums, int[][] edges) {
            int n = nums.length;
            List<Integer>[] g = new ArrayList[n];
            Arrays.setAll(g, i -> new ArrayList<>());
            for (int[] edge : edges) {
                int x = edge[0];
                int y = edge[1];
                g[x].add(y);
                g[y].add(x);
            }
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            int[] valDepth = new int[MX];
            int[] valNodeId = new int[MX];
            dfs(0, -1, 1, g, nums, ans, valDepth, valNodeId);
            return ans;
        }

        private void dfs(int x, int fa, int depth, List<Integer>[] g, int[] nums, int[] ans, int[] valDepth, int[] valNodeId) {
            int val = nums[x];
            int maxDepth = 0;
            for (int j : coprime[val]) {
                if (j == 0) {
                    break;
                }
                if (valDepth[j] > maxDepth) {
                    maxDepth = valDepth[j];
                    ans[x] = valNodeId[j];
                }
            }

            int tmpDepth = valDepth[val];
            int tmpNodeId = valNodeId[val];

            valDepth[val] = depth;
            valNodeId[val] = x;

            for (Integer y : g[x]) {
                if (y != fa) {
                    dfs(y, x, depth + 1, g, nums, ans, valDepth, valNodeId);
                }
            }
            valDepth[val] = tmpDepth;
            valNodeId[val] = tmpNodeId;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[-1, 0, 0, 1]", Arrays.toString(solution.getCoprimes(new int[]{2, 3, 3, 2}, new int[][]{{0, 1}, {1, 2}, {1, 3}})));
            Assert.assertEquals("[-1, 0, 0, 1]", Arrays.toString(solution.getCoprimes(new int[]{2, 3, 3, 2}, new int[][]{{0, 1}, {1, 2}, {1, 3}})));
            Assert.assertEquals(Arrays.toString(new int[]{-1, 0, -1, 0, 0, 0, -1}), Arrays.toString(solution.getCoprimes(new int[]{5, 6, 10, 2, 3, 6, 15}, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}})));

        }

    }
}
