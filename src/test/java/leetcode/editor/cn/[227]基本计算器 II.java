package leetcode.editor.cn;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest227 {
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 288 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            char preSymbol = '+';
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                }
                if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                    switch (preSymbol) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                    }
                    preSymbol = c;
                    num = 0;
                }
            }
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
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
            Assert.assertEquals(2, solution.calculate("1*2"));
            Assert.assertEquals(1, solution.calculate("2-1"));
            Assert.assertEquals(0, solution.calculate("1-1"));
            Assert.assertEquals(11, solution.calculate("3+2*2+2+2"));
            Assert.assertEquals(20, solution.calculate("4*5"));
            Assert.assertEquals(1, solution.calculate(" 3/2 "));
            Assert.assertEquals(5, solution.calculate(" 3+5 / 2 "));
        }
    }
}