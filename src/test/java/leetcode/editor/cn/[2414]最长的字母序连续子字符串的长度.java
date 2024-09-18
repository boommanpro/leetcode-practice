package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest2414 {
//字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连
//续字符串 。
//
//
// 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
//
//
// 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
//
//
//
// 示例 1：
//
// 输入：s = "abacaba"
//输出：2
//解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
//"ab" 是最长的字母序连续子字符串。
//
//
// 示例 2：
//
// 输入：s = "abcde"
//输出：5
//解释："abcde" 是最长的字母序连续子字符串。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 由小写英文字母组成
//
//
// Related Topics字符串
//
// 👍 17, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestContinuousSubstring(String s) {
            int n = s.length();
            int ans = 1;
            int len = 1;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) - s.charAt(i - 1) == 1) {
                    len++;
                }else {
                    len = 1;
                }
                ans = Math.max(ans, len);
            }
            return ans;
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
        public void testLongestContinuousSubstringExample1() {
            String s = "abacaba";
            assertEquals(2, solution.longestContinuousSubstring(s));
        }

        @Test
        public void testLongestContinuousSubstringExample2() {
            String s = "abcde";
            assertEquals(5, solution.longestContinuousSubstring(s));
        }

        @Test
        public void testLongestContinuousSubstringSingleChar() {
            String s = "a";
            assertEquals(1, solution.longestContinuousSubstring(s));
        }

    }
}
