package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest1014 {
//给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
//
// 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离
//。
//
// 返回一对观光景点能取得的最高分。
//
//
//
// 示例 1：
//
//
//输入：values = [8,1,5,2,6]
//输出：11
//解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
//
//
// 示例 2：
//
//
//输入：values = [1,2]
//输出：2
//
//
//
//
// 提示：
//
//
// 2 <= values.length <= 5 * 10⁴
// 1 <= values[i] <= 1000
//
//
// Related Topics数组 | 动态规划
//
// 👍 448, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int n = values.length;
            int mx = values[0];
            int ans = 0;
            for (int j = 1; j < n; j++) {
                ans = Math.max(ans, mx + values[j] - j);
                mx = Math.max(mx, values[j] + j);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testMaxScoreSightseeingPairExample1() {
            int[] values = {8, 1, 5, 2, 6};
            assertEquals(11, solution.maxScoreSightseeingPair(values));
        }

        @Test
        public void testMaxScoreSightseeingPairExample2() {
            int[] values = {1, 2};
            assertEquals(2, solution.maxScoreSightseeingPair(values));
        }

        @Test
        public void testMaxScoreSightseeingPairSingleElement() {
            int[] values = {10};
            assertEquals(0, solution.maxScoreSightseeingPair(values));
        }
    }
}
