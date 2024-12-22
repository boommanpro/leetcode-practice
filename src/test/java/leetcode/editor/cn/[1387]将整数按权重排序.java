package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class SolutionTest1387 {
//我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
//
//
// 如果 x 是偶数，那么 x = x / 2
// 如果 x 是奇数，那么 x = 3 * x + 1
//
//
// 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 -->
//1）。
//
// 给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，
//那么按照数字自身的数值 升序排序 。
//
// 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
//
// 注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
//
//
//
// 示例 1：
//
//
//输入：lo = 12, hi = 15, k = 2
//输出：13
//解释：12 的权重为 9（12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）
//13 的权重为 9
//14 的权重为 17
//15 的权重为 17
//区间内的数按权重排序以后的结果为 [12,13,14,15] 。对于 k = 2 ，答案是第二个整数也就是 13 。
//注意，12 和 13 有相同的权重，所以我们按照它们本身升序排序。14 和 15 同理。
//
//
// 示例 2：
//
//
//输入：lo = 7, hi = 11, k = 4
//输出：7
//解释：区间内整数 [7, 8, 9, 10, 11] 对应的权重为 [16, 3, 19, 6, 14] 。
//按权重排序后得到的结果为 [8, 10, 11, 7, 9] 。
//排序后数组中第 4 个数字为 7 。
//
//
//
//
// 提示：
//
//
// 1 <= lo <= hi <= 1000
// 1 <= k <= hi - lo + 1
//
//
// Related Topics记忆化搜索 | 动态规划 | 排序
//
// 👍 86, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getKth(int lo, int hi, int k) {
            List<int[]> v = new ArrayList<>();
            for (int i = lo; i <= hi; i++) {
                v.add(new int[]{i, getWeight(i)});
            }
            v.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            return v.get(k - 1)[0];
        }

        private int getWeight(int i) {
            int ans = 0;
            while (i != 1) {
                if (i % 2 == 0) {
                    i = i / 2;
                } else {
                    i = 3 * i + 1;
                }
                ans++;
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
            // 默认测试用例
            assertEquals(13, solution.getKth(12, 15, 2));
            assertEquals(7, solution.getKth(7, 11, 4));
        }

        @Test
        public void singleElementTest() {
            // 区间内只有一个元素
            assertEquals(1, solution.getKth(1, 1, 1));
        }

        @Test
        public void consecutiveElementsTest() {
            // 连续的两个元素
            assertEquals(2, solution.getKth(2, 3, 1));
        }


        @Test
        public void edgeCaseTest() {
            // 边界情况测试
            assertEquals(1000, solution.getKth(1000, 1000, 1));
        }
    }
}
