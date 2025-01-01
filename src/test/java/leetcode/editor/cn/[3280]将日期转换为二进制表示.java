package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest3280 {
//给你一个字符串 date，它的格式为 yyyy-mm-dd，表示一个公历日期。
//
// date 可以重写为二进制表示，只需要将年、月、日分别转换为对应的二进制表示（不带前导零）并遵循 year-month-day 的格式。
//
// 返回 date 的 二进制 表示。
//
//
//
// 示例 1：
//
//
// 输入： date = "2080-02-29"
//
//
// 输出： "100000100000-10-11101"
//
// 解释：
//
// 100000100000, 10 和 11101 分别是 2080, 02 和 29 的二进制表示。
//
// 示例 2：
//
//
// 输入： date = "1900-01-01"
//
//
// 输出： "11101101100-1-1"
//
// 解释：
//
// 11101101100, 1 和 1 分别是 1900, 1 和 1 的二进制表示。
//
//
//
// 提示：
//
//
// date.length == 10
// date[4] == date[7] == '-'，其余的 date[i] 都是数字。
// 输入保证 date 代表一个有效的公历日期，日期范围从 1900 年 1 月 1 日到 2100 年 12 月 31 日（包括这两天）。
//
//
// Related Topics数学 | 字符串
//
// 👍 20, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertDateToBinary(String date) {
            return Arrays.stream(date.split("-")).map(new Function<String, String>() {
                @Override
                public String apply(String s) {
                    return Integer.toBinaryString(Integer.valueOf(s));
                }
            }).collect(Collectors.joining("-"));
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();


        @Test
        public void defaultSolutionTest() {
            // 测试示例1
            String date1 = "2080-02-29";
            String expected1 = "100000100000-10-11101";
            assert solution.convertDateToBinary(date1).equals(expected1) : "Test case 1 failed";

            // 测试示例2
            String date2 = "1900-01-01";
            String expected2 = "11101101100-1-1";
            assert solution.convertDateToBinary(date2).equals(expected2) : "Test case 2 failed";

            // 边界测试：1900-01-01
            String date3 = "1900-01-01";
            String expected3 = "11101101100-1-1";
            assert solution.convertDateToBinary(date3).equals(expected3) : "Test case 3 failed";

            // 边界测试：2100-12-31
            String date4 = "2100-12-31";
            String expected4 = "100000110100-1100-11111";
            assert solution.convertDateToBinary(date4).equals(expected4) : "Test case 4 failed";

            // 随机测试：2023-10-05
            String date5 = "2023-10-05";
            String expected5 = "11111100111-1010-101";
            assert solution.convertDateToBinary(date5).equals(expected5) : "Test case 5 failed";

            System.out.println("All test cases passed!");
        }
    }
}
