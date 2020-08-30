package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest712 {
//给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。 
//
// 示例 1: 
//
// 
//输入: s1 = "sea", s2 = "eat"
//输出: 231
//解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
//在 "eat" 中删除 "t" 并将 116 加入总和。
//结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
// 
//
// 示例 2: 
//
// 
//输入: s1 = "delete", s2 = "leet"
//输出: 403
//解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
//将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
//结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
//如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
// 
//
// 注意: 
//
// 
// 0 < s1.length, s2.length <= 1000。 
// 所有字符串中的字符ASCII值在[97, 122]之间。 
// 
// Related Topics 动态规划 
// 👍 147 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            int[][] f = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                f[i][0] = f[i - 1][0] + s1.codePointAt(i - 1);
            }
            for (int i = 1; i <= n; i++) {
                f[0][i] = f[0][i - 1] + s2.codePointAt(i - 1);
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        f[i][j] = f[i - 1][j - 1];
                    } else {
                        f[i][j] = Math.min(f[i - 1][j] + s1.codePointAt(i - 1), f[i][j - 1] + s2.codePointAt(j - 1));
                    }
                }
            }
            return f[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(231, solution.minimumDeleteSum("sea", "eat"));
            Assert.assertEquals(403, solution.minimumDeleteSum("delete", "leet"));
        }
    }
}