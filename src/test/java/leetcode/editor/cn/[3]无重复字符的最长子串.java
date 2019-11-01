package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest3 {

    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            //abcabcdb      4
            //12312343
            //abcdda
            int length = s.length();
            int[] dp = new int[length + 1];
            int maxLength = 0;
            Integer beforePosition;
            Map<Character, Integer> dictMap = new HashMap<>();
            char c;
            for (int i = 0; i < length; i++) {
                c = s.charAt(i);
                beforePosition = dictMap.get(c);
                if (beforePosition == null||i-beforePosition>dp[i]) {
                    dp[i + 1] = dp[i] + 1;
                    maxLength = Math.max(maxLength, dp[i + 1]);
                } else {
                    dp[i + 1] = i - beforePosition;
                }
                dictMap.put(c, i);
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
            Assert.assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
            Assert.assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
            Assert.assertEquals(4, solution.lengthOfLongestSubstring("abcddad"));
            Assert.assertEquals(5, solution.lengthOfLongestSubstring("tmmzuxt"));
        }
    }
}