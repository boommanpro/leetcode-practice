package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

class SolutionTest1021 {
//有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。 
//
// 
// 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
// 
//
// 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
// 
//
// 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
//
// 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(()())(())"
//输出："()()()"
//解释：
//输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
//
// 示例 2： 
//
// 
//输入：s = "(()())(())(()(()))"
//输出："()()()()(())"
//解释：
//输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
//删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
// 
//
// 示例 3： 
//
// 
//输入：s = "()()"
//输出：""
//解释：
//输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//删除每个部分中的最外层括号后得到 "" + "" = ""。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 '(' 或 ')' 
// s 是一个有效括号字符串 
// 
// Related Topics 栈 字符串 👍 200 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeOuterParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    Integer p = stack.pop();
                    if (stack.isEmpty()) {
                        sb.append(s, p + 1, i);
                    }
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("()()()", solution.removeOuterParentheses("(()())(())"));
            Assert.assertEquals("()()()()(())", solution.removeOuterParentheses("(()())(())(()(()))"));
            Assert.assertEquals("", solution.removeOuterParentheses("()()"));
        }

    }
}