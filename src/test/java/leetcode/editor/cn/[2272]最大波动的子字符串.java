package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest2272 {
//字符串的 波动 定义为子字符串中出现次数 最多 的字符次数与出现次数 最少 的字符次数之差。 
//
// 给你一个字符串 s ，它只包含小写英文字母。请你返回 s 里所有 子字符串的 最大波动 值。 
//
// 子字符串 是一个字符串的一段连续字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aababbb"
//输出：3
//解释：
//所有可能的波动值和它们对应的子字符串如以下所示：
//- 波动值为 0 的子字符串："a" ，"aa" ，"ab" ，"abab" ，"aababb" ，"ba" ，"b" ，"bb" 和 "bbb" 。
//- 波动值为 1 的子字符串："aab" ，"aba" ，"abb" ，"aabab" ，"ababb" ，"aababbb" 和 "bab" 。
//- 波动值为 2 的子字符串："aaba" ，"ababbb" ，"abbb" 和 "babb" 。
//- 波动值为 3 的子字符串 "babbb" 。
//所以，最大可能波动值为 3 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcde"
//输出：0
//解释：
//s 中没有字母出现超过 1 次，所以 s 中每个子字符串的波动值都是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 只包含小写英文字母。 
// 
// Related Topics 数组 动态规划 👍 32 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestVariance(String s) {
            char[] array = new char[26];

            for (int i = 0; i < 26; i++) {
                array[i] = (char) (i + 'a');
            }
            int[] dict = new int[26];
            for (int i = 0; i < s.length(); i++) {
                dict[s.charAt(i) - 'a']++;
            }
            int ans = 0;
            for (char a : array) {
                for (char b : array) {
                    if (a == b) {
                        continue;
                    }
                    if (dict[a - 'a'] == 0 || dict[b - 'a'] == 0) {
                        continue;
                    }
                    int diff = 0;
                    int diffB = (int) -1e4;
                    for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (c == a) {
                            diff++;
                            diffB++;
                        } else if (c == b) {
                            diffB = --diff;
                            diff = Math.max(diff, 0);
                        }
                        ans = Math.max(ans, diffB);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.largestVariance("abbaa"));
            Assert.assertEquals(3, solution.largestVariance("babaaa"));
            Assert.assertEquals(3, solution.largestVariance("aababbb"));
            Assert.assertEquals(0, solution.largestVariance("abcde"));
        }

    }
}