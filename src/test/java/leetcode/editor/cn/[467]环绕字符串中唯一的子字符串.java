package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest467 {
//把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklm
//nopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
//
// 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同
//的非空子串的数目。 
//
// 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。 
//
// 
//
// 示例 1: 
//
// 
//输入: "a"
//输出: 1
//解释: 字符串 S 中只有一个"a"子字符。
// 
//
// 
//
// 示例 2: 
//
// 
//输入: "cac"
//输出: 2
//解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
// 
//
// 
//
// 示例 3: 
//
// 
//输入: "zab"
//输出: 6
//解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
// 
//
// 
// Related Topics 动态规划 
// 👍 127 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findSubstringInWraproundString(String p) {
            int[] dp = new int[26];
            int cnt = 1, n = p.length();
            char[] cs = (" " + p).toCharArray();
            for (int i = 1; i <= n; i++) {
                int idx = cs[i] - 'a';
                if (check(cs[i - 1], cs[i])) cnt++;
                else cnt = 1;
                dp[idx] = Math.max(dp[idx], cnt);
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) ans += dp[i];
            return ans;
        }

        public boolean check(char a, char b) {
            if (a == 'z' && b == 'a') return true;
            return b - a == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.findSubstringInWraproundString("a"));
            Assert.assertEquals(2, solution.findSubstringInWraproundString("cac"));
            Assert.assertEquals(6, solution.findSubstringInWraproundString("zab"));
        }
    }
}