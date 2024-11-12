package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3258 {
//给你一个 二进制 字符串 s 和一个整数 k。
//
// 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
//
//
// 字符串中 0 的数量最多为 k。
// 字符串中 1 的数量最多为 k。
//
//
// 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。
//
//
//
// 示例 1：
//
//
// 输入：s = "10101", k = 1
//
//
// 输出：12
//
// 解释：
//
// s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。
//
// 示例 2：
//
//
// 输入：s = "1010101", k = 2
//
//
// 输出：25
//
// 解释：
//
// s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。
//
// 示例 3：
//
//
// 输入：s = "11111", k = 1
//
//
// 输出：15
//
// 解释：
//
// s 的所有子字符串都满足 k 约束。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 50
// 1 <= k <= s.length
// s[i] 是 '0' 或 '1'。
//
//
// Related Topics字符串 | 滑动窗口
//
// 👍 36, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countKConstraintSubstrings(String s, int k) {
            int n = s.length();
            int ans = 0;
            char[] S = s.toCharArray();
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    ans += cnt(S, i, j, k);
                }
            }
            return ans;
        }

        private int cnt(char[] s, int i, int j, int k) {
            int[] sum = new int[2];
            for (int p = i; p <= j; p++) {
                int v = s[p] - '0';
                sum[v]++;
            }
            if (sum[0] <= k || sum[1] <= k) {
                return 1;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            String s1 = "10101";
            int k1 = 1;
            assertEquals(12, solution.countKConstraintSubstrings(s1, k1));

            String s2 = "1010101";
            int k2 = 2;
            assertEquals(25, solution.countKConstraintSubstrings(s2, k2));

            String s3 = "11111";
            int k3 = 1;
            assertEquals(15, solution.countKConstraintSubstrings(s3, k3));
        }
    }
}
