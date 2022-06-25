package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest30 {
    //给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串
    public static


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            Map<String, Long> dict = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<String, Long> window = new HashMap<>();
            List<Integer> ans = new ArrayList<>();
            int sum = dict.values().stream().mapToInt(Long::intValue).sum();
            int max = dict.keySet().stream().mapToInt(String::length).max().getAsInt();
            for (int i = 0; i < s.length(); i++) {
                window.clear();
                if (dfs(s, i, "", dict, window,0, sum, max)) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private boolean dfs(String s, int i, String current, Map<String, Long> dict, Map<String, Long> window,int currentSize, int sum, int max) {
            if (currentSize == sum) {
                return true;
            }
            if (i == s.length()) {
                return false;
            }
            if (current.length() > max) {
                return false;
            }
            current += s.charAt(i);
            if (dict.containsKey(current) && window.getOrDefault(current, 0L) < dict.get(current)) {
                window.put(current, window.getOrDefault(current, 0L) + 1);
                if (dfs(s, i + 1, "", dict, window, currentSize + 1, sum, max)) {
                    return true;
                }
                window.put(current, window.get(current) - 1);
            }
            return dfs(s, i + 1, current, dict, window, currentSize, sum, max);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            List<Integer> result1 = solution.findSubstring("barfoothefoobarman", of("foo", "bar"));
            Assert.assertArrayEquals(of(0, 9), result1.toArray());


            List<Integer> result2 = solution.findSubstring("wordgoodgoodgoodbestword", of("word", "good", "best", "word"));
            Assert.assertArrayEquals(of(), result2.toArray());

        }

        private <T> T[] of(T... t) {
            return t;
        }
    }
}