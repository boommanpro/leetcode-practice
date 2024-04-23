package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

class SolutionTest3114 {
//给你一个字符串 s，表示一个 12 小时制的时间格式，其中一些数字（可能没有）被 "?" 替换。
//
// 12 小时制时间格式为 "HH:MM" ，其中 HH 的取值范围为 00 至 11，MM 的取值范围为 00 至 59。最早的时间为 00:00，最晚的时
//间为 11:59。
//
// 你需要将 s 中的 所有 "?" 字符替换为数字，使得结果字符串代表的时间是一个 有效 的 12 小时制时间，并且是可能的 最晚 时间。
//
// 返回结果字符串。
//
//
//
// 示例 1：
//
//
// 输入： s = "1?:?4"
//
//
// 输出： "11:54"
//
// 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "11:54"。
//
// 示例 2：
//
//
// 输入： s = "0?:5?"
//
//
// 输出： "09:59"
//
// 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "09:59"。
//
//
//
// 提示：
//
//
// s.length == 5
// s[2] 是字符 ":"
// 除 s[2] 外，其他字符都是数字或 "?"
// 输入保证在替换 "?" 字符后至少存在一个介于 "00:00" 和 "11:59" 之间的时间。
//
//
// Related Topics字符串 | 枚举
//
// 👍 0, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLatestTime(String s) {
            int[] v = Arrays.stream(s.split(":")).flatMap((Function<String, Stream<Integer>>) s1 -> {
                List<Integer> ans = new ArrayList<>();
                for (char c : s1.toCharArray()) {
                    if (c == '?') {
                        ans.add(-1);
                    } else {
                        ans.add(c - '0');
                    }
                }
                return ans.stream();
            }).mapToInt(Integer::intValue).toArray();
            return prefix(v[0], v[1]) + ":" + suffix(v[2], v[3]);
        }

        private String prefix(int i, int j) {

            if (i != -1 && j != -1) {
                return i + "" + j;
            }
            if (i == -1 && j == -1) {
                return "11";
            }
            if (i == -1 && j <= 1) {
                return "1" + j;
            }
            if (i == -1) {
                return "0" + j;
            }
            if (i == 1) {
                return "11";
            }
            return "09";
        }

        private String suffix(int i, int j) {
            if (i != -1 && j != -1) {
                return i + "" + j;
            }
            if (i == -1 && j == -1) {
                return "59";
            }
            if (i == -1) {
                return 5 + "" + j;
            }
            return i + "" + 9;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("11:54", solution.findLatestTime("1?:?4"));
        }

    }
}
