package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest201 {
//给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。 
//
// 示例 1: 
//
// 输入: [5,7]
//输出: 4 
//
// 示例 2: 
//
// 输入: [0,1]
//输出: 0 
// Related Topics 位运算 
// 👍 171 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int rangeBitwiseAnd(int m, int n) {
            int res = n;
            for (int i = m; i < n; i++) {
                if (res == 0) {
                    return 0;
                }
                res = res & i;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.rangeBitwiseAnd(5, 7));
            Assert.assertEquals(0, solution.rangeBitwiseAnd(0, 100));
            Assert.assertEquals(0, solution.rangeBitwiseAnd(5, 100));
            Assert.assertEquals(96, solution.rangeBitwiseAnd(99, 100));
            Assert.assertEquals(96, solution.rangeBitwiseAnd(0, 2147483647));
        }
    }
}