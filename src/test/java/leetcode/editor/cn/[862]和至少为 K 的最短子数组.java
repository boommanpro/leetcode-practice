package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class SolutionTest862 {
//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 397 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int ans = Integer.MAX_VALUE;
            int n = nums.length;
            long[] ss = new long[n + 1];
            for (int i = 0; i < n; i++) {
                ss[i + 1] = ss[i] + (long) nums[i];
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < ss.length; i++) {
                while (!queue.isEmpty() && ss[i] <= ss[queue.getLast()]) {
                    queue.pollLast();
                }
                while (!queue.isEmpty() && ss[i] - k >= ss[queue.getFirst()]) {
                    ans = Math.min(ans, i - queue.pollFirst());
                }
                queue.addLast(i);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.shortestSubarray(new int[]{1}, 1));
            Assert.assertEquals(-1, solution.shortestSubarray(new int[]{1, 2}, 4));
            Assert.assertEquals(3, solution.shortestSubarray(new int[]{2, -1, 2}, 3));
        }

    }
}