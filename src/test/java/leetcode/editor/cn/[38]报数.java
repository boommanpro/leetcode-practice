package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest38 {
//报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下： 
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
// 
//
// 1 被读作 "one 1" ("一个一") , 即 11。 
//11 被读作 "two 1s" ("两个一"）, 即 21。 
//21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。 
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。 
//
// 注意：整数顺序将表示为一个字符串。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "1"
// 
//
// 示例 2: 
//
// 输入: 4
//输出: "1211"
// 
// Related Topics 字符串
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {

        String result = "1";
        for (int i = 1; i < n; i++) {
            result = say(result);
        }
        return result;
    }

    private String say(String before) {
        //先count再say

        char value=before.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        int len = before.length();
        for (int i = 1; i < len; i++) {
            char curr = before.charAt(i);
            if (curr == value) {
                count++;
            } else {
                sb.append(count).append(value);
                value = curr;
                count = 1;
            }
        }
        sb.append(count).append(value);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("1",solution.countAndSay(1));
            Assert.assertEquals("11",solution.countAndSay(2));
            Assert.assertEquals("21",solution.countAndSay(3));
            Assert.assertEquals("1211",solution.countAndSay(4));
            Assert.assertEquals("111221",solution.countAndSay(5));

        }
    }
}