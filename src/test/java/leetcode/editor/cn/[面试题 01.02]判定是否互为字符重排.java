package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题01_02 {
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean CheckPermutation(String s1, String s2) {
            if (s1 == null && s2 == null) {
                return true;
            }
            if (s1 == null || s2 == null) {
                return false;
            }
            if (s1.length() != s2.length()) {
                return false;
            }
            Map<Character, Integer> dict = new HashMap<>();
            for (char c : s1.toCharArray()) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }
            for (char c : s2.toCharArray()) {
                Integer count = dict.get(c);
                if (count == null) {
                    return false;
                }
                if (count == 0) {
                    return false;
                }
                dict.put(c, count - 1);
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
            Assert.assertTrue(solution.CheckPermutation("abc", "bca"));
            Assert.assertFalse(solution.CheckPermutation("abc", "bad"));
        }
    }
}