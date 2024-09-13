package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

class SolutionTest2398 {
//你有 n 个机器人，给你两个下标从 0 开始的整数数组 chargeTimes 和 runningCosts ，两者长度都为 n 。第 i 个机器人充电时间
//为 chargeTimes[i] 单位时间，花费 runningCosts[i] 单位时间运行。再给你一个整数 budget 。
//
// 运行 k 个机器人 总开销 是 max(chargeTimes) + k * sum(runningCosts) ，其中 max(chargeTimes)
// 是这 k 个机器人中最大充电时间，sum(runningCosts) 是这 k 个机器人的运行时间之和。
//
// 请你返回在 不超过 budget 的前提下，你 最多 可以 连续 运行的机器人数目为多少。
//
//
//
// 示例 1：
//
//
//输入：chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
//输出：3
//解释：
//可以在 budget 以内运行所有单个机器人或者连续运行 2 个机器人。
//选择前 3 个机器人，可以得到答案最大值 3 。总开销是 max(3,6,1) + 3 * sum(2,1,3) = 6 + 3 * 6 = 24 ，小于
//25 。
//可以看出无法在 budget 以内连续运行超过 3 个机器人，所以我们返回 3 。
//
//
// 示例 2：
//
//
//输入：chargeTimes = [11,12,19], runningCosts = [10,8,7], budget = 19
//输出：0
//解释：即使运行任何一个单个机器人，还是会超出 budget，所以我们返回 0 。
//
//
//
//
// 提示：
//
//
// chargeTimes.length == runningCosts.length == n
// 1 <= n <= 5 * 10⁴
// 1 <= chargeTimes[i], runningCosts[i] <= 10⁵
// 1 <= budget <= 10¹⁵
//
//
// Related Topics队列 | 数组 | 二分查找 | 前缀和 | 滑动窗口 | 堆（优先队列）
//
// 👍 61, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //1,2,5,3,4
        public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
            int n = chargeTimes.length;
            LinkedList<int[]> queue = new LinkedList<>();
            long windowSum = 0;
            int ans = 0;
            for (int l = 0, r = 0; r < n; r++) {
                int chargeTime = chargeTimes[r];
                if (queue.isEmpty() || queue.peekLast()[0] > chargeTime) {
                    queue.add(new int[]{chargeTime, 1});
                } else {
                    int cnt = 1;
                    while (!queue.isEmpty() && queue.peekLast()[0] <= chargeTime) {
                        cnt += queue.pollLast()[1];
                    }
                    queue.add(new int[]{chargeTime, cnt});
                }
                int runningCost = runningCosts[r];
                windowSum += runningCost;
                while (l < n && !queue.isEmpty() && windowSum * (r - l + 1) + queue.peek()[0] > budget) {
                    int[] curr = queue.peek();
                    windowSum -= runningCosts[l];
                    if (curr[1] > 1) {
                        curr[1]--;
                    } else {
                        queue.poll();
                    }
                    l++;
                }
                ans = Math.max(ans, r - l + 1);
            }
            return ans;
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
        public void testMaximumRobotsExample1() {
            int[] chargeTimes = {3, 6, 1, 3, 4};
            int[] runningCosts = {2, 1, 3, 4, 5};
            long budget = 25;
            int expected = 3;
            assertEquals(expected, solution.maximumRobots(chargeTimes, runningCosts, budget));
        }

        @Test
        public void testMaximumRobotsExample2() {
            int[] chargeTimes = {11, 12, 19};
            int[] runningCosts = {10, 8, 7};
            long budget = 19;
            int expected = 0;
            assertEquals(expected, solution.maximumRobots(chargeTimes, runningCosts, budget));
        }

        @Test
        public void testMaximumRobotsExample3() {
            int[] chargeTimes = {19, 63, 21, 8, 5, 46, 56, 45, 54, 30, 92, 63, 31, 71, 87, 94, 67, 8, 19, 89, 79, 25};
            int[] runningCosts = {91, 92, 39, 89, 62, 81, 33, 99, 28, 99, 86, 19, 5, 6, 19, 94, 65, 86, 17, 10, 8, 42};
            long budget = 85;
            int expected = 1;
            assertEquals(expected, solution.maximumRobots(chargeTimes, runningCosts, budget));
        }

        @Test
        public void testMaximumRobotsExample4() {
            int[] chargeTimes = {19, 63, 21, 8, 5, 46, 56, 45, 54, 30, 92, 63, 31, 71, 87, 94, 67, 8, 19, 89, 79, 25};
            int[] runningCosts = {91, 92, 39, 89, 62, 81, 33, 99, 28, 99, 86, 19, 5, 6, 19, 94, 65, 86, 17, 10, 8, 42};
            long budget = 85;
            int expected = 1;
            assertEquals(expected, solution.maximumRobots(chargeTimes, runningCosts, budget));
        }
    }
}
