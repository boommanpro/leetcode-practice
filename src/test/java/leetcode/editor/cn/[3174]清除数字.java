package leetcode.editor.cn;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

class SolutionTest3174 {
//给你一个字符串 s 。
//
// 你的任务是重复以下操作删除 所有 数字字符：
//
//
// 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
//
//
// 请你返回删除所有数字字符以后剩下的字符串。
//
//
//
// 示例 1：
//
//
// 输入：s = "abc"
//
//
// 输出："abc"
//
// 解释：
//
// 字符串中没有数字。
//
//
// 示例 2：
//
//
// 输入：s = "cb34"
//
//
// 输出：""
//
// 解释：
//
// 一开始，我们对 s[2] 执行操作，s 变为 "c4" 。
//
// 然后对 s[1] 执行操作，s 变为 "" 。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含小写英文字母和数字字符。
// 输入保证所有数字都可以按以上操作被删除。
//
//
// Related Topics栈 | 字符串 | 模拟
//
// 👍 28, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String clearDigits(String s) {
            Stack<Integer> charStack = new Stack<>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    if (!charStack.isEmpty()) {
                        charStack.pop();
                    }
                }else {
                    charStack.push(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = n-1; i >= 0; i--) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    continue;
                }
                if (!charStack.isEmpty() && charStack.peek() == i) {
                    charStack.pop();
                    sb.append(c);
                }
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testClearDigits_Example1() {
            String s = "abc";
            String expected = "abc";
            assertEquals(expected, solution.clearDigits(s));
        }

        @Test
        public void testClearDigits_Example2() {
            String s = "cb34";
            String expected = "";
            assertEquals(expected, solution.clearDigits(s));
        }
    }
}
