package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

class SolutionTest139 {
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 640 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.isEmpty()) {
                return false;
            }
            //单词能否被字典完美拆分
            return dfs(s, 0, wordDict);
        }

        public boolean dfs(String s, int i, List<String> wordDict) {
            for (String dict : wordDict) {
                int p = compare(s, i, dict);
                if (p == -1) {
                    continue;
                }
                if (p == s.length()) {
                    return true;
                }
                if (dfs(s, p, wordDict)) {
                    return true;
                }
            }
            return false;
        }

        private int compare(String s, int i, String dict) {
            int n = dict.length();
            if (n > s.length() - i) {
                return -1;
            }
            for (int p = 0; p < n; p++) {
                if (dict.charAt(p) != s.charAt(i + p)) {
                    return -1;
                }
            }
            return i + dict.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
            Assert.assertTrue(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
            Assert.assertFalse(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
            Assert.assertFalse(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
        }
    }
}