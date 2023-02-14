package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest1124 {
//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 403 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {
            Map<Integer, Integer> map = new HashMap<>();
            int s = 0;
            int ans = 0;
            for (int i = 0; i < hours.length; i++) {
                s += (hours[i] > 8 ? 1 : -1);
                if (s > 0) {
                    ans = Math.max(ans, i + 1);
                }
                if (map.containsKey(s - 1)) {
                    ans = Math.max(ans, i - map.get(s - 1));
                }
                if (!map.containsKey(s)) {
                    map.put(s, i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1,solution.longestWPI(new int[]{6,6,9}));
        }

    }
}