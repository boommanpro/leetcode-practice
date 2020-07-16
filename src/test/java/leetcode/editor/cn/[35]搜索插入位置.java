package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest35 {
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            if (target < nums[0]) {
                return 0;
            }
            if (target > nums[n - 1]) {
                return n;
            }
            //二分查找
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
            Assert.assertEquals(1, solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
            Assert.assertEquals(4, solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
            Assert.assertEquals(0, solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
            Assert.assertEquals(0, solution.searchInsert(new int[]{1}, 1));
            Assert.assertEquals(1, solution.searchInsert(new int[]{1, 3}, 2));
        }
    }
}