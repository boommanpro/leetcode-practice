package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest441 {
//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。 
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。 
//
// n 是一个非负整数，并且在32位有符号整型的范围内。 
//
// 示例 1: 
//
// 
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
// 
//
// 示例 2: 
//
// 
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
// 
// Related Topics 数学 二分查找 
// 👍 92 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int arrangeCoins(int n) {
            if (n == 0) {
                return 0;
            }
            int k1 = 1;
            int k2 = n;
            while (k1 <= k2) {
                int mid = (k2 - k1 >> 1) + k1;
                long prev = (long) (0.5d * mid * (mid + 1));
                long next = (long) (0.5d * (mid + 1) * (mid + 2));
                if (n >= prev && n < next) {
                    return mid;
                } else if (n >= next) {
                    k1 = mid + 1;
                } else {
                    k2 = mid - 1;
                }
            }
            return k1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.arrangeCoins(5));
            Assert.assertEquals(2, solution.arrangeCoins(3));
            Assert.assertEquals(3, solution.arrangeCoins(8));
            Assert.assertEquals(60070, solution.arrangeCoins(1804289383));
        }
    }
}