package leetcode.editor.cn;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest20 {

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isValid(String s) {
            Stack<Character> cStack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                switch (temp) {
                    case '(':
                    case '{':
                    case '[':
                        cStack.add(temp);
                        break;
                    case ']':
                        if (!cStack.isEmpty() && cStack.pop() == '[') {
                            continue;
                        }
                        return false;
                    case ')':
                        if (!cStack.isEmpty() && cStack.pop() == '(') {
                            continue;
                        }
                        return false;
                    case '}':
                        if (!cStack.isEmpty() && cStack.pop() == '{') {
                            continue;
                        }
                        return false;
                    default:
                        break;
                }
            }
            return cStack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isValid("()[]{}"));
            Assert.assertTrue(solution.isValid("{[]}"));
            Assert.assertTrue(solution.isValid("()"));
            Assert.assertFalse(solution.isValid("{[]}{"));
            Assert.assertFalse(solution.isValid("(]"));
            Assert.assertFalse(solution.isValid("([)]"));
        }
    }
}