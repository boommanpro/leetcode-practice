package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest318 {
//给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母
//。如果不存在这样的两个单词，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出：16
//解释：这两个单词为 "abcw", "xtfn"。
//
// 示例 2：
//
//
//输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
//输出：4
//解释：这两个单词为 "ab", "cd"。
//
// 示例 3：
//
//
//输入：words = ["a","aa","aaa","aaaa"]
//输出：0
//解释：不存在这样的两个单词。
//
//
//
//
// 提示：
//
//
// 2 <= words.length <= 1000
// 1 <= words[i].length <= 1000
// words[i] 仅包含小写字母
//
//
// Related Topics位运算 | 数组 | 字符串
//
// 👍 488, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxProduct(String[] words) {
            List<Integer> list = new ArrayList<>();
            for (String word : words) {
                int curr = 0;
                for (char c : word.toCharArray()) {
                    curr |= 1 << (c - 'a');
                }
                list.add(curr);
            }
            int ans = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if ((list.get(i) & list.get(j)) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
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
            Assert.assertEquals(16,solution.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
            Assert.assertEquals(4,solution.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
            Assert.assertEquals(0, solution.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
        }

    }
}
