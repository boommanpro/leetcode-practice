package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest93 {
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法 
// 👍 345 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int IP_COUNT = 4;

        private int[] ipSegment = new int[IP_COUNT];

        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            backTracking(result, s, 0, 0);
            return result;
        }

        @SuppressWarnings("all")
        private void backTracking(List<String> result, String s, int count, int p) {
            //目标
            if (count == IP_COUNT) {
                //剪枝
                if (p == s.length()) {
                    StringBuilder ans = new StringBuilder();
                    for (int i = 0; i < IP_COUNT; i++) {
                        ans.append(ipSegment[i]).append(".");
                    }
                    result.add(ans.substring(0, ans.length() - 1));
                }
                return;
            }
            if (p == s.length()) {
                return;
            }
            //特殊情况
            int surplusCount = IP_COUNT - count - 1;
            if (s.charAt(p) == '0') {
                //判断长度是否满足
                int surplusLength = s.length() - p - 1;
                if (lengthCondition(surplusCount, surplusLength)) {
                    ipSegment[count] = 0;
                    backTracking(result, s, count + 1, p + 1);
                }
                return;
            }

            //正常情况 枚举当前长度
            for (int i = 1; i <= 3; i++) {
                //判断当前是否可以是1-3长度
                int surplusLength = s.length() - p - i;
                //再判断当前值是否满足条件
                if (lengthCondition(surplusCount, surplusLength)) {
                    int value = Integer.valueOf(s.substring(p, p + i));
                    if (valueCondition(value)) {
                        ipSegment[count] = value;
                        backTracking(result, s, count + 1, p + i);
                    }
                }
            }

        }

        private boolean lengthCondition(int surplusCount, int surplusLength) {
            //剩余长度要大于等于剩余数量  并且 长度要小于最大支持长度
            return surplusLength >= surplusCount && surplusLength <= surplusCount * 3;
        }

        private boolean valueCondition(int value) {
            return value >= 0 && value <= 0XFF;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[255.255.11.135, 255.255.111.35]", solution.restoreIpAddresses("25525511135").toString());
            Assert.assertEquals("[0.0.0.0]", solution.restoreIpAddresses("0000").toString());
            Assert.assertEquals("[]", solution.restoreIpAddresses("").toString());
        }
    }
}