package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest3116 {
//给你一个整数数组 coins 表示不同面额的硬币，另给你一个整数 k 。
//
// 你有无限量的每种面额的硬币。但是，你 不能 组合使用不同面额的硬币。
//
// 返回使用这些硬币能制造的 第 kᵗʰ 小 金额。
//
//
//
// 示例 1：
//
//
// 输入： coins = [3,6,9], k = 3
//
//
// 输出： 9
//
// 解释：给定的硬币可以制造以下金额： 3元硬币产生3的倍数：3, 6, 9, 12, 15等。 6元硬币产生6的倍数：6, 12, 18, 24等。 9元硬
//币产生9的倍数：9, 18, 27, 36等。 所有硬币合起来可以产生：3, 6, 9, 12, 15等。
//
// 示例 2：
//
//
// 输入：coins = [5,2], k = 7
//
//
// 输出：12
//
// 解释：给定的硬币可以制造以下金额： 5元硬币产生5的倍数：5, 10, 15, 20等。 2元硬币产生2的倍数：2, 4, 6, 8, 10, 12等。
//所有硬币合起来可以产生：2, 4, 5, 6, 8, 10, 12, 14, 15等。
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 15
// 1 <= coins[i] <= 25
// 1 <= k <= 2 * 10⁹
// coins 包含两两不同的整数。
//
//
// Related Topics位运算 | 数组 | 数学 | 二分查找 | 组合数学 | 数论
//
// 👍 11, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long findKthSmallest(int[] coins, int k) {
            int mn = Arrays.stream(coins).min().getAsInt();
            long left = k - 1, right = (long) mn * k;
            while (left <= right) {
                long mid = ((right - left) >> 1) + left;
                if (includeExclusionPrinciple(mid, coins)>=k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;

        }

        public static long includeExclusionPrinciple(long m, int[] arr) {
            long cnt = 0;
            int n = arr.length;
            for (int i = 1; i < 1 << n; i++) {
                long lcmRes = 1;
                for (int j = 0; j < n; j++) {
                    if (((i >> j) & 1) == 1) {
                        lcmRes = lcm(lcmRes, arr[j]);
                    }
                }
                cnt += Integer.bitCount(i) % 2 == 1 ? m / lcmRes : -m / lcmRes;
            }
            return cnt;
        }

        //最小公倍数
        private static long lcm(long a, long b) {
            return a * b / gcd(a, b);
        }

        //最大公约数
        private  static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(9, solution.findKthSmallest(new int[]{3, 6, 9}, 3));
            Assert.assertEquals(12, solution.findKthSmallest(new int[]{5, 2}, 7));
        }

    }
}
