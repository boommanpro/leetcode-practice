package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest371 {
//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        int carry = a & b;
        int sum = a ^ b;
        while(carry != 0){
            carry = carry << 1;
            return getSum(sum,carry);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3,solution.getSum(1,2));
            Assert.assertEquals(1,solution.getSum(-2,3));

        }
    }
}