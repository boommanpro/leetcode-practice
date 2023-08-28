package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest57 {
//给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
//
//
// 示例 1：
//
// 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
//
//
// 示例 2：
//
// 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
//
//
//
// 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
// Related Topics 排序 数组
// 👍 248 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> ans = new ArrayList<>();
            boolean insert = false;
            for (int[] interval : intervals) {
                if (insert) {
                    ans.add(interval);
                    continue;
                }
                if (newInterval[0] > interval[1]) {
                    ans.add(interval);
                    continue;
                }
                if (newInterval[1] < interval[0]) {
                    insert = true;
                    ans.add(newInterval);
                    ans.add(interval);
                    continue;
                }
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            if (!insert) {
                ans.add(newInterval);
            }
            return ans.toArray(new int[][]{});
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[1, 5],[6, 9]]", ArrayUtils.twoDimensionList2String(solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
            Assert.assertEquals("[[1, 2],[3, 10],[12, 16]]", ArrayUtils.twoDimensionList2String(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        }
    }
}
