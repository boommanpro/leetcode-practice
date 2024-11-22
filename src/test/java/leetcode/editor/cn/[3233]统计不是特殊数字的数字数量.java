package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class SolutionTest3233 {
//给你两个 正整数 l 和 r。对于任何数字 x，x 的所有正因数（除了 x 本身）被称为 x 的 真因数。
//
// 如果一个数字恰好仅有两个 真因数，则称该数字为 特殊数字。例如：
//
//
// 数字 4 是 特殊数字，因为它的真因数为 1 和 2。
// 数字 6 不是 特殊数字，因为它的真因数为 1、2 和 3。
//
//
// 返回区间 [l, r] 内 不是 特殊数字 的数字数量。
//
//
//
// 示例 1：
//
//
// 输入： l = 5, r = 7
//
//
// 输出： 3
//
// 解释：
//
// 区间 [5, 7] 内不存在特殊数字。
//
// 示例 2：
//
//
// 输入： l = 4, r = 16
//
//
// 输出： 11
//
// 解释：
//
// 区间 [4, 16] 内的特殊数字为 4 和 9。
//
//
//
// 提示：
//
//
// 1 <= l <= r <= 10⁹
//
//
// Related Topics数组 | 数学 | 数论
//
// 👍 37, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] pre = null;

        static {
            List<Integer> allSpecial = new ArrayList<>();
            int max = (int) Math.sqrt(1e9);
            boolean[] primes = fastCalcPrimes(max);
            for (int i = 2; i < max; i++) {
                if (primes[i]) {
                    allSpecial.add(i * i);
                }
            }
            pre = allSpecial.stream().mapToInt(Integer::intValue).toArray();

        }


        public static boolean[] fastCalcPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            for (int i = 2; i * i < n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            return isPrime;
        }


        public int nonSpecialCount(int l, int r) {
            int p1 = findL(pre, r);
            int p0 = findR(pre, l);
            return r - l + 1 - (p1 - p0 + 1);
        }

        //>=v的最小元素
        private int findR(int[] pre, int v) {
            int l = 0;
            int r = pre.length - 1;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                if (pre[mid] == v) {
                    return mid;
                }
                if (pre[mid] > v) {
                    if (mid == 0 || pre[mid - 1] < v) {
                        return mid;
                    }
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return pre.length;
        }


        //<=v的最大元素
        private int findL(int[] pre, int v) {
            int l = 0;
            int r = pre.length - 1;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                if (pre[mid] == v) {
                    return mid;
                }
                if (pre[mid] > v) {
                    r = mid - 1;
                } else {
                    if (mid == pre.length - 1 || pre[mid + 1] > v) {
                        return mid; // 找到小于等于目标值的最大元素
                    } else {
                        l = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }


        @Test
        public void testNonSpecialCountExample1() {
            assertEquals(3, solution.nonSpecialCount(5, 7));
        }

        @Test
        public void testNonSpecialCountExample2() {
            assertEquals(11, solution.nonSpecialCount(4, 16));
        }

        @Test
        public void testNonSpecialCountExample3() {
            assertEquals(2, solution.nonSpecialCount(1, 2));
        }

        @Test
        public void testNonSpecialCountExample4() {
            assertEquals(1, solution.nonSpecialCount(1000000000, 1000000000));
        }

    }
}
