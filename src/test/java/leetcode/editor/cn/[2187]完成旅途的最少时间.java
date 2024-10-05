package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class SolutionTest2187 {
//给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。
//
// 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在
//运行且互不影响。
//
// 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。
//
//
//
//
// 示例 1：
//
// 输入：time = [1,2,3], totalTrips = 5
//输出：3
//解释：
//- 时刻 t = 1 ，每辆公交车完成的旅途数分别为 [1,0,0] 。
//  已完成的总旅途数为 1 + 0 + 0 = 1 。
//- 时刻 t = 2 ，每辆公交车完成的旅途数分别为 [2,1,0] 。
//  已完成的总旅途数为 2 + 1 + 0 = 3 。
//- 时刻 t = 3 ，每辆公交车完成的旅途数分别为 [3,1,1] 。
//  已完成的总旅途数为 3 + 1 + 1 = 5 。
//所以总共完成至少 5 趟旅途的最少时间为 3 。
//
//
// 示例 2：
//
// 输入：time = [2], totalTrips = 1
//输出：2
//解释：
//只有一辆公交车，它将在时刻 t = 2 完成第一趟旅途。
//所以完成 1 趟旅途的最少时间为 2 。
//
//
//
//
// 提示：
//
//
// 1 <= time.length <= 10⁵
// 1 <= time[i], totalTrips <= 10⁷
//
//
// Related Topics数组 | 二分查找
//
// 👍 98, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumTime(int[] time, int totalTrips) {
            // 1. 尝试枚举1-Long.MAX_VALUE，看能不能完成totalTrips次旅程
            // 2.二分查找的逼近方式应该是r=mid l=mid+1 然后返回l
            // 3. l,r
            Arrays.sort(time);
            long l = 1, r = (long) totalTrips * time[0];
            while (l < r) {
                long mid = ((r - l) >> 1) + l;
                if (check(time, totalTrips, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        private boolean check(int[] time, int totalTrips, long sum) {
            long count = 0;
            for (int t : time) {
                count += sum / t;
            }
            return count >= totalTrips;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testMinimumTimeWithExample1() {
            int[] time = {1, 2, 3};
            int totalTrips = 5;
            long expected = 3;
            assertEquals(expected, solution.minimumTime(time, totalTrips));
        }

        @Test
        public void testMinimumTimeWithExample2() {
            int[] time = {2};
            int totalTrips = 1;
            long expected = 2;
            assertEquals(expected, solution.minimumTime(time, totalTrips));
        }
    }
}
