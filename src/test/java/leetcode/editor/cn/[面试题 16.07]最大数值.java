package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题16_07 {
//编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。 
// 示例： 
// 输入： a = 1, b = 2
//输出： 2
// 
// Related Topics 位运算 数学

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximum(int a, int b) {
            //求差值
            int c = (a >> 1) - (b >> 1);
            //符号
            int d = c >> 31;
            //d的值只有 0,-1 两种结果
            return (d + 1) * a - d * b;
        }

        public int maximum0(int a, int b) {
            return (Math.abs(a - b) + a + b) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.maximum(1, 2));
            Assert.assertEquals(2, solution.maximum(2, 1));
            Assert.assertEquals(-7, solution.maximum(-7, -1004522707));
        }
    }
}