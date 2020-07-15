package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest168 {
//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 238 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        final static char[] digits = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        public String convertToTitle(int n) {
            StringBuilder result = new StringBuilder();
            while (n > 0) {
                n -= 1;
                char c = digits[n % 26];
                result.insert(0, c);
                n /= 26;
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("A", solution.convertToTitle(1));
            Assert.assertEquals("B", solution.convertToTitle(2));
            Assert.assertEquals("AA", solution.convertToTitle(27));
            Assert.assertEquals("AB", solution.convertToTitle(28));
            Assert.assertEquals("ZY", solution.convertToTitle(701));
            Assert.assertEquals("AAAX", solution.convertToTitle(18302));
            Assert.assertEquals("ZZZZZA", solution.convertToTitle(321272381));
        }
    }
}