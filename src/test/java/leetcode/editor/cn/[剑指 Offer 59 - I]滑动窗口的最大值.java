package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest剑指Offer59_I {
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 191 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        @SuppressWarnings("all")
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || k == 0 || nums.length == 0) {
                return new int[]{};
            }
            int len = nums.length - k + 1;
            int[] ans = new int[len];
            Map<Integer, Integer> deleteCache = new HashMap<>();
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < k; i++) {
                queue.add(nums[i]);
            }
            ans[0] = queue.peek();
            for (int idx = k, i = 1; i < len; i++, idx++) {
                int l = idx - k;
                deleteCache.put(nums[l], deleteCache.getOrDefault(nums[l], 0) + 1);
                while (deleteCache.get(queue.peek()) != null && deleteCache.get(queue.peek()) != 0) {
                    int v = queue.poll();
                    deleteCache.put(v, deleteCache.get(v) - 1);
                }
                queue.add(nums[idx]);
                ans[i] = queue.peek();
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
            Assert.assertEquals("[3, 3, 5, 5, 6, 7]", Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
            Assert.assertEquals("[1, -1]", Arrays.toString(solution.maxSlidingWindow(new int[]{1, -1}, 1)));
        }
    }
}