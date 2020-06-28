package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest50 {
//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double myPow(double x, int n) {
            return Math.pow(x, n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1024.00000d, solution.myPow(2.00000d, 10), 0.00001d);
            Assert.assertEquals(9.26100d, solution.myPow(2.10000d, 3), 0.00001d);
            Assert.assertEquals(0.25000d, solution.myPow(2.00000d, -2), 0.00001d);

        }
    }
}