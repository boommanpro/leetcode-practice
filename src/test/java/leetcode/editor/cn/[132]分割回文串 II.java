package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest132 {
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的最少分割次数。 
//
// 示例: 
//
// 输入: "aab"
//输出: 1
//解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
// Related Topics 动态规划

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minCut(String s) {
            int n = s.length();
            boolean[][] checkPalindrome = new boolean[n][n];
            for (int len = 1; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    checkPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || checkPalindrome[i + 1][j - 1]);
                }
            }
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = i;
            }
            for (int i = 1; i < n; i++) {
                if (checkPalindrome[0][i]) {
                    dp[i] = 0;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (checkPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[j] + 1, dp[i]);
                    }
                }
            }
            return dp[n - 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.minCut("aab"));
            Assert.assertEquals(0, solution.minCut("aaaa"));
            Assert.assertEquals(0, solution.minCut("aba"));
            Assert.assertEquals(0, solution.minCut("ababababababababababababcbabababababababababababa"));

        }
    }
}