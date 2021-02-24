package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest剑指Offer_48 {
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
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
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 151 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();
            int max = 0;
            for (int l = 0, r = 0; r < s.length(); r++) {
                char c = s.charAt(r);
                window.put(c, window.getOrDefault(c, 0) + 1);
                while (window.get(c) > 1) {
                    char temp = s.charAt(l);
                    window.put(temp, window.get(temp) - 1);
                    l++;
                }
                max = Math.max(max, r - l + 1);
            }
            return max;
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
            Assert.assertEquals(1, solution.lengthOfLongestSubstring(" "));
        }
    }
}