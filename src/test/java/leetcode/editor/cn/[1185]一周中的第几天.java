package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

class SolutionTest1185 {
//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。 
//
// 输入为三个整数：day、month 和 year，分别表示日、月、年。 
//
// 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "F
//riday", "Saturday"}。 
//
// 
//
// 示例 1： 
//
// 输入：day = 31, month = 8, year = 2019
//输出："Saturday"
// 
//
// 示例 2： 
//
// 输入：day = 18, month = 7, year = 1999
//输出："Sunday"
// 
//
// 示例 3： 
//
// 输入：day = 15, month = 8, year = 1993
//输出："Sunday"
// 
//
// 
//
// 提示： 
//
// 
// 给出的日期一定是在 1971 到 2100 年之间的有效日期。 
// 
// Related Topics 数学 
// 👍 99 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final String[] WEEKS = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",};

        public String dayOfTheWeek(int day, int month, int year) {

            return WEEKS[LocalDate.of(year, month, day).getDayOfWeek().getValue() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("Saturday", solution.dayOfTheWeek(31, 8, 2019));
            Assert.assertEquals("Sunday", solution.dayOfTheWeek(18, 7, 1999));
            Assert.assertEquals("Sunday", solution.dayOfTheWeek(15, 8, 1993));
        }

    }
}