package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest8 {

    //请你来实现一个 atoi 函数，使其能将字符串转换成整数。
//
// 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。 
//
// 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。 
//
// 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。 
//
// 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。 
//
// 在任何情况下，若函数不能进行有效的转换时，请返回 0。 
//
// 说明： 
//
// 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，请返回 INT_MAX (231 − 1) 或 INT_MIN (−231) 。 
//
// 示例 1: 
//
// 输入: "42"
//输出: 42
// 
//
// 示例 2: 
//
// 输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
// 
//
// 示例 3: 
//
// 输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
// 
//
// 示例 4: 
//
// 输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。 
//
// 示例 5: 
//
// 输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
//     因此返回 INT_MIN (−231) 。
// 
// Related Topics 数学 字符串
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 有限状态机
         * start
         * signed
         * inNumber
         * end
         */
        public int myAtoi(String str) {
            Automaton automaton = new Automaton();
            for (int i = 0; i < str.length(); i++) {
                automaton.pushValue(str.charAt(i));
            }
            return automaton.getResult();

        }

        static class Automaton {

            private int positive = 1;

            private int ans = 0;

            private DFA state;

            public Automaton() {
                state = DFA.START;
            }

            public void pushValue(char c) {
                if (state == DFA.END) {
                    return;
                }
                Event event = Event.convert2(c);
                state = DFA.sendEvent(state, event);
                if (state == DFA.END) {
                    return;
                }
                switch (event) {
                    case SYMBOL:
                        if (c == '-') {
                            positive = -1;
                            return;
                        }
                    case DIGIT:
                        int value = c - '0';
                        if (positive > 0 && ExceedMaxLimit(ans, value)) {
                            ans = Integer.MAX_VALUE;
                            state = DFA.END;
                            return;
                        }
                        if (positive < 0 && ExceedMinLimit(ans, value)) {
                            ans = Integer.MIN_VALUE;
                            state = DFA.END;
                            return;
                        }
                        ans = ans * 10 + value;
                        return;
                    default:
                        break;
                }

            }

            private boolean ExceedMinLimit(int ans, int value) {
                if (ans > 214748364) {
                    return true;
                }
                if (ans == 214748364 && value > 8) {
                    return true;
                }
                return false;
            }

            private boolean ExceedMaxLimit(int ans, int value) {
                if (ans > 214748364) {
                    return true;
                }
                if (ans == 214748364 && value > 7) {
                    return true;
                }
                return false;
            }

            public int getResult() {
                return positive * ans;
            }
        }

        enum DFA {
            /**
             * 开始
             */
            START,
            /**
             * 符号
             */
            SIGNED,
            /**
             * 数字
             */
            IN_NUMBER,
            /**
             * 结束
             */
            END,
            ;

            public static DFA sendEvent(DFA status, Event event) {
                if (status == DFA.END) {
                    return DFA.END;
                }
                switch (event) {
                    case SYMBOL:
                        if (status == DFA.START || status == DFA.SIGNED) {
                            return DFA.IN_NUMBER;
                        }
                        return DFA.END;
                    case DIGIT:
                        if (status == DFA.START || status == DFA.SIGNED || status == DFA.IN_NUMBER) {
                            return DFA.IN_NUMBER;
                        }
                        return DFA.END;
                    case EMPTY:
                        if (status == DFA.START) {
                            return DFA.START;
                        }
                        return DFA.END;
                    case OTHER:
                        return DFA.END;
                    default:
                        throw new RuntimeException(String.format("Event not support,Event Value:[%s]", event));
                }
            }
        }

        enum Event {
            /**
             * 符号
             */
            SYMBOL,
            /**
             * 数字
             */
            DIGIT,
            /**
             * 空格
             */
            EMPTY,
            /**
             * 其他
             */
            OTHER;

            public static Event convert2(char c) {
                if (c == ' ') {
                    return EMPTY;
                }
                if (isSymbol(c)) {
                    return SYMBOL;
                }
                if (isDigit(c)) {
                    return DIGIT;
                }
                return OTHER;
            }

            private static boolean isDigit(char c) {
                return c >= '0' && c <= '9';
            }

            private static boolean isSymbol(char c) {
                return c == '+' || c == '-';
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.myAtoi("words and 987"));
            Assert.assertEquals(42, solution.myAtoi("42"));
            Assert.assertEquals(-42, solution.myAtoi("-42"));
            Assert.assertEquals(4193, solution.myAtoi("4193 with words"));
            Assert.assertEquals(-2147483648, solution.myAtoi("-91283472332"));
            Assert.assertEquals(2147483647, solution.myAtoi("2147483648"));
        }
    }
}