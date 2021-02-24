package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1456 {
//给你字符串 s 和整数 k 。 
//
// 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。 
//
// 英文中的 元音字母 为（a, e, i, o, u）。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abciiidef", k = 3
//输出：3
//解释：子字符串 "iii" 包含 3 个元音字母。
// 
//
// 示例 2： 
//
// 输入：s = "aeiou", k = 2
//输出：2
//解释：任意长度为 2 的子字符串都包含 2 个元音字母。
// 
//
// 示例 3： 
//
// 输入：s = "leetcode", k = 3
//输出：2
//解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
// 
//
// 示例 4： 
//
// 输入：s = "rhythms", k = 4
//输出：0
//解释：字符串 s 中不含任何元音字母。
// 
//
// 示例 5： 
//
// 输入：s = "tryhard", k = 4
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 由小写英文字母组成 
// 1 <= k <= s.length 
// 
// Related Topics 字符串 Sliding Window 
// 👍 15 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int maxVowels(String s, int k) {
            int cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += isVowels(s.charAt(i));
            }
            int ans = cnt;
            for (int i = k; i < s.length(); i++) {
                cnt += isVowels(s.charAt(i)) - isVowels(s.charAt(i - k));
                ans = Math.max(ans, cnt);
            }
            return ans;
        }

        private int isVowels(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.maxVowels("abciiidef", 3));
            Assert.assertEquals(2, solution.maxVowels("aeiou", 2));
            Assert.assertEquals(2, solution.maxVowels("leetcode", 3));
            Assert.assertEquals(0, solution.maxVowels("rhythms", 0));
            Assert.assertEquals(1, solution.maxVowels("tryhard", 4));
            Assert.assertEquals(7, solution.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
        }
    }
}