package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest401 {
//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。 
//
// 每个 LED 代表一个 0 或 1，最低位在右侧。 
//
// 
//
// 例如，上面的二进制手表读取 “3:25”。 
//
// 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。 
//
// 
//
// 示例： 
//
// 输入: n = 1
//返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "
//0:32"] 
//
// 
//
// 提示： 
//
// 
// 输出的顺序没有要求。 
// 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 
// 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。 
// 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。 
// 
// Related Topics 位运算 回溯算法 
// 👍 158 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> result;

        public List<String> readBinaryWatch(int num) {
            //总共10个灯 遂可能亮num个灯
            boolean[] selectPath = new boolean[10];
            result = new ArrayList<>();
            //枚举所有情况
            dfs(selectPath, 0, 0, num);
            return result;
        }

        private void dfs(boolean[] selectPath, int start, int light, int num) {
            if (light == num) {
                add2Result(selectPath);
                return;
            }
            for (int i = start; i < 10; i++) {
                selectPath[i] = true;
                dfs(selectPath, i + 1, light + 1, num);
                selectPath[i] = false;
            }
        }

        private void add2Result(boolean[] selectPath) {
            int hour = getHour(selectPath);
            int minute = getMinute(selectPath);
            if (hour >= 0 && hour < 12 && minute >= 0 && minute < 60) {
                result.add(String.format("%d:%02d",hour,minute));
            }
        }

        private int getMinute(boolean[] selectPath) {
            StringBuilder sb = new StringBuilder();
            for (int i = 4; i < 10; i++) {
                if (selectPath[i]) {
                    sb.append("1");
                }else {
                    sb.append("0");
                }
            }
            return Integer.parseInt(sb.toString(),2);
        }

        private int getHour(boolean[] selectPath) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                if (selectPath[i]) {
                    sb.append("1");
                }else {
                    sb.append("0");
                }
            }
            return Integer.parseInt(sb.toString(),2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[8:00, 4:00, 2:00, 1:00, 0:32, 0:16, 0:08, 0:04, 0:02, 0:01]", solution.readBinaryWatch(1).toString());
            Assert.assertEquals("[0:00]", solution.readBinaryWatch(0).toString());
        }
    }
}