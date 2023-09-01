package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest2240 {
//给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。你可以花费你部分或者全部的
//钱，去买任意数目的两种笔。
//
// 请你返回购买钢笔和铅笔的 不同方案数目 。
//
//
//
// 示例 1：
//
// 输入：total = 20, cost1 = 10, cost2 = 5
//输出：9
//解释：一支钢笔的价格为 10 ，一支铅笔的价格为 5 。
//- 如果你买 0 支钢笔，那么你可以买 0 ，1 ，2 ，3 或者 4 支铅笔。
//- 如果你买 1 支钢笔，那么你可以买 0 ，1 或者 2 支铅笔。
//- 如果你买 2 支钢笔，那么你没法买任何铅笔。
//所以买钢笔和铅笔的总方案数为 5 + 3 + 1 = 9 种。
//
//
// 示例 2：
//
// 输入：total = 5, cost1 = 10, cost2 = 10
//输出：1
//解释：钢笔和铅笔的价格都为 10 ，都比拥有的钱数多，所以你没法购买任何文具。所以只有 1 种方案：买 0 支钢笔和 0 支铅笔。
//
//
//
//
// 提示：
//
//
// 1 <= total, cost1, cost2 <= 10⁶
//
//
// Related Topics数学 | 枚举
//
// 👍 28, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            long ans = 0;
            for (int i = 0; i <= total / cost1; i++) {
                ans += (total - (long) i * cost1) / cost2 + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(9, solution.waysToBuyPensPencils(20, 10, 5));
            Assert.assertEquals(1, solution.waysToBuyPensPencils(5, 10, 10));
            Assert.assertEquals(500001500001L, solution.waysToBuyPensPencils(1000000, 1, 1));
        }

    }
}
