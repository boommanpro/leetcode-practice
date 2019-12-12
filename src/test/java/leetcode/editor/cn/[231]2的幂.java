package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest231 {

    //给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isPowerOfTwo(int n) {
           return n > 0 && (n & (n-1)) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertFalse(solution.isPowerOfTwo(0));
            Assert.assertFalse(solution.isPowerOfTwo(-16));
            Assert.assertTrue(solution.isPowerOfTwo(1));
            Assert.assertTrue(solution.isPowerOfTwo(16));
            Assert.assertTrue(solution.isPowerOfTwo(32));
            Assert.assertTrue(solution.isPowerOfTwo(1024));
            Assert.assertFalse(solution.isPowerOfTwo(218));
        }
    }
}