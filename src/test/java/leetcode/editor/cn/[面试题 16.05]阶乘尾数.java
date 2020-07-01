package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题16_05 {
//设计一个算法，算出 n 阶乘有多少个尾随零。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int trailingZeroes(int n) {
            int count = 0;
            while (n >= 5) {
                count += n / 5;
                n /= 5;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0,solution.trailingZeroes(3));
            Assert.assertEquals(1,solution.trailingZeroes(5));
            Assert.assertEquals(0,solution.trailingZeroes(1));
            Assert.assertEquals(0,solution.trailingZeroes(2));
            Assert.assertEquals(0,solution.trailingZeroes(3));
            Assert.assertEquals(0,solution.trailingZeroes(4));
            Assert.assertEquals(2,solution.trailingZeroes(10));
            Assert.assertEquals(3,solution.trailingZeroes(15));
            Assert.assertEquals(4,solution.trailingZeroes(20));
            Assert.assertEquals(6,solution.trailingZeroes(25));
            //5 10 15 20 25 30
            Assert.assertEquals(7,solution.trailingZeroes(30));

        }
    }
}