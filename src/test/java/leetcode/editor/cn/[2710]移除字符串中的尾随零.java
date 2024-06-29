package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest2710 {
//给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
//
//
//
// 示例 1：
//
// 输入：num = "51230100"
//输出："512301"
//解释：整数 "51230100" 有 2 个尾随零，移除并返回整数 "512301" 。
//
//
// 示例 2：
//
// 输入：num = "123"
//输出："123"
//解释：整数 "123" 不含尾随零，返回整数 "123" 。
//
//
//
//
// 提示：
//
//
// 1 <= num.length <= 1000
// num 仅由数字 0 到 9 组成
// num 不含前导零
//
//
// Related Topics字符串
//
// 👍 24, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeTrailingZeros(String num) {
            StringBuilder sb = new StringBuilder();
            boolean end = true;
            for (int j = num.length()-1; j >= 0; j--) {
                if (end && num.charAt(j) == '0') {
                    continue;
                }
                end = false;
                sb.append(num.charAt(j));
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
            Assert.assertEquals("512301",solution.removeTrailingZeros("51230100"));
            Assert.assertEquals("123",solution.removeTrailingZeros("123"));
        }

    }
}
