package leetcode.editor.cn;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest32 {
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        Stack<Integer> positionStack = new Stack<>();
        Stack<Character> cStack = new Stack<>();
        int[] dp = new int[length];
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            switch (temp) {
                case '(':
                    cStack.add(temp);
                    positionStack.add(i);
                    break;
                case ')':

                    if (!cStack.isEmpty()&&cStack.pop()=='(') {
                        dp[i] = 1;
                        dp[positionStack.pop()] = 1;
                        continue;
                    }
                    break;
                default:
                    break;
            }
        }
        int maxLength = 0;
        int current = 0;
        for (int i = 0; i < length; i++) {
            if (dp[i] == 0) {
                current = 0;
                continue;
            }
            current += dp[i];
            maxLength = Math.max(current, maxLength);
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.longestValidParentheses("(()"));
            Assert.assertEquals(4, solution.longestValidParentheses(")()())"));
            Assert.assertEquals(12, solution.longestValidParentheses("(()))()()()()))()()()()(())"));
            Assert.assertEquals(2, solution.longestValidParentheses("()(()"));
        }
    }
}