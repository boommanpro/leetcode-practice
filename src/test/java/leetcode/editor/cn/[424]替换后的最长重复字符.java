package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest424 {
//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 266 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            if (k >= s.length() - 1 || s.length() <= 1) {
                return s.length();
            }
            int[] dict = new int[26];
            int left = 0;
            int ans = 1;
            int max = 0;
            for (int right = 0; right < s.length(); right++) {
                int p = s.charAt(right) - 'A';
                dict[p]++;
                max = Math.max(max, dict[p]);
                if (right - left + 1 - max <= k) {
                    ans = Math.max(ans, right - left + 1);
                } else {
                    dict[s.charAt(left) - 'A']--;
                    left++;
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
            Assert.assertEquals(4, solution.characterReplacement("ABAB", 2));
            Assert.assertEquals(4, solution.characterReplacement("AABABBA", 1));
            Assert.assertEquals(2, solution.characterReplacement("ABAA", 0));
        }
    }
}