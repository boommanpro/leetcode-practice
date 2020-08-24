package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest459 {
//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 
// 👍 272 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            //判断是否是存在单个字符
            int n = s.length();
            int multiple = 2;
            while (multiple <= n) {
                if (n % multiple == 0) {
                    //子串长度
                    int len = n / multiple;
                    int i;
                    for (i = len; i < n; i++) {
                        if (s.charAt(i) != s.charAt(i % len)) {
                            break;

                        }
                    }
                    if (i == n) {
                        return true;
                    }
                }
                multiple++;
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.repeatedSubstringPattern("abab"));
            Assert.assertFalse(solution.repeatedSubstringPattern("aba"));
            Assert.assertTrue(solution.repeatedSubstringPattern("abcabcabcabc"));
            Assert.assertFalse(solution.repeatedSubstringPattern("abccba"));
            Assert.assertTrue(solution.repeatedSubstringPattern("bb"));
        }
    }
}