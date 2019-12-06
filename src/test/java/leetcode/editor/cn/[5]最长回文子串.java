package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest5 {

    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1));
                if (len > end - start+1) {
                    start = i- (len-1)/2;
                    end = i + len / 2;
                }

            }
            return s.substring(start, end + 1);
        }
        /**
         * 扩展中心
         *
         * @param s     字符串s
         * @param left  左边界
         * @param right 边界
         * @return 中心点
         */
        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            String babad = solution.longestPalindrome("babad");
//            Assert.assertTrue("bab".equals(babad) || "aba".equals(babad));
            Assert.assertEquals("bb", solution.longestPalindrome("cbbd"));

            System.out.println(solution.longestPalindrome("ab"));
            System.out.println(solution.longestPalindrome("abca"));
            System.out.println(solution.longestPalindrome("ccabacd"));
        }
    }
}