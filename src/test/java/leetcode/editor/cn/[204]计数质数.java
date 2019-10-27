package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest204 {
    //统计所有小于非负整数 n 的质数的数量。
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学
    public static


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            //Sieve
            if (n <= 2) return 0;
            boolean[] sieve = new boolean[n + 1];
            sieve[2] = true;
            //我们认为3n+2都是质数
            for (int i = 3; i < n; i += 2) {
                sieve[i] = true;
            }

            for (int p = 3; p * p <= n; p++) {
                if (sieve[p]) {
                    for (int i = p + p; i <= n; i += p) {
                        sieve[i] = false;
                    }
                }
            }
            int count = 1;
            for (int i = 3; i < n; i += 2) {
                count += sieve[i] ? 1 : 0;
            }
            return count;
        }

        //质数的定义  素数的定义很简单，如果一个数如果只能被 1 和它本身整除，那么这个数就是素数。
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.countPrimes(10));
        }
    }
}