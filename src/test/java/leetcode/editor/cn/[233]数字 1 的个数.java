package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest233 {
//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 2 * 109 
// 
// Related Topics 数学 
// 👍 199 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countDigitOne(int n) {
            int ans = 0;
            int high = n / 10;
            int low = 0;
            int digit = 1;
            int curr = n % 10;
            while (curr != 0 || high != 0) {
                if (curr == 0) {
                    ans += digit * high;
                } else if (curr == 1) {
                    ans += digit * high + low + 1;
                } else {
                    ans += digit * (high + 1);
                }
                low += curr * digit;
                curr = high % 10;
                high /= 10;
                digit *= 10;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.countDigitOne(1));
            Assert.assertEquals(2, solution.countDigitOne(10));
            Assert.assertEquals(4, solution.countDigitOne(11));
            Assert.assertEquals(5, solution.countDigitOne(12));
            Assert.assertEquals(6, solution.countDigitOne(13));
            Assert.assertEquals(21, solution.countDigitOne(100));
            Assert.assertEquals(23, solution.countDigitOne(101));
            Assert.assertEquals(36, solution.countDigitOne(111));
            Assert.assertEquals(31, solution.countDigitOne(109));
            Assert.assertEquals(600001, solution.countDigitOne(1000000));
            Assert.assertEquals(2978524, solution.countDigitOne(3184191));
            Assert.assertEquals(7000001, solution.countDigitOne(10000000));
        }
    }
}