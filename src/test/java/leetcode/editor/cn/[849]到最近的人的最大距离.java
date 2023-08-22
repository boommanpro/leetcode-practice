package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
import test.AndOrTest;

import java.util.ArrayList;
import java.util.List;

class SolutionTest849 {
//给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标
//从 0 开始）。
//
// 至少有一个空座位，且至少有一人已经坐在座位上。
//
// 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
//
// 返回他到离他最近的人的最大距离。
//
//
//
// 示例 1：
//
//
//输入：seats = [1,0,0,0,1,0,1]
//输出：2
//解释：
//如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
//如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
//因此，他到离他最近的人的最大距离是 2 。
//
//
// 示例 2：
//
//
//输入：seats = [1,0,0,0]
//输出：3
//解释：
//如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
//这是可能的最大距离，所以答案是 3 。
//
//
// 示例 3：
//
//
//输入：seats = [0,1]
//输出：1
//
//
//
//
// 提示：
//
//
// 2 <= seats.length <= 2 * 10⁴
// seats[i] 为 0 或 1
// 至少有一个 空座位
// 至少有一个 座位上有人
//
//
// Related Topics数组
//
// 👍 258, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistToClosest(int[] seats) {
            List<Integer> queue = new ArrayList<>();
            queue.add(Integer.MIN_VALUE);
            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 1) {
                    queue.add(i);
                }
            }
            queue.add(seats.length);
            int ans = 1;
            for (int i = 1; i < queue.size(); i++) {
                if (i == 1) {
                    ans = Math.max(ans, queue.get(i));
                    continue;
                }
                if (i == queue.size() - 1) {
                    ans = Math.max(ans, queue.get(i) - queue.get(i - 1) - 1);
                    continue;
                }
                ans = Math.max(ans, (queue.get(i) - queue.get(i - 1)) / 2);

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
            Assert.assertEquals(2, solution.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
            Assert.assertEquals(3, solution.maxDistToClosest(new int[]{1, 0, 0, 0}));
            Assert.assertEquals(1, solution.maxDistToClosest(new int[]{0, 1}));
        }

    }
}
