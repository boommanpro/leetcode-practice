package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest125 {

    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPalindrome(String s) {
            if (s == null || "".equals(s)) {
                return true;
            }
            int i = 0, j = s.length() - 1;
            while (i < j) {
                while (isNotValidateSuccess(s.charAt(i)) && i < j) {
                    i++;
                }
                while (isNotValidateSuccess(s.charAt(j)) && i < j) {
                    j--;
                }
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        private boolean isNotValidateSuccess(Character c) {
            return !Character.isLetterOrDigit(c);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
            Assert.assertFalse(solution.isPalindrome("race a car"));
            Assert.assertTrue(solution.isPalindrome(";'"));
        }
    }
}