package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest140 {
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法 
// 👍 345 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> wordBreak(String s, List<String> wordDict) {
            Map<Integer, List<List<String>>> map = new HashMap<>();
            List<List<String>> ans = backTacking(s, s.length(), 0, new HashSet<>(wordDict), map);
            return ans.stream().map(w -> String.join(" ", w)).collect(Collectors.toList());
        }

        private List<List<String>> backTacking(String select, int len, int idx, HashSet<String> dict, Map<Integer, List<List<String>>> map) {
            if (!map.containsKey(idx)) {
                List<List<String>> ans = new ArrayList<>();
                if (idx == len) {
                    ans.add(new ArrayList<>());
                }
                for (int i = idx + 1; i <= len; i++) {
                    String curr = select.substring(idx, i);
                    if (dict.contains(curr)) {
                        List<List<String>> nextList = backTacking(select, len, i, dict, map);
                        for (List<String> next : nextList) {
                            List<String> sub = new ArrayList<>();
                            sub.add(curr);
                            sub.addAll(next);
                            ans.add(sub);
                        }
                    }
                }
                map.put(idx, ans);
            }
            return map.get(idx);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[cat sand dog, cats and dog]", solution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")).toString());
            Assert.assertEquals("[pine apple pen apple, pine applepen apple, pineapple pen apple]", solution.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")).toString());
            Assert.assertEquals("[]", solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")).toString());
        }
    }
}