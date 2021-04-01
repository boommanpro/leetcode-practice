package leetcode.editor.cn;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1006 {
//通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 *
// 3 * 2 * 1。 
//
// 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)
//和减法(-)。 
//
// 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我
//们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。 
//
// 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。 
//
// 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。 
//
// 
//
// 示例 1： 
//
// 输入：4
//输出：7
//解释：7 = 4 * 3 / 2 + 1
// 
//
// 示例 2： 
//
// 输入：10
//输出：12
//解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10000 
// -2^31 <= answer <= 2^31 - 1 （答案保证符合 32 位整数。） 
// 
// Related Topics 数学 
// 👍 64 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int clumsy(int N) {
            char[] operation = new char[]{'*', '/', '+', '-'};
            int curr = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(N);
            N--;
            while (N >= 1) {
                char c = operation[curr];
                switch (c) {
                    case '*':
                        stack.push(stack.pop() * N);
                        break;
                    case '/':
                        stack.push(stack.pop() / N);
                        break;
                    case '+':
                        stack.push(N);
                        break;
                    case '-':
                        stack.push(-N);
                        break;
                }
                N--;
                curr = (curr + 1) % 4;
            }
            long ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ((int) ans);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.clumsy(4));
            Assert.assertEquals(12, solution.clumsy(10));
        }
    }
}