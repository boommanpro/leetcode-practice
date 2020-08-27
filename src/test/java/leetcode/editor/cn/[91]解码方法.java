package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest91 {
//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 486 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Integer[] mem;

        //A-1 B-2...Z-26
        public int numDecodings(String s) {

            if (s == null || s.isEmpty() || s.charAt(0) == '0') {
                return 0;
            }
            int pre = 1, curr = 1;//初始化

            for (int i = 1; i < s.length(); i++) {
                int temp = curr;
                if (s.charAt(i) == '0') {
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                        curr = pre;
                    } else {
                        //数据有误
                        return 0;
                    }
                } else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                    curr = curr + pre;
                }
                pre = temp;
            }
            return curr;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.numDecodings("12"));
            Assert.assertEquals(3, solution.numDecodings("226"));
        }
    }
}