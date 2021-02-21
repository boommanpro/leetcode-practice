package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

class SolutionTest1438 {
//给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limi
//t 。 
//
// 如果不存在满足条件的子数组，则返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,2,4,7], limit = 4
//输出：2 
//解释：所有子数组如下：
//[8] 最大绝对差 |8-8| = 0 <= 4.
//[8,2] 最大绝对差 |8-2| = 6 > 4. 
//[8,2,4] 最大绝对差 |8-2| = 6 > 4.
//[8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
//[2] 最大绝对差 |2-2| = 0 <= 4.
//[2,4] 最大绝对差 |2-4| = 2 <= 4.
//[2,4,7] 最大绝对差 |2-7| = 5 > 4.
//[4] 最大绝对差 |4-4| = 0 <= 4.
//[4,7] 最大绝对差 |4-7| = 3 <= 4.
//[7] 最大绝对差 |7-7| = 0 <= 4. 
//因此，满足题意的最长子数组的长度为 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [10,1,2,4,7,2], limit = 5
//输出：4 
//解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
// 
//
// 示例 3： 
//
// 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^9 
// 0 <= limit <= 10^9 
// 
// Related Topics 数组 Sliding Window 
// 👍 118 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int ans = 0;
            //0是值 1是 position
            PriorityQueue<int[]> maxQueue = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            });
            PriorityQueue<int[]> minQueue = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            });
            for (int l = 0, r = 0; r < nums.length; r++) {
                if (!maxQueue.isEmpty()) {
                    while (!maxQueue.isEmpty() && Math.abs(maxQueue.peek()[0] - nums[r]) > limit) {
                        int[] top = maxQueue.poll();
                        l = Math.max(l, top[1] + 1);
                    }
                }
                if (!minQueue.isEmpty()) {
                    while (!minQueue.isEmpty() && Math.abs(minQueue.peek()[0] - nums[r]) > limit) {
                        int[] top = minQueue.poll();
                        l = Math.max(l, top[1] + 1);
                    }
                }
                maxQueue.add(new int[]{nums[r], r});
                minQueue.add(new int[]{nums[r], r});
                ans = Math.max(ans, r - l + 1);
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
            Assert.assertEquals(2, solution.longestSubarray(new int[]{8, 2, 4, 7}, 4));
            Assert.assertEquals(4, solution.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
            Assert.assertEquals(3, solution.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
        }
    }
}