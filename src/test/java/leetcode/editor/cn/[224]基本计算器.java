package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest224 {
//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 392 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int calculate(String s) {
            String[] polish = getPolish1(s); //转后缀表达式
            return evalRPN(polish);
        }

        private String[] getPolish1(String s) {
            List<String> ans = new ArrayList<>();
            Stack<String> stack = new Stack<>();
            int temp = -1;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    continue;
                }
                if (c >= '0' && c <= '9') {
                    if (temp == -1) {
                        temp = c - '0';
                    }else {
                        temp = temp * 10 + c - '0';
                    }
                }else {
                    if (temp != -1) {
                        ans.add(temp + "");
                        temp = -1;
                    }
                    switch (c) {
                        case '(':
                            stack.push(c + "");
                            break;
                        case ')':
                            while (!stack.peek().equals("(")) {
                                ans.add(stack.pop());
                            }
                            stack.pop();
                            break;
                        case '+':
                        case '-':
                        case '*':
                        case '/':
                            while (!stack.isEmpty()) {
                                if (stack.peek().equals("(")) {
                                    break;
                                }
                                ans.add(stack.pop());
                            }
                            stack.push(c + "");
                    }
                }
            }
            if (temp != -1) {
                ans.add(temp + "");
            }
            while (!stack.isEmpty()) {
                ans.add(stack.pop());
            }
            return ans.toArray(new String[]{});
        }


        // 下边是 150 题的代码，求后缀表达式的值
        public int evalRPN(String[] tokens) {
            Stack<String> stack = new Stack<>();
            for (String t : tokens) {
                if (isOperation(t)) {
                    int a = stringToNumber(stack.pop());
                    int b = stringToNumber(stack.pop());
                    int ans = eval(b, a, t.charAt(0));
                    stack.push(ans + "");
                } else {
                    stack.push(t);
                }
            }
            return stringToNumber(stack.pop());
        }

        private int eval(int a, int b, char op) {
            switch (op) {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    return a / b;
            }
            return 0;
        }

        private int stringToNumber(String s) {
            int sign = 1;
            int start = 0;
            if (s.charAt(0) == '-') {
                sign = -1;
                start = 1;
            }
            int res = 0;
            for (int i = start; i < s.length(); i++) {
                res = res * 10 + s.charAt(i) - '0';
            }
            return res * sign;
        }

        private boolean isOperation(String t) {
            return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            // 中缀表达式转后缀表达式
            Assert.assertEquals(2, solution.calculate("1 + 1"));
            Assert.assertEquals(3, solution.calculate("2-1 + 2 "));
            Assert.assertEquals(23, solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        }
    }
}