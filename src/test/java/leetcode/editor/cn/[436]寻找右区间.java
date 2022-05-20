package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

class SolutionTest436 {
//给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。 
//
// 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。 
//
// 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。 
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,2]]
//输出：[-1]
//解释：集合中只有一个区间，所以输出-1。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[3,4],[2,3],[1,2]]
//输出：[-1,0,1]
//解释：对于 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间[3,4]具有最小的“右”起点;
//对于 [1,2] ，区间[2,3]具有最小的“右”起点。
// 
//
// 示例 3： 
//
// 
//输入：intervals = [[1,4],[2,3],[3,4]]
//输出：[-1,2,-1]
//解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
//对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 2 * 10⁴ 
// intervals[i].length == 2 
// -10⁶ <= starti <= endi <= 10⁶ 
// 每个间隔的起点都 不相同 
// 
// Related Topics 数组 二分查找 排序 👍 112 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int n = intervals.length;
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            int[][] value = new int[n][3];
            for (int i = 0; i < n; i++) {
                value[i][0] = intervals[i][0];
                value[i][1] = intervals[i][1];
                value[i][2] = i;
            }
            Arrays.sort(value, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            });
            for (int i = 0; i < n; i++) {
                int target = value[i][1];
                if (value[n - 1][0] < target) {
                    continue;
                }
                int l = i;
                int r = n;
                while (l < r) {
                    int mid = l + ((r - l) >> 1);
                    if (value[mid][0] >= target) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                ans[value[i][2]] = value[l][2];
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
            Assert.assertEquals("[-1]", Arrays.toString(solution.findRightInterval(new int[][]{{1, 2}})));
            Assert.assertEquals("[-1, 0, 1]", Arrays.toString(solution.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
            Assert.assertEquals("[-1, 2, -1]", Arrays.toString(solution.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}})));
        }

    }
}