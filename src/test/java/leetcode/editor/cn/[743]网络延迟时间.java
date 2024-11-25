package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest743 {
//有 n 个网络节点，标记为 1 到 n。
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
//
//
//
// 示例 1：
//
//
//
//
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
//
//
// 示例 2：
//
//
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
//
//
// 示例 3：
//
//
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// 所有 (ui, vi) 对都 互不相同（即，不含重复边）
//
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列）
// 👍 378 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int[] time : times) {
                int x = time[0];
                int y = time[1];
                int cost = time[2];
                map.computeIfAbsent(x, i -> new ArrayList<>()).add(new int[]{y, cost});
            }

            Set<Integer> count = new HashSet<>();
            Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            queue.add(new int[]{k, 0});
            int ans = 0;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                count.add(curr[0]);
                ans = Math.max(ans, curr[1]);
                if (count.size() == n) {
                    return ans;
                }
                for (int[] next : map.getOrDefault(curr[0], new ArrayList<>())) {
                    int y = next[0];
                    int cost = next[1];
                    if (!count.contains(y)) {
                        queue.add(new int[]{y, cost + curr[1]});
                    }
                }
            }
            return count.size() == n ? ans : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));

            Assert.assertEquals(2, solution.networkDelayTime(new int[][]{
                    {1,2,1}, {2, 3, 2}, {1, 3, 2}
            }, 3, 1));
        }
    }
}
