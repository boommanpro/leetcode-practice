package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest816 {
//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
//
// Related Topics 字符串 回溯 👍 136 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            s = s.substring(1, s.length() - 1);

            List<String> ans = new ArrayList<>();
            for (int i = 0; i < s.length() - 1; i++) {
                List<String> pre = getPos(s.substring(0, i + 1));
                List<String> post = getPos(s.substring(i + 1));
                for (String s1 : pre) {
                    for (String s2 : post) {
                        ans.add(String.format("(%s, %s)", s1, s2));
                    }
                }
            }
            return ans;
        }

        private List<String> getPos(String s) {
            List<String> ans = new ArrayList<>();
            if ("0".equals(s) || s.charAt(0) != '0') {
                ans.add(s);
            }
            for (int p = 1; p < s.length(); p++) {
                if ((s.charAt(0) == '0' && p != 1) || s.charAt(s.length() - 1) == '0') {
                    continue;
                }
                ans.add(String.format("%s.%s", s.substring(0, p), s.substring(p)));
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
            Assert.assertEquals("[(1, 23), (1, 2.3), (12, 3), (1.2, 3)]", solution.ambiguousCoordinates("(123)").toString());
            Assert.assertEquals("[(0, 0.011), (0.001, 1)]", solution.ambiguousCoordinates("(00011)").toString());
        }

    }
}