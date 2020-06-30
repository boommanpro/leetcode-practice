package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题01_09 {
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
// Related Topics 字符串

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isFlipedString(String s1, String s2) {
            if (s1 == null && s2 == null) {
                return true;
            }
            if (s1 == null || s2 == null) {
                return false;
            }
            int m = s1.length();
            int n = s2.length();
            if (m != n) {
                return false;
            }
            if (m == 0) {
                return true;
            }
            char start = s1.charAt(0);
            int p = s2.indexOf(start);
            while (p >= 0) {
                if (isEquals(s1, s2, p, m)) {
                    return true;
                }
                p = s2.indexOf(start, p + 1);
            }
            return false;
        }

        private boolean isEquals(String s1, String s2, int r, int m) {
            for (int i = 0; i < m; i++) {
                r = r % m;
                if (s1.charAt(i) != s2.charAt(r)) {
                    return false;
                }
                r++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isFlipedString("waterbottle", "erbottlewat"));
            Assert.assertFalse(solution.isFlipedString("aa", "aba"));
            Assert.assertTrue(solution.isFlipedString("", ""));
            Assert.assertTrue(solution.isFlipedString("a", "a"));
            Assert.assertFalse(solution.isFlipedString("aba", "bab"));
        }
    }
}