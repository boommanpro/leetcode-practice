package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class SolutionTest1235 {
//你打算利用空闲时间来做兼职工作赚些零花钱。 
//
// 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。 
//
// 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。 
//
// 注意，时间上出现重叠的 2 份工作不能同时进行。 
//
// 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//输出：120
//解释：
//我们选出第 1 份和第 4 份工作， 
//时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
// 
//
// 示例 2： 
//
// 
//
// 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60
//]
//输出：150
//解释：
//我们选择第 1，4，5 份工作。 
//共获得报酬 150 = 20 + 70 + 60。
// 
//
// 示例 3： 
//
// 
//
// 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4 
// 1 <= startTime[i] < endTime[i] <= 10^9 
// 1 <= profit[i] <= 10^4 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 329 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n = startTime.length;
            int[][] jobDetail = new int[n][3];
            for (int i = 0; i < n; i++) {
                jobDetail[i][0] = startTime[i];
                jobDetail[i][1] = endTime[i];
                jobDetail[i][2] = profit[i];
            }
            Arrays.sort(jobDetail, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        if (o1[0] == o2[0]) {
                            return o2[2] - o1[2];
                        }
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                }
            });
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            treeMap.put(0, 0);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int[] detail = jobDetail[i];
                Map.Entry<Integer, Integer> preEntry = treeMap.floorEntry(detail[0]);
                Map.Entry<Integer, Integer> currEntry = treeMap.floorEntry(detail[1]);
                treeMap.put(detail[1], Math.max(preEntry.getValue() + detail[2], currEntry.getValue()));
                ans = Math.max(ans, treeMap.get(detail[1]));
            }
            return treeMap.lastEntry().getValue();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(150, solution.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
            Assert.assertEquals(41, solution.jobScheduling(new int[]{6, 15, 7, 11, 1, 3, 16, 2}, new int[]{19, 18, 19, 16, 10, 8, 19, 8}, new int[]{2, 9, 1, 19, 5, 7, 3, 19}));
        }

    }
}