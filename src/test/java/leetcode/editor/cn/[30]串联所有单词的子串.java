package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
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
            if (s == null || s.isEmpty() || words == null || words.length == 0) {
                return new ArrayList<>();
            }
            Map<String, Integer> dictMap = new HashMap<>();
            for (String word : words) {
                dictMap.put(word, dictMap.getOrDefault(word, 0) + 1);
            }

            Map<String, Integer> window = new HashMap<>();
            int required = dictMap.size();
            int currentSize = 0;

            int wordLength = words[0].length();
            //  s = "barfoothefoobarman",
            //  words = ["foo","bar"]
            List<Integer> result = new ArrayList<>();


            int i = 0, j = wordLength;
            String currStr;
            //什么时候i++   1.第一个字符在dict中时  2.找到了一个满足条件的
            while (j <= s.length()) {
                currStr = s.substring(j-wordLength, j);
                window.put(currStr, window.getOrDefault(currStr, 0) + 1);
                //如果dict包含的话,继续向后
                if (dictMap.containsKey(currStr) && dictMap.get(currStr).equals(window.get(currStr))) {
                    currentSize++;
                    j += wordLength;
                    if (currentSize == required) {
                        result.add(i);
                        i++;
                        j = i + wordLength;
                        currentSize = 0;
                        window.clear();
                    }
                } else if (dictMap.containsKey(currStr) && dictMap.get(currStr).compareTo(window.get(currStr)) > 0) {
                    j += wordLength;
                } else {
                    i++;
                    j = i + wordLength;
                    currentSize = 0;
                    window.clear();
                }
            }


            return result;
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