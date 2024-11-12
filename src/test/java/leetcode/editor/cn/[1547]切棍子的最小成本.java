package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class SolutionTest1547 {
//有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下：
//
//
//
// 给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
//
// 你可以按顺序完成切割，也可以根据需要更改切割的顺序。
//
// 每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前
//木棍的长度）。请参阅第一个示例以获得更直观的解释。
//
// 返回切棍子的 最小总成本 。
//
//
//
// 示例 1：
//
//
//
//
//输入：n = 7, cuts = [1,3,4,5]
//输出：16
//解释：按 [1, 3, 4, 5] 的顺序切割的情况如下所示：
//
//第一次切割长度为 7 的棍子，成本为 7 。第二次切割长度为 6 的棍子（即第一次切割得到的第二根棍子），第三次切割为长度 4 的棍子，最后切割长度为 3
//的棍子。总成本为 7 + 6 + 4 + 3 = 20 。
//而将切割顺序重新排列为 [3, 5, 1, 4] 后，总成本 = 16（如示例图中 7 + 4 + 3 + 2 = 16）。
//
//
// 示例 2：
//
//
//输入：n = 9, cuts = [5,6,1,4,2]
//输出：22
//解释：如果按给定的顺序切割，则总成本为 25 。总成本 <= 25 的切割顺序很多，例如，[4, 6, 5, 2, 1] 的总成本 = 22，是所有可能方案
//中成本最小的。
//
//
//
// 提示：
//
//
// 2 <= n <= 10^6
// 1 <= cuts.length <= min(n - 1, 100)
// 1 <= cuts[i] <= n - 1
// cuts 数组中的所有整数都 互不相同
//
//
// Related Topics数组 | 动态规划 | 排序
//
// 👍 164, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int n, int[] cuts) {
            int m = cuts.length + 2;
            int[] newCuts = new int[m];
            Arrays.sort(cuts);
            System.arraycopy(cuts, 0, newCuts, 1, cuts.length);
            newCuts[0] = 0;
            newCuts[m - 1] = n;
            return dfs(0, m - 1, newCuts, new int[m][m]);
        }

        private int dfs(int i, int j, int[] cuts, int[][] memo) {
            if (i + 1 == j) {
                return 0;
            }
            if (memo[i][j] > 0) {
                return memo[i][j];
            }
            int minCost = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                minCost = Math.min(minCost, dfs(i, k, cuts, memo) + dfs(k, j, cuts, memo));
            }
            memo[i][j] = minCost + cuts[j] - cuts[i];
            return memo[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            int n1 = 7;
            int[] cuts1 = {1, 3, 4, 5};
            assertEquals(16, solution.minCost(n1, cuts1));

            int n2 = 9;
            int[] cuts2 = {5, 6, 1, 4, 2};
            assertEquals(22, solution.minCost(n2, cuts2));
        }
    }
}
