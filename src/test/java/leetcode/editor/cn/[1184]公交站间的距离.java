package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest1184 {
//环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号
//为 (i + 1) % n 的车站之间的距离。
//
// 环线上的公交车都可以按顺时针和逆时针的方向行驶。
//
// 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
//
//
//
// 示例 1：
//
//
//
// 输入：distance = [1,2,3,4], start = 0, destination = 1
//输出：1
//解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
//
//
//
// 示例 2：
//
//
//
// 输入：distance = [1,2,3,4], start = 0, destination = 2
//输出：3
//解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
//
//
//
//
// 示例 3：
//
//
//
// 输入：distance = [1,2,3,4], start = 0, destination = 3
//输出：4
//解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10^4
// distance.length == n
// 0 <= start, destination < n
// 0 <= distance[i] <= 10^4
//
//
// Related Topics数组
//
// 👍 111, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int ans1 = run(distance, start, destination);
            int ans2 = run(distance, destination, start);
            return Math.min(ans1, ans2);
        }

        private int run(int[] distance, int start, int destination) {
            int curr = start;
            int sum = 0;
            while (curr != destination) {
                sum += distance[curr];
                curr = (curr + 1) % distance.length;
            }
            return sum;
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
        public void testDistanceBetweenBusStopsExample1() {
            int[] distance = {1, 2, 3, 4};
            int start = 0;
            int destination = 1;
            assertEquals(1, solution.distanceBetweenBusStops(distance, start, destination));
        }

        @Test
        public void testDistanceBetweenBusStopsExample2() {
            int[] distance = {1, 2, 3, 4};
            int start = 0;
            int destination = 2;
            assertEquals(3, solution.distanceBetweenBusStops(distance, start, destination));
        }

        @Test
        public void testDistanceBetweenBusStopsExample3() {
            int[] distance = {1, 2, 3, 4};
            int start = 0;
            int destination = 3;
            assertEquals(4, solution.distanceBetweenBusStops(distance, start, destination));
        }

    }
}
