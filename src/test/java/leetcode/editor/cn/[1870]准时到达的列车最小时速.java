package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest1870 {
//给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。另给你一个长度为 n 的整数数组 dist ，
//其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
//
// 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
//
//
// 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
//
//
// 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
//
// 生成的测试用例保证答案不超过 10⁷ ，且 hour 的 小数点后最多存在两位数字 。
//
//
//
// 示例 1：
//
//
//输入：dist = [1,3,2], hour = 6
//输出：1
//解释：速度为 1 时：
//- 第 1 趟列车运行需要 1/1 = 1 小时。
//- 由于是在整数时间到达，可以立即换乘在第 1 小时发车的列车。第 2 趟列车运行需要 3/1 = 3 小时。
//- 由于是在整数时间到达，可以立即换乘在第 4 小时发车的列车。第 3 趟列车运行需要 2/1 = 2 小时。
//- 你将会恰好在第 6 小时到达。
//
//
// 示例 2：
//
//
//输入：dist = [1,3,2], hour = 2.7
//输出：3
//解释：速度为 3 时：
//- 第 1 趟列车运行需要 1/3 = 0.33333 小时。
//- 由于不是在整数时间到达，故需要等待至第 1 小时才能搭乘列车。第 2 趟列车运行需要 3/3 = 1 小时。
//- 由于是在整数时间到达，可以立即换乘在第 2 小时发车的列车。第 3 趟列车运行需要 2/3 = 0.66667 小时。
//- 你将会在第 2.66667 小时到达。
//
// 示例 3：
//
//
//输入：dist = [1,3,2], hour = 1.9
//输出：-1
//解释：不可能准时到达，因为第 3 趟列车最早是在第 2 小时发车。
//
//
//
// 提示：
//
//
// n == dist.length
// 1 <= n <= 10⁵
// 1 <= dist[i] <= 10⁵
// 1 <= hour <= 10⁹
// hours 中，小数点后最多存在两位数字
//
//
// Related Topics数组 | 二分查找
//
// 👍 70, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            if (hour - dist.length + 1 <= 0) {
                return -1;
            }
            int l = 1;
            int r = (int) 1e7;
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                if (check(mid, dist, hour)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        private boolean check(int v, int[] dist, double hour) {
            double sumCost = 0;
            int n = dist.length;
            for (int i = 0; i < n - 1; i++) {
                sumCost += Math.ceil((double) dist[i] / v);
            }
            sumCost += (double) dist[n - 1] / v;
            return sumCost <= hour;
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
        public void testExample1() {
            assertEquals(1, solution.minSpeedOnTime(new int[]{1, 3, 2}, 6));
        }

        @Test
        public void testExample2() {
            assertEquals(3, solution.minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
        }

        @Test
        public void testExample3() {
            assertEquals(-1, solution.minSpeedOnTime(new int[]{1, 3, 2}, 1.9));
        }

        @Test
        public void testExample4() {
            assertEquals(10000000, solution.minSpeedOnTime(new int[]{1, 1, 100000}, 2.01));
        }

        @Test
        public void testExample5() {
            assertEquals(-1, solution.minSpeedOnTime(new int[]{1, 1}, 1.0));
        }

    }
}
