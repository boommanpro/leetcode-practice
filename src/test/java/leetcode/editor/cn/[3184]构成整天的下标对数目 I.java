package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3184 {
//给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标
//对 i, j 的数目。
//
// 整天 定义为时间持续时间是 24 小时的 整数倍 。
//
// 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
//
//
//
// 示例 1：
//
//
// 输入： hours = [12,12,30,24,24]
//
//
// 输出： 2
//
// 解释：
//
// 构成整天的下标对分别是 (0, 1) 和 (3, 4)。
//
// 示例 2：
//
//
// 输入： hours = [72,48,24,3]
//
//
// 输出： 3
//
// 解释：
//
// 构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。
//
//
//
// 提示：
//
//
// 1 <= hours.length <= 100
// 1 <= hours[i] <= 10⁹
//
//
// Related Topics数组 | 哈希表 | 计数
//
// 👍 24, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCompleteDayPairs(int[] hours) {
            int n = hours.length;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if ((hours[i] + hours[j]) % 24 == 0) {
                        count++;
                    }
                }
            }
            return count;
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
        public void testDefault() {
            int[] hours = {12, 12, 30, 24, 24};
            assertEquals(2, solution.countCompleteDayPairs(hours));
        }

        @Test
        public void testAllPairs() {
            int[] hours = {24, 24, 24};
            assertEquals(3, solution.countCompleteDayPairs(hours));
        }

    }
}
