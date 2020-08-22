package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest306 {
//累加数是一个字符串，组成它的数字可以形成累加序列。 
//
// 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。 
//
// 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。 
//
// 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 示例 1: 
//
// 输入: "112358"
//输出: true 
//解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2: 
//
// 输入: "199100199"
//输出: true 
//解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 进阶: 
//你如何处理一个溢出的过大的整数输入? 
// Related Topics 回溯算法 
// 👍 91 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {
            return solve(num, num.length(), 0, 0, 0, 0);
        }

        private boolean solve(String num, int len, int idx, long sum, long pre, int k) {
            if (idx == len) {
                return k > 2;
            }
            for (int i = idx; i < len; i++) {
                long curr = fetchCurrValue(num, idx, i);
                if (curr < 0) {
                    continue;
                }
                if (k >= 2 && curr != sum) {
                    continue;
                }
                if (solve(num, len, i + 1, curr + pre, curr, k + 1)) {
                    return true;
                }
            }
            return false;
        }

        private long fetchCurrValue(String num, int start, int idx) {
            if (num.charAt(start) == '0' && (idx - start) >0) {
                return -1;
            }
            long sum = 0;
            for (int i = start; i <= idx; i++) {
                sum = sum * 10 + (num.charAt(i) - '0');
            }
            return sum;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertTrue(solution.isAdditiveNumber("112358"));
            Assert.assertTrue(solution.isAdditiveNumber("199100199"));
//            Assert.assertTrue(solution.isAdditiveNumber("101"));
//            Assert.assertTrue(solution.isAdditiveNumber("8917"));
//            Assert.assertFalse(solution.isAdditiveNumber("1023"));
        }
    }
}