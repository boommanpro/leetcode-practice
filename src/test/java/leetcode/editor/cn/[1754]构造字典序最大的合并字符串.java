package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1754 {
//给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，选择 下面选项之一 继
//续操作： 
//
// 
// 如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。 
// 
//
// 
// 例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva" 。 
//
// 
// 
// 如果 word2 非空，将 word2 中的第一个字符附加到 merge 的末尾，并将其从 word2 中移除。
// 
// 例如，word2 = "abc" 且 merge = "" ，在执行此选项操作之后，word2 = "bc" ，同时 merge = "a" 。 
// 
// 
//
//
// 返回你可以构造的字典序 最大 的合并字符串 merge 。 
//
// 长度相同的两个字符串 a 和 b 比较字典序大小，如果在 a 和 b 出现不同的第一个位置，a 中字符在字母表中的出现顺序位于 b 中相应字符之后，就认为
//字符串 a 按字典序比字符串 b 更大。例如，"abcd" 按字典序比 "abcc" 更大，因为两个字符串出现不同的第一个位置是第四个字符，而 d 在字母表中的
//出现顺序位于 c 之后。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "cabaa", word2 = "bcaaa"
//输出："cbcabaaaaa"
//解释：构造字典序最大的合并字符串，可行的一种方法如下所示：
//- 从 word1 中取第一个字符：merge = "c"，word1 = "abaa"，word2 = "bcaaa"
//- 从 word2 中取第一个字符：merge = "cb"，word1 = "abaa"，word2 = "caaa"
//- 从 word2 中取第一个字符：merge = "cbc"，word1 = "abaa"，word2 = "aaa"
//- 从 word1 中取第一个字符：merge = "cbca"，word1 = "baa"，word2 = "aaa"
//- 从 word1 中取第一个字符：merge = "cbcab"，word1 = "aa"，word2 = "aaa"
//- 将 word1 和 word2 中剩下的 5 个 a 附加到 merge 的末尾。
// 
//
// 示例 2： 
//
// 
//输入：word1 = "abcabc", word2 = "abdcaba"
//输出："abdcabcabcaba"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 3000 
// word1 和 word2 仅由小写英文组成 
// 
//
// Related Topics 贪心 双指针 字符串 👍 42 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestMerge(String word1, String word2) {
            int i = 0;
            int j = 0;
            int n = word1.length();
            int m = word2.length();
            StringBuilder ans = new StringBuilder();
            while (i < n && j < m) {
                if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                    ans.append(word1.charAt(i++));
                } else {
                    ans.append(word2.charAt(j++));
                }
            }
            ans.append(word1.substring(i));
            ans.append(word2.substring(j));
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("cbcabaaaaa", solution.largestMerge("cabaa", "bcaaa"));
            Assert.assertEquals("abdcabcabcaba", solution.largestMerge("abcabc", "abdcaba"));
        }

    }
}