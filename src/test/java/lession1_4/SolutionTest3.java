package lession1_4;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
            if (s == null || s.length() == 0) {
                return 0;
            }
            int length = s.length();
            //定义窗口 开始位置 结束位置 长度
            int[] window = new int[]{0, 0, 1};
            Map<Character, Integer> dict = new HashMap<>();
            dict.put(s.charAt(0), 0);
            while (window[1] + 1 < length) {
                window[1]++;
                //滑动起来
                if (dict.containsKey(s.charAt(window[1]))) {
                    if (dict.get(s.charAt(window[1])) >= window[0]) {
                        window[0] = dict.get(s.charAt(window[1])) + 1;
                    }
                }
                dict.put(s.charAt(window[1]), window[1]);
                calcLength(window);
            }
            return window[2];
        }

        private void calcLength(int[] window) {
            if (window[1] - window[0] >= window[2]) {
                window[2] = window[1] - window[0] + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals(1, solution.lengthOfLongestSubstring("a"));
            Assert.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
            Assert.assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
            Assert.assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
            Assert.assertEquals(4, solution.lengthOfLongestSubstring("abcddad"));
            Assert.assertEquals(5, solution.lengthOfLongestSubstring("tmmzuxt"));
        }
    }
}