package leetcode.editor.cn;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

class SolutionTest2073 {
//有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。
//
// 给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。
//
// 每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，如果需要购买更多票，他必须走到 队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩
//下需要买的票，那他将会 离开 队伍。
//
// 返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。
//
//
//
// 示例 1：
//
//
// 输入：tickets = [2,3,2], k = 2
//
//
//
// 输出：6
//
//
//
// 解释：
//
//
//
//
//
//
//
// 队伍一开始为 [2,3,2]，第 k 个人以下划线标识。
// 在最前面的人买完票后，队伍在第 1 秒变成 [3,2,1]。
// 继续这个过程，队伍在第 2 秒变为[2,1,2]。
// 继续这个过程，队伍在第 3 秒变为[1,2,1]。
// 继续这个过程，队伍在第 4 秒变为[2,1]。
// 继续这个过程，队伍在第 5 秒变为[1,1]。
// 继续这个过程，队伍在第 6 秒变为[1]。第 k 个人完成买票，所以返回 6。
//
//
//
//
//
//
// 示例 2：
//
//
// 输入：tickets = [5,1,1,1], k = 0
//
//
//
// 输出：8
//
//
//
// 解释：
//
//
//
// 队伍一开始为 [5,1,1,1]，第 k 个人以下划线标识。
// 在最前面的人买完票后，队伍在第 1 秒变成 [1,1,1,4]。
// 继续这个过程 3 秒，队伍在第 4 秒变为[4]。
// 继续这个过程 4 秒，队伍在第 8 秒变为[]。第 k 个人完成买票，所以返回 8。
//
//
//
//
// 提示：
//
//
// n == tickets.length
// 1 <= n <= 100
// 1 <= tickets[i] <= 100
// 0 <= k < n
//
//
// Related Topics队列 | 数组 | 模拟
//
// 👍 40, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int cost = 0;
            int n = tickets.length;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.offer(new int[]{i, tickets[i]});
            }
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                cost++;
                if (curr[1] == 1) {
                    if (curr[0] == k) {
                        return cost;
                    }
                } else {
                    curr[1]--;
                    queue.offer(curr);
                }
            }
            return cost;
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
        public void testTimeRequiredToBuy() {
            // 测试用例1
            int[] tickets1 = {2, 3, 2};
            int k1 = 2;
            assertEquals(6, solution.timeRequiredToBuy(tickets1, k1));

            // 测试用例2
            int[] tickets2 = {5, 1, 1, 1};
            int k2 = 0;
            assertEquals(8, solution.timeRequiredToBuy(tickets2, k2));
        }
    }
}
