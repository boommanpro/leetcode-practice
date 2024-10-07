package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

class SolutionTest871 {
//汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
//
// 沿途有加油站，用数组 stations 表示。其中 stations[i] = [positioni, fueli] 表示第 i 个加油站位于出发位置东面
// positioni 英里处，并且有 fueli 升汽油。
//
// 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。当汽车到达加油站时，它可能停下来加油，将所有汽
//油从加油站转移到汽车中。
//
// 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
//
// 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
//
//
//
// 示例 1：
//
//
//输入：target = 1, startFuel = 1, stations = []
//输出：0
//解释：可以在不加油的情况下到达目的地。
//
//
// 示例 2：
//
//
//输入：target = 100, startFuel = 1, stations = [[10,100]]
//输出：-1
//解释：无法抵达目的地，甚至无法到达第一个加油站。
//
//
// 示例 3：
//
//
//输入：target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
//输出：2
//解释：
//出发时有 10 升燃料。
//开车来到距起点 10 英里处的加油站，消耗 10 升燃料。将汽油从 0 升加到 60 升。
//然后，从 10 英里处的加油站开到 60 英里处的加油站（消耗 50 升燃料），
//并将汽油从 10 升加到 50 升。然后开车抵达目的地。
//沿途在两个加油站停靠，所以返回 2 。
//
//
//
//
// 提示：
//
//
// 1 <= target, startFuel <= 10⁹
// 0 <= stations.length <= 500
// 1 <= positioni < positioni+1 < target
// 1 <= fueli < 10⁹
//
//
// Related Topics贪心 | 数组 | 动态规划 | 堆（优先队列）
//
// 👍 458, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minRefuelStops(int target, int fuel, int[][] stations) {
            //1. 模拟行进过程，贪心实现。 能不加油就先不加油，如果要加油也从可加油列表里面加最大的油，直到加满或者到达终点。
            //2. ① 排序stations，按照position 升序 fuel 降序 ② target位置为当前位置
            int start = fuel;
            int count = 0;
            int i = 0;
            int n = stations.length;
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
            Arrays.sort(stations, (a, b) -> a[0] - b[0]);
            while (start < target) {
                while (i < n && start >= stations[i][0]) {
                    queue.add(stations[i][1]);
                    i++;
                }
                if (!queue.isEmpty()) {
                    start += queue.poll();
                    count++;
                } else {
                    return -1;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            // 测试用例1: 不需要加油就能到达目的地
            assertEquals(0, solution.minRefuelStops(1, 1, new int[][]{}));

            // 测试用例2: 起点与目标距离很远，且只有一个加油站，且油量不足以到达
            assertEquals(-1, solution.minRefuelStops(100, 1, new int[][]{{10, 100}}));

            // 测试用例3: 需要两次加油才能到达目的地
            assertEquals(2, solution.minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));

        }

    }
}
