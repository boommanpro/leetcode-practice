package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest668 {
//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？ 
//
// 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。 
//
// 例 1： 
//
// 
//输入: m = 3, n = 3, k = 5
//输出: 3
//解释: 
//乘法表:
//1	2	3
//2	4	6
//3	6	9
//
//第5小的数字是 3 (1, 2, 2, 3, 3).
// 
//
// 例 2： 
//
// 
//输入: m = 2, n = 3, k = 6
//输出: 6
//解释: 
//乘法表:
//1	2	3
//2	4	6
//
//第6小的数字是 6 (1, 2, 2, 3, 4, 6).
// 
//
// 注意： 
//
// 
// m 和 n 的范围在 [1, 30000] 之间。 
// k 的范围在 [1, m * n] 之间。 
// 
// Related Topics 二分查找 👍 183 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int l = 0;
            int r = m * n + 1;
            while (l + 1 < r) {
                int mid = r - (r - l) / 2;
                if (check(m, n, mid, k)) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            return r;
        }

        private boolean check(int m, int n, int target, int k) {
            //如果比当前数小的数字大于k，则r
            int cnt = 0;
            for (int i = 1; i <= m; i++) {
                cnt += Math.min(target / i, n);
            }
            return cnt >= k;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.findKthNumber(3, 3, 5));
            Assert.assertEquals(6, solution.findKthNumber(2, 3, 6));
        }

    }
}