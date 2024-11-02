package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3226 {
//给你两个正整数 n 和 k。
//
// 你可以选择 n 的 二进制表示 中任意一个值为 1 的位，并将其改为 0。
//
// 返回使得 n 等于 k 所需要的更改次数。如果无法实现，返回 -1。
//
//
//
// 示例 1：
//
//
// 输入： n = 13, k = 4
//
//
// 输出： 2
//
// 解释： 最初，n 和 k 的二进制表示分别为 n = (1101)2 和 k = (0100)2，
//
// 我们可以改变 n 的第一位和第四位。结果整数为 n = (0100)2 = k。
//
// 示例 2：
//
//
// 输入： n = 21, k = 21
//
//
// 输出： 0
//
// 解释： n 和 k 已经相等，因此不需要更改。
//
// 示例 3：
//
//
// 输入： n = 14, k = 13
//
//
// 输出： -1
//
// 解释： 无法使 n 等于 k。
//
//
//
// 提示：
//
//
// 1 <= n, k <= 10⁶
//
//
// Related Topics位运算
//
// 👍 26, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minChanges(int n, int k) {
            if (k > n) {
                return -1;
            }
            String s1 = Integer.toBinaryString(n);
            String s2 = Integer.toBinaryString(k);
            int cnt = 0;
            int len = Math.max(s1.length(), s2.length());
            for (int i = 0; i < len; i++) {
                int v1 = getV(s1, i);
                int v2 = getV(s2, i);
                if (v2 == 1 && v1 == 0) {
                    return -1;
                }
                cnt += v1 - v2;
            }
            return cnt;
        }

        private int getV(String s1, int i) {
            if (s1.length() <= i) {
                return 0;
            }
            return s1.charAt(s1.length() - 1 - i) - '0';
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
        public void testEqualNumbers() {
            assertEquals(0, solution.minChanges(21, 21));
        }

        @Test
        public void testConvertibleNumbers() {
            assertEquals(2, solution.minChanges(13, 4));
        }

        @Test
        public void testUnconvertibleNumbers() {
            assertEquals(-1, solution.minChanges(14, 13));
        }

        @Test
        public void testUnconvertibleNumbers1() {
            assertEquals(-1, solution.minChanges(44, 2));
        }
    }
}
