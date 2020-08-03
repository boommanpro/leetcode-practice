package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest415 {
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 注意： 
//
// 
// num1 和num2 的长度都小于 5100. 
// num1 和num2 都只包含数字 0-9. 
// num1 和num2 都不包含任何前导零。 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。 
// 
// Related Topics 字符串 
// 👍 206 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int l1 = num1.length() - 1;
            int l2 = num2.length() - 1;
            int carry = 0;
            while (carry != 0 || l1 >= 0 || l2 >= 0) {
                int v1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
                int v2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
                int sum = v1 + v2 + carry;
                carry = sum / 10;
                sb.append(sum % 10);
                l1--;
                l2--;
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("123456", solution.addStrings("123451", "5"));
        }
    }
}