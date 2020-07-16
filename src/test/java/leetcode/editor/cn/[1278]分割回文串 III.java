package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1278 {
//给你一个由小写字母组成的字符串 s，和一个整数 k。 
//
// 请你按下面的要求分割字符串： 
//
// 
// 首先，你可以将 s 中的部分字符修改为其他的小写英文字母。 
// 接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。 
// 
//
// 请返回以这种方式分割字符串所需修改的最少字符数。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abc", k = 2
//输出：1
//解释：你可以把字符串分割成 "ab" 和 "c"，并修改 "ab" 中的 1 个字符，将它变成回文串。
// 
//
// 示例 2： 
//
// 输入：s = "aabbc", k = 3
//输出：0
//解释：你可以把字符串分割成 "aa"、"bb" 和 "c"，它们都是回文串。 
//
// 示例 3： 
//
// 输入：s = "leetcode", k = 8
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= s.length <= 100 
// s 中只含有小写英文字母。 
// 
// Related Topics 动态规划 
// 👍 42 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int palindromePartition(String s, int k) {
            //首先第一部分算出s的每一段substring 变成回文需要修改多少字符串
            int n = s.length();
            int[][] pali = recoveryPalindrome(s, n);
            //k是分割成n个回文串
            int[][] dp = new int[k + 1][s.length() + 1];
            for (int i = 1; i <= k; i++) {
                for (int j = i; j <= s.length(); j++) {
                    if (i == 1) {
                        //如果是不拆分字符的话 相当于是 pali[0][j-1]
                        dp[i][j] = pali[0][j - 1];
                    } else {
                        //如果当前 i==2
                        //拆分成两个回文串时，前j个字符的结果为   第一次拆分的  第一个字符+后面的操作数
                        dp[i][j] = dp[i - 1][i - 1] + pali[i - 1][j - 1];
                        for (int x = i; x < j; x++)
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + pali[x][j - 1]);
                    }
                }
            }
            return dp[k][s.length()];
        }

        //判断字符串恢复需要的最小操作数
        private int[][] recoveryPalindrome(String s, int n) {
            int[][] palindrome = new int[n][n];
            for (int len = 1; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    if (len <= 3) {
                        if (s.charAt(i) == s.charAt(j)) {
                            palindrome[i][j] = 0;
                        } else {
                            palindrome[i][j] = 1;
                        }
                    } else {
                        if (s.charAt(i) == s.charAt(j)) {
                            palindrome[i][j] = palindrome[i + 1][j - 1];
                        } else {
                            palindrome[i][j] = palindrome[i + 1][j - 1] + 1;
                        }
                    }

                }
            }
            return palindrome;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.palindromePartition("abc", 2));
            Assert.assertEquals(0, solution.palindromePartition("aabbc", 3));
            Assert.assertEquals(0, solution.palindromePartition("leetcode", 8));
        }
    }
}