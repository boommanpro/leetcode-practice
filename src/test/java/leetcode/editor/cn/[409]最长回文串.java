package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest409 {
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            Map<Character, Integer> dict = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }
            int sum = 0;
            boolean existSingle = false;
            for (Integer value : dict.values()) {
                if (value % 2 == 0) {
                    sum += value;
                }else {
                    sum += value - 1;
                    existSingle = true;
                }
            }
            return existSingle ? sum + 1 : sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.longestPalindrome("abccccdd"));
        }
    }
}