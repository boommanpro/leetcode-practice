package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest34 {
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] searchRange(int[] nums, int target) {
            int[] ans = {-1, -1};
            if (nums == null) {
                return ans;
            }
            int n = nums.length;
            if (n == 0) {
                return ans;
            }
            //做两次二分查找即可
            int l = 0;
            int r = n - 1;
            //寻找第一个位置
            l = findFirstPosition(nums, l, r, target);
            if (l == -1) {
                return ans;
            }

            ans[0] = l;
            r = n - 1;
            //寻找最后一个位置
            while (l + 1 <= r) {
                if (nums[l + 1] == target) {
                    l++;
                    continue;
                }
                break;
            }
            ans[1] = l;
            return ans;
        }

        private int findFirstPosition(int[] nums, int l, int r, int target) {
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (nums[l] == target) {
                return l;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertArrayEquals(new int[]{0, 1}, solution.searchRange(new int[]{2, 2}, 2));
            Assert.assertArrayEquals(new int[]{3, 4}, solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
            Assert.assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
            Assert.assertArrayEquals(new int[]{5, 17}, solution.searchRange(new int[]{1, 2, 3, 4, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10}, 7));

        }
    }
}