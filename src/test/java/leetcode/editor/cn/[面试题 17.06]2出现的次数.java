package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题17_06 {
//编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。 
//
// 示例: 
//
// 输入: 25
//输出: 9
//解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次) 
//
// 提示： 
//
// 
// n <= 10^9 
// 
// Related Topics 数学 动态规划 
// 👍 20 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numberOf2sInRange(int n) {
            if (n == 0) {
                return 0;
            }
            int digit = (int) Math.log10(n) + 1;
            int[][] dp = new int[digit + 1][2];
            // dp[i][0] = numberOf2sInRange(n % pow(10, i)) 保存0~n的1-i位组成的数包含2的个数
            // dp[i][1] = numberOf2sInRange(99..9) 保存i位均为9包含2的个数
            dp[1][0] = n % 10 >= 2 ? 1 : 0;
            dp[1][1] = 1;
            for (int i = 2; i <= digit; i++) {
                int k = n / ((int) Math.pow(10, i - 1)) % 10;
                dp[i][0] = k * dp[i - 1][1] + dp[i - 1][0];
                if (k == 2) {
                    dp[i][0] += n % (int) Math.pow(10, i - 1) + 1;
                } else if (k > 2) {
                    dp[i][0] += (int) Math.pow(10, i - 1);
                }
                dp[i][1] = 10 * dp[i - 1][1] + (int) Math.pow(10, i - 1); //计算1-i位均为9的值包含2的个数
            }
            return dp[digit][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.numberOf2sInRange(10));
            Assert.assertEquals(3, solution.numberOf2sInRange(20));
            Assert.assertEquals(9, solution.numberOf2sInRange(25));
            Assert.assertEquals(50000, solution.numberOf2sInRange(100000));
            Assert.assertEquals(551687056, solution.numberOf2sInRange(559366752));
            Assert.assertEquals(200000007, solution.numberOf2sInRange(222222222));
        }
    }
}