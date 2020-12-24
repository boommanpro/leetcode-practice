package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest438 {
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 434 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findAnagrams(String s, String p) {
            int[] dict = new int[26];
            int[] window = new int[26];
            List<Integer> ans = new ArrayList<>();
            for (char c : p.toCharArray()) {
                dict[c - 'a']++;
            }
            int l = 0, r = 0;
            while (r < s.length()) {
                int curr = s.charAt(r) - 'a';
                window[curr]++;
                r++;
                while (window[curr] > dict[curr]) {
                    int prev = s.charAt(l) - 'a';
                    window[prev]--;
                    l++;
                }
                if (r - l == p.length()) {
                    ans.add(l);
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
            Assert.assertEquals("[0, 6]", solution.findAnagrams("cbaebabacd", "abc").toString());
            Assert.assertEquals("[0, 1, 2]", solution.findAnagrams("abab", "ab").toString());
            Assert.assertEquals("[2, 3, 4]", solution.findAnagrams("acabab", "ab").toString());
        }
    }
}