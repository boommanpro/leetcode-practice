package leetcode.editor.cn;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest509 {
//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Map<Integer, Integer> visited;

        public int fib(int N) {
            if (N == 0) {
                return 0;
            }
            if (N == 1) {
                return 1;
            }
            int first = fib(N - 1);
            int second = fib(N - 2);
            return first + second;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.fib(0));
            Assert.assertEquals(1, solution.fib(1));
            Assert.assertEquals(1, solution.fib(2));
            Assert.assertEquals(2, solution.fib(3));
            Assert.assertEquals(832040, solution.fib(30));
        }
    }
}