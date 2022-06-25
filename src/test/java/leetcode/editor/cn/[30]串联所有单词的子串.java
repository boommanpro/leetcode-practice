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
            int len = words[0].length();
            List<Integer> ans = new ArrayList<>();
            int size = words.length;
            int n = s.length();
            Map<String, Integer> dict = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)));
            for (int i = 0; i < len; i++) {
                int curr = 0;
                Map<String, Integer> window = new HashMap<>();
                int k = (n - i) / len;
                int l = 0;
                for (int j = 1; j <= k; j++) {
                    String str = s.substring(i + (j - 1) * len, i + j * len);
                    if (dict.containsKey(str)) {
                        while (window.getOrDefault(str, 0) >= dict.get(str)) {
                            String remove = s.substring(i + l * len, i + (l + 1) * len);
                            window.put(remove, window.get(remove) - 1);
                            curr--;
                            l++;
                        }
                        window.put(str, window.getOrDefault(str, 0) + 1);
                        curr++;
                    }else {
                        window.clear();
                        l = j ;
                        curr = 0;
                    }
                    if (size == curr) {
                        ans.add(i + l*len);
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
            List<Integer> result1 = solution.findSubstring("barfoothefoobarman", of("foo", "bar"));
            Assert.assertArrayEquals(of(0, 9), result1.toArray());


            List<Integer> result2 = solution.findSubstring("wordgoodgoodgoodbestword", of("word", "good", "best", "word"));
            Assert.assertArrayEquals(of(), result2.toArray());


            Assert.assertEquals("[6, 9, 12]",solution.findSubstring("barfoofoobarthefoobarman",new String[]{"bar","foo","the"}).toString());
            Assert.assertEquals("[8]",solution.findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}).toString());

        }

        private <T> T[] of(T... t) {
            return t;
        }
    }
}