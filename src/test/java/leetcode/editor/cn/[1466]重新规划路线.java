package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest1466 {
//n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输
//部决定重新规划路线，以改变交通拥堵的状况。
//
// 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
//
// 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
//
// 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
//
// 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
//
//
//
// 示例 1：
//
//
//
// 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//输出：3
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
//
// 示例 2：
//
//
//
// 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//输出：2
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
//
// 示例 3：
//
// 输入：n = 3, connections = [[1,0],[2,0]]
//输出：0
//
//
//
//
// 提示：
//
//
// 2 <= n <= 5 * 10^4
// connections.length == n-1
// connections[i].length == 2
// 0 <= connections[i][0], connections[i][1] <= n-1
// connections[i][0] != connections[i][1]
//
//
// Related Topics深度优先搜索 | 广度优先搜索 | 图
//
// 👍 208, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minReorder(int n, int[][] connections) {
            List<List<int[]>> neighbor = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                neighbor.add(new ArrayList<>());
            }
            for (int[] connection : connections) {
                int x = connection[0];
                int y = connection[1];
                neighbor.get(x).add(new int[]{y, 1});
                neighbor.get(y).add(new int[]{x, 0});
            }
            return dfs(0, -1, neighbor);
        }

        private int dfs(int x, int fa, List<List<int[]>> neighbor) {
            int sum = 0;
            for (int[] next : neighbor.get(x)) {
                int y = next[0];
                int cost = next[1];
                if (y != fa) {
                    sum += cost;
                    sum += dfs(y, x, neighbor);
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3,solution.minReorder(6,new int[][]{
                    {0,1},
                    {1,3},
                    {2,3},
                    {4,0},
                    {4,5}
            }));
        }

    }
}
