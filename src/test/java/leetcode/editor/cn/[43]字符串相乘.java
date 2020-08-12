package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest43 {
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 411 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            String ans = "0";
            int m = num1.length(), n = num2.length();
            for (int i = n - 1; i >= 0; i--) {
                StringBuilder curr = new StringBuilder();
                int add = 0;
                for (int j = n - 1; j > i; j--) {
                    curr.append(0);
                }
                int y = num2.charAt(i) - '0';
                for (int j = m - 1; j >= 0; j--) {
                    int x = num1.charAt(j) - '0';
                    int product = x * y + add;
                    curr.append(product % 10);
                    add = product / 10;
                }
                if (add != 0) {
                    curr.append(add % 10);
                }
                ans = addStrings(ans, curr.reverse().toString());
            }
            return ans;
        }

        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1, j = num2.length() - 1, add = 0;
            StringBuilder ans = new StringBuilder();
            while (i >= 0 || j >= 0 || add != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
                add = result / 10;
                i--;
                j--;
            }
            ans.reverse();
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("6", solution.multiply("2", "3"));
            Assert.assertEquals("56088", solution.multiply("123", "456"));
        }
    }
}