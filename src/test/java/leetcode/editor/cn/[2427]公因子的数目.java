package leetcode.editor.cn;

import org.junit.Test;

class SolutionTest2427 {
//给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。 
//
// 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。 
//
// 
//
// 示例 1： 
//
// 输入：a = 12, b = 6
//输出：4
//解释：12 和 6 的公因子是 1、2、3、6 。
// 
//
// 示例 2： 
//
// 输入：a = 25, b = 30
//输出：2
//解释：25 和 30 的公因子是 1、5 。 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b <= 1000 
// 
//
// Related Topics 数学 枚举 数论 👍 5 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int commonFactors(int a, int b) {
            int c = gcd(a, b);
            int cnt = 0;
            for (int i = 1; i <= c; i++) {
                if (c % i == 0) {
                    cnt++;
                }
            }
            return cnt;
        }

        private int gcd(int a, int b) {
            if (a < b) {
                return gcd(b, a);
            }
            return a % b == 0 ? b : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

    }
}