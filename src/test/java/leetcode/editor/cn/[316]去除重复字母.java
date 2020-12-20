package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest316 {
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 361 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            int[] count = new int[26];
            boolean[] visited = new boolean[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                int p = ch - 'a';
                if (!visited[p]) {
                    while (ans.length() > 0 && ans.charAt(ans.length() - 1) > ch) {
                        if (count[ans.charAt(ans.length() - 1)-'a'] > 0) {
                            visited[ans.charAt(ans.length() - 1)-'a'] = false;
                            ans.deleteCharAt(ans.length() - 1);
                            continue;
                        }
                        break;
                    }
                    ans.append(ch);
                    visited[p] = true;
                }
                count[p]--;
            }

            return ans.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("abc",solution.removeDuplicateLetters("bcabc"));
            Assert.assertEquals("acdb",solution.removeDuplicateLetters("cbacdcbc"));
            Assert.assertEquals("bca",solution.removeDuplicateLetters("bcaab"));
        }
    }
}