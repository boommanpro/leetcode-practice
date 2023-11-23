package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionTest1410 {
//「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
//
// HTML 里这些特殊字符和它们对应的字符实体包括：
//
//
// 双引号：字符实体为 &quot; ，对应的字符是 " 。
// 单引号：字符实体为 &apos; ，对应的字符是 ' 。
// 与符号：字符实体为 &amp; ，对应对的字符是 & 。
// 大于号：字符实体为 &gt; ，对应的字符是 > 。
// 小于号：字符实体为 &lt; ，对应的字符是 < 。
// 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
//
//
// 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
//
//
//
// 示例 1：
//
//
//输入：text = "&amp; is an HTML entity but &ambassador; is not."
//输出："& is an HTML entity but &ambassador; is not."
//解释：解析器把字符实体 &amp; 用 & 替换
//
//
// 示例 2：
//
//
//输入：text = "and I quote: &quot;...&quot;"
//输出："and I quote: \"...\""
//
//
// 示例 3：
//
//
//输入：text = "Stay home! Practice on Leetcode :)"
//输出："Stay home! Practice on Leetcode :)"
//
//
// 示例 4：
//
//
//输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
//输出："x > y && x < y is always false"
//
//
// 示例 5：
//
//
//输入：text = "leetcode.com&frasl;problemset&frasl;all"
//输出："leetcode.com/problemset/all"
//
//
//
//
// 提示：
//
//
// 1 <= text.length <= 10^5
// 字符串可能包含 256 个ASCII 字符中的任意字符。
//
//
// Related Topics哈希表 | 字符串
//
// 👍 35, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String entityParser(String text) {
            StringBuilder ans = new StringBuilder();
            Map<String, Character> map = new HashMap<>();
            map.put("&quot;", '"');
            map.put("&apos;", '\'');
            map.put("&amp;", '&');
            map.put("&gt;", '>');
            map.put("&lt;", '<');
            map.put("&frasl;", '/');
            int n = text.length();

            for (int i = 0; i < n; i++) {
                char c = text.charAt(i);
                boolean append = true;
                if (c == '&') {
                    for (int p = i; p < n; p++) {
                        if (p - i > 6) {
                            break;
                        }
                        String sub = text.substring(i, p + 1);
                        if (map.containsKey(sub)) {
                            ans.append(map.get(sub));
                            i = p;
                            append = false;
                            break;
                        }
                    }


                }
                if (append) {
                    ans.append(c);
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("& is an HTML entity but &ambassador; is not.", solution.entityParser("&amp; is an HTML entity but &ambassador; is not."));
            Assert.assertEquals("and I quote: \"...\"", solution.entityParser("and I quote: &quot;...&quot;"));
            Assert.assertEquals("Stay home! Practice on Leetcode :)", solution.entityParser("Stay home! Practice on Leetcode :)"));
            Assert.assertEquals("x > y && x < y is always false", solution.entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
            Assert.assertEquals("leetcode.com/problemset/all", solution.entityParser("leetcode.com&frasl;problemset&frasl;all"));
        }

    }
}
