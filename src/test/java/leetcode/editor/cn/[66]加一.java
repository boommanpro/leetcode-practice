package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest66 {

    //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] plusOne(int[] digits) {
            int length = digits.length;

            for (int i = length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] %= 10;
                if (digits[i] != 0) {
                    return digits;
                }
            }
            digits = new int[length + 1];
            digits[0] = 1;
            return digits;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();

            Assert.assertArrayEquals(new int[]{1, 2, 4}, solution.plusOne(new int[]{1, 2, 3}));
            Assert.assertArrayEquals(new int[]{4, 3, 2, 2}, solution.plusOne(new int[]{4, 3, 2, 1}));
            Assert.assertArrayEquals(new int[]{1, 0}, solution.plusOne(new int[]{9}));
            Assert.assertArrayEquals(new int[]{1, 0, 0, 0, 0}, solution.plusOne(new int[]{9, 9, 9, 9}));
        }
    }
}