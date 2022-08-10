package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest640 {
//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
// 
//
// Related Topics 数学 字符串 模拟 👍 171 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String solveEquation(String equation) {
            int factor = 0, val = 0;
            int index = 0, n = equation.length(), sign1 = 1; // 等式左边默认系数为正
            while (index < n) {
                if (equation.charAt(index) == '=') {
                    sign1 = -1; // 等式右边默认系数为负
                    index++;
                    continue;
                }

                int sign2 = sign1, number = 0;
                boolean valid = false; // 记录 number 是否有效
                if (equation.charAt(index) == '-' || equation.charAt(index) == '+') { // 去掉前面的符号
                    sign2 = (equation.charAt(index) == '-') ? -sign1 : sign1;
                    index++;
                }
                while (index < n && Character.isDigit(equation.charAt(index))) {
                    number = number * 10 + (equation.charAt(index) - '0');
                    index++;
                    valid = true;
                }

                if (index < n && equation.charAt(index) == 'x') { // 变量
                    factor += valid ? sign2 * number : sign2;
                    index++;
                } else { // 数值
                    val += sign2 * number;
                }
            }

            if (factor == 0) {
                return val == 0 ? "Infinite solutions" : "No solution";
            }
            return "x=" + (-val / factor);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("x=2", solution.solveEquation("x+5-3+x=6+x-2"));
        }

    }
}