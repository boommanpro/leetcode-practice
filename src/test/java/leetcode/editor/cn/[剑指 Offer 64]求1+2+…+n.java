package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest剑指Offer64 {
//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// 👍 293 👎 0

    public static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumNums(int n) {
        return n * (n +1) / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.sumNums(3));
            Assert.assertEquals(45, solution.sumNums(9));
        }
    }
}