package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题08_01 {
//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3      3   111  12 21
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 动态规划 
// 👍 16 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int waysToStep(int n) {
            if (n <= 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (n == 3) {
                return 4;
            }

            long[] f = new long[n + 1];
            f[1] = 1;
            f[2] = 2;
            f[3] = 4;
            for (int i = 4; i <= n; i++) {
                f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % 1000000007;
            }
            return (int) f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.waysToStep(3));
            Assert.assertEquals(13, solution.waysToStep(5));
            Assert.assertEquals(176653584, solution.waysToStep(76));
        }
    }
}