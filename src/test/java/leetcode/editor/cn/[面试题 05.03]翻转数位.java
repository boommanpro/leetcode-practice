package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题05_03 {
//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。 
//
// 示例 1： 
//
// 输入: num = 1775(110111011112)
//输出: 8
// 
//
// 示例 2： 
//
// 输入: num = 7(01112)
//输出: 4
// 
//
// Related Topics 位运算 动态规划 👍 92 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverseBits(int num) {
            String sb = Integer.toBinaryString(num);
            if (sb.length() < 32) {
                sb = '0' + sb;
            }
            int max = 1;
            int n = sb.length();
            int[][] dp = new int[n][2];
            dp[0][1] = 1;
            if (sb.charAt(0) == '1') {
                dp[0][0] = 1;
            }
            for (int i = 1; i < n; i++) {
                if (sb.charAt(i) == '1') {
                    dp[i][0] = dp[i - 1][0] + 1;
                    dp[i][1] = dp[i - 1][1] + 1;
                }else {
                    dp[i][1] = dp[i - 1][0] + 1;
                }
                max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(8, solution.reverseBits(1775));
            Assert.assertEquals(4, solution.reverseBits(7));
            Assert.assertEquals(1, solution.reverseBits(0));
            Assert.assertEquals(32, solution.reverseBits(-1));
        }

    }
}