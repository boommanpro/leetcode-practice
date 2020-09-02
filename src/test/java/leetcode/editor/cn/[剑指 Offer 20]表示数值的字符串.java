package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest剑指Offer_20 {
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 63 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean isNumber(String s) {
            if (s.endsWith("f") || s.endsWith("D")) return false;
            try {
                Double.parseDouble(s);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isNumber("+100"));
            Assert.assertTrue(solution.isNumber("5e2"));
            Assert.assertTrue(solution.isNumber("-123"));
            Assert.assertTrue(solution.isNumber("3.1416"));
            Assert.assertTrue(solution.isNumber("-1E-16"));
            Assert.assertTrue(solution.isNumber("0123"));
            Assert.assertFalse(solution.isNumber("12e"));
            Assert.assertFalse(solution.isNumber("1a3.14"));
            Assert.assertFalse(solution.isNumber("1.2.3"));
            Assert.assertFalse(solution.isNumber("+-5"));
            Assert.assertFalse(solution.isNumber("12e+5.4"));
            Assert.assertFalse(solution.isNumber("959440.94f"));
        }
    }
}