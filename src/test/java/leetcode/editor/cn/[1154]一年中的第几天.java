package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

class SolutionTest1154 {
//给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
//
//
//
// 示例 1：
//
//
//输入：date = "2019-01-09"
//输出：9
//解释：给定日期是2019年的第九天。
//
// 示例 2：
//
//
//输入：date = "2019-02-10"
//输出：41
//
//
//
//
// 提示：
//
//
// date.length == 10
// date[4] == date[7] == '-'，其他的 date[i] 都是数字
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
//
//
// Related Topics数学 | 字符串
//
// 👍 124, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int dayOfYear(String date) {
            String[] split = date.split("-");
            int year = Integer.valueOf(split[0]);
            int month = Integer.valueOf(split[1]);
            int day = Integer.valueOf(split[2]);
            return LocalDate.of(year, month, day).getDayOfYear();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(9,solution.dayOfYear("2019-01-09"));
            Assert.assertEquals(41,solution.dayOfYear("2019-02-10"));
        }

    }
}
