package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest97 {
//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。 
//
// 示例 1: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出: false 
// Related Topics 字符串 动态规划 
// 👍 283 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();
            int x = s3.length();
            if (m + n != x) {
                return false;
            }
            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int p = i + j - 1;
                    if (i > 0) {
                        f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                    }
                    if (j > 0) {
                        f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
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
            Assert.assertTrue(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
            Assert.assertFalse(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        }
    }
}