package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest6295 {
//给你两个数组 arr1 和 arr2 ，它们一开始都是空的。你需要往它们中添加正整数，使它们满足以下条件： 
//
// 
// arr1 包含 uniqueCnt1 个 互不相同 的正整数，每个整数都 不能 被 divisor1 整除 。 
// arr2 包含 uniqueCnt2 个 互不相同 的正整数，每个整数都 不能 被 divisor2 整除 。 
// arr1 和 arr2 中的元素 互不相同 。 
// 
//
// 给你 divisor1 ，divisor2 ，uniqueCnt1 和 uniqueCnt2 ，请你返回两个数组中 最大元素 的 最小值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：divisor1 = 2, divisor2 = 7, uniqueCnt1 = 1, uniqueCnt2 = 3
//输出：4
//解释：
//我们可以把前 4 个自然数划分到 arr1 和 arr2 中。
//arr1 = [1] 和 arr2 = [2,3,4] 。
//可以看出两个数组都满足条件。
//最大值是 4 ，所以返回 4 。
// 
//
// 示例 2： 
//
// 
//输入：divisor1 = 3, divisor2 = 5, uniqueCnt1 = 2, uniqueCnt2 = 1
//输出：3
//解释：
//arr1 = [1,2] 和 arr2 = [3] 满足所有条件。
//最大值是 3 ，所以返回 3 。 
//
// 示例 3： 
//
// 
//输入：divisor1 = 2, divisor2 = 4, uniqueCnt1 = 8, uniqueCnt2 = 2
//输出：15
//解释：
//最终数组为 arr1 = [1,3,5,7,9,11,13,15] 和 arr2 = [2,6] 。
//上述方案是满足所有条件的最优解。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= divisor1, divisor2 <= 10⁵ 
// 1 <= uniqueCnt1, uniqueCnt2 < 10⁹ 
// 2 <= uniqueCnt1 + uniqueCnt2 <= 10⁹ 
// 
//
// 👍 3 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
            int l = 1;
            int r = Integer.MAX_VALUE;
            long lcm = lcm(divisor1, divisor2);
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                int a = mid / divisor1;
                int b = mid / divisor2;
                int c = (int) (mid / lcm);
                if (mid - a >= uniqueCnt1 && mid - b >= uniqueCnt2 && mid - c >= uniqueCnt1 + uniqueCnt2) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        private long lcm(int a, int b) {
            return ((long) a * b / gcd(a, b));
        }

        private long gcd(int a, int b) {
            if (a < b) {
                return gcd(b, a);
            }
            return b == 0 ? a : gcd(b, a % b);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.minimizeSet(2, 7, 1, 3));
            Assert.assertEquals(3, solution.minimizeSet(3, 5, 2, 1));
            Assert.assertEquals(15, solution.minimizeSet(2, 4, 8, 2));
            Assert.assertEquals(240680, solution.minimizeSet(78789, 42659, 58291, 182389));
            Assert.assertEquals(1000000024, solution.minimizeSet(2557, 15901, 805236426, 194763574));
            Assert.assertEquals(217679202, solution.minimizeSet(92761, 48337, 208563424, 9115778));

        }

    }
}