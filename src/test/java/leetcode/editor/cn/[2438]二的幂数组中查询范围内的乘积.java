package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionTest2438 {
//给你一个正整数 n ，你需要找到一个下标从 0 开始的数组 powers ，它包含 最少 数目的 2 的幂，且它们的和为 n 。powers 数组是 非递减
// 顺序的。根据前面描述，构造 powers 数组的方法是唯一的。 
//
// 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] ，其中 queries[i]
// 表示请你求出满足 lefti <= j <= righti 的所有 powers[j] 的乘积。 
//
// 请你返回一个数组 answers ，长度与 queries 的长度相同，其中 answers[i]是第 i 个查询的答案。由于查询的结果可能非常大，请你将
//每个 answers[i] 都对 10⁹ + 7 取余 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 15, queries = [[0,1],[2,2],[0,3]]
//输出：[2,4,64]
//解释：
//对于 n = 15 ，得到 powers = [1,2,4,8] 。没法得到元素数目更少的数组。
//第 1 个查询的答案：powers[0] * powers[1] = 1 * 2 = 2 。
//第 2 个查询的答案：powers[2] = 4 。
//第 3 个查询的答案：powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64 
//。
//每个答案对 10⁹ + 7 得到的结果都相同，所以返回 [2,4,64] 。
// 
//
// 示例 2： 
//
// 输入：n = 2, queries = [[0,0]]
//输出：[2]
//解释：
//对于 n = 2, powers = [2] 。
//唯一一个查询的答案是 powers[0] = 2 。答案对 10⁹ + 7 取余后结果相同，所以返回 [2] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 1 <= queries.length <= 10⁵ 
// 0 <= starti <= endi < powers.length 
// 
//
// Related Topics 位运算 数组 前缀和 👍 6 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int MOD = (int) (1e9) + 7;

        public int[] productQueries(int n, int[][] queries) {
            List<Integer> collections = new ArrayList<>();
            while (n > 0) {
                int v = calcMax(n);
                n -= v;
                collections.add(v);
            }
            Collections.sort(collections);
            int[] ans = new int[queries.length];

            int[][] dp = new int[collections.size()][collections.size()];
            for (int i = 0; i < collections.size(); i++) {
                dp[i][i] = collections.get(i) % MOD;
            }
            for (int i = 0; i < collections.size(); i++) {
                for (int j = i + 1; j < collections.size(); j++) {
                    dp[i][j] = (int) (((long) dp[i][j - 1] * dp[j][j]) % MOD);
                }
            }

            for (int i = 0; i < queries.length; i++) {
                ans[i] = dp[queries[i][0]][queries[i][1]];
            }
            return ans;
        }

        private int calcMax(int n) {
            int i = 1;
            while (i <= n) {
                i *= 2;
            }
            return i / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals("[2, 4, 64]", Arrays.toString(solution.productQueries(15, new int[][]{{0, 1}, {2, 2}, {0, 3}})));
//            Assert.assertEquals("[2]", Arrays.toString(solution.productQueries(2, new int[][]{{0, 0}})));
            Assert.assertEquals("[147483634]", Arrays.toString(solution.productQueries(919, new int[][]{{0, 6}})));
        }

    }
}