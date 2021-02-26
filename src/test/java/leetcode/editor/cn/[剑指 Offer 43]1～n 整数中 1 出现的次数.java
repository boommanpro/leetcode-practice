package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest剑指Offer_43 {
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 数学 
// 👍 130 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countDigitOne(int n) {
            int ans = 0;
            int low = 0;
            int curr = n % 10;
            int high = n / 10;
            int digit = 1;
            while (high != 0 || curr != 0) {
                if (curr == 0) {
                    ans += high * digit;
                } else if (curr == 1) {
                    ans += high * digit + low + 1;
                }else {
                    ans += (high + 1) * digit;
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