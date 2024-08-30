package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3153 {
//你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
//
// 两个整数的 数位差 指的是两个整数 相同 位置上不同数字的数目。
//
// 请你返回 nums 中 所有 整数对里，数位差之和。
//
//
//
// 示例 1：
//
//
// 输入：nums = [13,23,12]
//
//
// 输出：4
//
// 解释： 计算过程如下： - 13 和 23 的数位差为 1 。 - 13 和 12 的数位差为 1 。 - 23 和 12 的数位差为 2 。 所以所有整
//数数对的数位差之和为 1 + 1 + 2 = 4 。
//
// 示例 2：
//
//
// 输入：nums = [10,10,10,10]
//
//
// 输出：0
//
// 解释： 数组中所有整数都相同，所以所有整数数对的数位不同之和为 0 。
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 10⁵
// 1 <= nums[i] < 10⁹
// nums 中的整数都有相同的数位长度。
//
//
// Related Topics数组 | 哈希表 | 数学 | 计数
//
// 👍 46, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long sumDigitDifferences(int[] nums) {
            int len = String.valueOf(nums[0]).length();
            int[][] cnt = new int[len][10];
            for (int num : nums) {
                int i = 0;
                while (num > 0) {
                    cnt[i][num % 10]++;
                    num /= 10;
                    i++;
                }

            }
            long sum = 0;
            for (int p = 0; p < len; p++) {
                for (int i = 0; i < 10; i++) {
                    for (int j = i + 1; j < 10; j++) {
                        sum += (long) cnt[p][i] * cnt[p][j];
                    }
                }
            }
            return sum;
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
        public void testSumDigitDifferences1() {
            int[] nums = {13, 23, 12};
            long expected = 4;
            assertEquals(expected, solution.sumDigitDifferences(nums));
        }

        @Test
        public void testSumDigitDifferences2() {
            int[] nums = {10, 10, 10, 10};
            long expected = 0;
            assertEquals(expected, solution.sumDigitDifferences(nums));
        }

        @Test
        public void testSumDigitDifferences3() {
            int[] nums = {111, 121, 112};
            long expected = 4;
            assertEquals(expected, solution.sumDigitDifferences(nums));
        }

        @Test
        public void testSumDigitDifferences4() {
            int[] nums = {50, 28, 48};
            long expected = 5;
            assertEquals(expected, solution.sumDigitDifferences(nums));
        }

    }
}
