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

            if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
                return new int[]{-1, -1};
            }
            int len = nums.length;
            int l = 0;
            int r = len - 1;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[mid] == target) {
                    while (mid > 0 && nums[mid - 1] == target) {
                        mid--;
                    }
                    return new int[]{mid, findTargetRight(nums, mid, target)};
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return new int[]{-1, -1};
        }

        private int findTargetRight(int[] nums, int mid, int target) {
            while (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                mid++;
            }
            return mid;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{}, 0));
            Assert.assertArrayEquals(new int[]{0, 0}, solution.searchRange(new int[]{1}, 1));
            Assert.assertArrayEquals(new int[]{0, 1}, solution.searchRange(new int[]{2, 2}, 2));
            Assert.assertArrayEquals(new int[]{3, 4}, solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
            Assert.assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
            Assert.assertArrayEquals(new int[]{5, 17}, solution.searchRange(new int[]{1, 2, 3, 4, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10}, 7));
            Assert.assertArrayEquals(new int[]{5, 31}, solution.searchRange(new int[]{1, 2, 3, 4, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,}, 7));

        }
    }
}