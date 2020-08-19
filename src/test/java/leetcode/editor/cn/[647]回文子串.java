package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest647 {
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 319 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int count = 0;
            int n = s.length();
            boolean[][] f = new boolean[n][n];
            for (int len = 1; len <= n; len++) {
                for (int l = 0; l < n - len + 1; l++) {
                    int r = l + len - 1;
                    if (isPalindrome(s, l, r, f)) {
                        f[l][r] = true;
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isPalindrome(String s, int l, int r, boolean[][] f) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            if (r - l < 3) {
                return true;
            }
            return f[l + 1][r - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.countSubstrings("abc"));
            Assert.assertEquals(6, solution.countSubstrings("aaa"));
        }
    }
}