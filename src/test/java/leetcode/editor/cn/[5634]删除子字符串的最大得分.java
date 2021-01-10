package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

class SolutionTest5634 {
//给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。 
//
// 
// 删除子字符串 "ab" 并得到 x 分。
//
// 
// 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。 
// 
// 
// 删除子字符串"ba" 并得到 y 分。
// 
// 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。 
// 
// 
// 
//
// 请返回对 s 字符串执行上面操作若干次能得到的最大得分。 
//
// 
//
// 示例 1： 
//
// 输入：s = "cdbcbbaaabab", x = 4, y = 5
//输出：19
//解释：
//- 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
//- 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
//- 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
//- 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
//总得分为 5 + 4 + 5 + 5 = 19 。 
//
// 示例 2： 
//
// 输入：s = "aabbaaxybbaabb", x = 5, y = 4
//输出：20
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// 1 <= x, y <= 104 
// s 只包含小写英文字母。 
// 
// Related Topics 贪心算法 
// 👍 1 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumGain(String s, int x, int y) {
            if (y > x) {
                return maximumGain(new StringBuilder(s).reverse().toString(), y, x);
            }
            // x always > y
            int ans = 0;
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && c == 'b' && stack.peek() == 'a') {
                    stack.pop();
                    ans += x;
                } else {
                    stack.push(c);
                }
            }
            // handler ba

            Stack<Character> stack2 = new Stack<>();
            while (!stack.isEmpty()) {
                if (!stack2.isEmpty() && stack2.peek() == 'a' && stack.peek() == 'b') {
                    stack2.pop();
                    stack.pop();
                    ans += y;
                } else {
                    stack2.push(stack.pop());
                }
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
            Assert.assertEquals(19, solution.maximumGain("cdbcbbaaabab", 4, 5));
            Assert.assertEquals(20, solution.maximumGain("aabbaaxybbaabb", 5, 4));
            Assert.assertEquals(112374, solution.maximumGain("aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha", 1926, 4320));
        }
    }
}