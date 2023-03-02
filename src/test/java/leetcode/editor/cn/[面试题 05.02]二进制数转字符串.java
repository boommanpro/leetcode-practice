package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题05_02 {
//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 
//
// 提示： 
//
// 
// 32位包括输出中的 "0." 这两位。 
// 题目保证输入用例的小数位数最多只有 6 位 
// 
//
// Related Topics 位运算 数学 字符串 👍 122 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String printBin(double num) {
            StringBuilder sb = new StringBuilder("0.");
            while (num != 0 && sb.length() <= 32) {
                num = num * 2;
                int digit = (int) num;
                sb.append(digit);
                num -= digit;
            }
            return sb.length() <= 32 ? sb.toString() : "ERROR";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("0.101", solution.printBin(0.625));
            Assert.assertEquals("ERROR", solution.printBin(0.1));
        }

    }
}