package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest263 {
//编写一个程序判断给定的数是否为丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例 1: 
//
// 输入: 6
//输出: true
//解释: 6 = 2 × 3 
//
// 示例 2: 
//
// 输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
// 
//
// 示例 3: 
//
// 输入: 14
//输出: false 
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。 
//
// 说明： 
//
// 
// 1 是丑数。 
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。 
// 
// Related Topics 数学 
// 👍 159 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isUgly(int num) {
            if (num <= 0) {
                return false;
            }
            //丑数就是只包含质因数 2, 3, 5 的正整数。
            if (num % 5 == 0) {
                return isUgly(num / 5);
            }
            if (num % 3 == 0) {
                return isUgly(num / 3);
            }
            if (num % 2 == 0) {
                return isUgly(num / 2);
            }
            return num == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isUgly(6));
            Assert.assertTrue(solution.isUgly(8));
            Assert.assertFalse(solution.isUgly(14));
        }
    }
}