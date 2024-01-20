package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class SolutionTest2788 {
//给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。
//
// 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。
//
// 注意
//
//
// separator 用于决定拆分发生的位置，但它不包含在结果字符串中。
// 拆分可能形成两个以上的字符串。
// 结果字符串必须保持初始相同的先后顺序。
//
//
//
//
// 示例 1：
//
//
//输入：words = ["one.two.three","four.five","six"], separator = "."
//输出：["one","two","three","four","five","six"]
//解释：在本示例中，我们进行下述拆分：
//
//"one.two.three" 拆分为 "one", "two", "three"
//"four.five" 拆分为 "four", "five"
//"six" 拆分为 "six"
//
//因此，结果数组为 ["one","two","three","four","five","six"] 。
//
// 示例 2：
//
//
//输入：words = ["$easy$","$problem$"], separator = "$"
//输出：["easy","problem"]
//解释：在本示例中，我们进行下述拆分：
//
//"$easy$" 拆分为 "easy"（不包括空字符串）
//"$problem$" 拆分为 "problem"（不包括空字符串）
//
//因此，结果数组为 ["easy","problem"] 。
//
//
// 示例 3：
//
//
//输入：words = ["|||"], separator = "|"
//输出：[]
//解释：在本示例中，"|||" 的拆分结果将只包含一些空字符串，所以我们返回一个空数组 [] 。
//
//
//
// 提示：
//
//
// 1 <= words.length <= 100
// 1 <= words[i].length <= 20
// words[i] 中的字符要么是小写英文字母，要么就是字符串 ".,|$#@" 中的字符（不包括引号）
// separator 是字符串 ".,|$#@" 中的某个字符（不包括引号）
//
//
// Related Topics数组 | 字符串
//
// 👍 15, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> splitWordsBySeparator(List<String> words, char separator) {
            List<String> ans = new ArrayList<>();
            for (String word : words) {
                StringBuilder curr = new StringBuilder();
                for (char c : word.toCharArray()) {
                    if (c == separator) {
                        addAndClear(curr, ans);
                    }else {
                        curr.append(c);
                    }
                }
                addAndClear(curr, ans);
            }
            return ans;
        }

        private static void addAndClear(StringBuilder curr, List<String> ans) {
            if (curr.length() > 0) {
                ans.add(curr.toString());
                curr.delete(0, curr.length());
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[one, two, three, four, five, six]", solution.splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.').toString());
            Assert.assertEquals("[easy, problem]", solution.splitWordsBySeparator(Arrays.asList("$easy$","$problem$"), '$').toString());
            Assert.assertEquals("[]", solution.splitWordsBySeparator(Arrays.asList("|||"), '|').toString());
        }

    }
}
