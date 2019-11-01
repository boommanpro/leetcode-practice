package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest680 {
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 1 || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        //i++ j-- 最多一次机会
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (validSimplePalindrome(s.substring(i, j))) {
                    return true;
                }
               return validSimplePalindrome(s.substring(i+1, j+1));
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean validSimplePalindrome(String s) {
        int i=0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
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
            Assert.assertTrue(solution.validPalindrome("aba"));
            Assert.assertTrue(solution.validPalindrome("abca"));
        }
    }
}