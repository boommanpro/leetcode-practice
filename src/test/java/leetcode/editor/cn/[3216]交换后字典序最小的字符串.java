package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3216 {
//给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的字典序最小的字符串。
//
// 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
//
//
//
// 示例 1：
//
//
// 输入： s = "45320"
//
//
// 输出： "43520"
//
// 解释：
//
// s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。
//
// 示例 2：
//
//
// 输入： s = "001"
//
//
// 输出： "001"
//
// 解释：
//
// 无需进行交换，因为 s 已经是字典序最小的。
//
//
//
// 提示：
//
//
// 2 <= s.length <= 100
// s 仅由数字组成。
//
//
// Related Topics贪心 | 字符串
//
// 👍 23, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getSmallestString(String s) {
            int n = s.length();
            char[] S = s.toCharArray();
            for (int i = 1; i < n; i++) {
                int x = S[i - 1] - '0';
                int y = S[i] - '0';
                if (x > y && x % 2 == y % 2) {
                    S[i - 1] = (char) (y + '0');
                    S[i] = (char) (x + '0');
                    break;
                }
            }
            return new String(S);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void testGetSmallestString() {
            // 示例用例
            assertEquals("43520", solution.getSmallestString("45320"));
            assertEquals("001", solution.getSmallestString("001"));

            // 额外测试用例

            // 测试相同数字
            assertEquals("111", solution.getSmallestString("111"));
            // 测试没有可交换的情况
            assertEquals("12345", solution.getSmallestString("12345"));
        }
    }
}
