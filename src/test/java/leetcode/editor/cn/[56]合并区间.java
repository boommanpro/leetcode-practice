package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest56 {
//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] merge(int[][] intervals) {
            int idx = -1;
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            for (int[] interval : intervals) {
                if (idx == -1 || interval[0] > intervals[idx][1]) {
                    intervals[++idx] = interval;
                }else {
                    intervals[idx][1] = Math.max(intervals[idx][1], interval[1]);
                }
            }

            return Arrays.copyOf(intervals, idx + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[1, 25],[26, 27]]", twoDimension2String(solution.merge(new int[][]{{1, 3}, {2, 5}, {3, 6}, {4, 12}, {1, 25}, {26, 27}})));
            Assert.assertEquals("[[1, 5]]", twoDimension2String(solution.merge(new int[][]{{1, 4}, {4, 5}})));
            Assert.assertEquals("[[1, 6],[8, 10],[15, 18]]", twoDimension2String(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        }

        /**
         * 二维数组转string
         */
        private String twoDimension2String(int[][] array) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < array.length; i++) {
                sb.append(Arrays.toString(array[i]));
                if (i != array.length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}