package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest392 {
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 示例 1: 
//s = "abc", t = "ahbgdc" 
//
// 返回 true. 
//
// 示例 2: 
//s = "axc", t = "ahbgdc" 
//
// 返回 false. 
//
// 后续挑战 : 
//
// 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码
//？ 
//
// 致谢: 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 217 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isSubsequence(String s, String t) {
            if (s == null || s.length() == 0) {
                return true;
            }
            int m = s.length();
            int n = t.length();
            int[] dp = new int[m];
            Arrays.fill(dp, -1);
            dp[0] = t.indexOf(s.charAt(0));
            for (int i = 1; i < m; i++) {
                if (dp[i - 1] == -1) {
                    return false;
                }
                for (int j = dp[i - 1] + 1; j < n; j++) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i] = j;
                        break;
                    }
                }
            }
            return dp[m - 1] != -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isSubsequence("a", "ahbgdc"));
            Assert.assertTrue(solution.isSubsequence("", "ahbgdc"));
            Assert.assertTrue(solution.isSubsequence("abc", "ahbgdc"));
            Assert.assertFalse(solution.isSubsequence("axc", "ahbgdc"));
        }
    }
}