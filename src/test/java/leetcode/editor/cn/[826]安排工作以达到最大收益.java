package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

class SolutionTest826 {
//你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
//
//
// difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
// worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
//
//
// 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
//
//
// 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
//
//
// 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
//
//
//
// 示例 1：
//
//
//输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//输出: 100
//解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
//
// 示例 2:
//
//
//输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
//输出: 0
//
//
//
// 提示:
//
//
// n == difficulty.length
// n == profit.length
// m == worker.length
// 1 <= n, m <= 10⁴
// 1 <= difficulty[i], profit[i], worker[i] <= 10⁵
//
//
// Related Topics贪心 | 数组 | 双指针 | 二分查找 | 排序
//
// 👍 153, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = difficulty.length;
            for (int i = 0; i < n; i++) {
                map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));
            }
            int max = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
                map.put(entry.getKey(), max);
            }
            int ans = 0;
            for (int w : worker) {
                ans += Optional.ofNullable(map.floorEntry(w)).map(Map.Entry::getValue).orElse(0);
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
            Assert.assertEquals(100, solution.maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7}));
            Assert.assertEquals(0, solution.maxProfitAssignment(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25}));
            Assert.assertEquals(324, solution.maxProfitAssignment(new int[]{68,35,52,47,86}, new int[]{67,17,1,81,3}, new int[]{92,10,85,84,82}));
        }

    }
}
