package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest33 {
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[l] <= nums[mid]) {
                    if (target >= nums[l] && target <= nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (target >= nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
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
            Assert.assertEquals(0, solution.search(new int[]{1}, 1));
            Assert.assertEquals(1, solution.search(new int[]{3, 1}, 1));
            Assert.assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
            Assert.assertEquals(0, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
            Assert.assertEquals(1, solution.search(new int[]{3, 4, 5, 1, 2}, 4));
            Assert.assertEquals(1, solution.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 2));
            Assert.assertEquals(0, solution.search(new int[]{0, 1, 2, 4, 5, 6, 7,}, 0));
            Assert.assertEquals(6, solution.search(new int[]{0, 1, 2, 4, 5, 6, 7,}, 7));
            Assert.assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
            Assert.assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
            Assert.assertEquals(-1, solution.search(new int[]{0, 1, 2, 4, 5, 6, 7,}, 3));
            Assert.assertEquals(2, solution.search(new int[]{4, 5, 1, 2, 3}, 1));
            Assert.assertEquals(1, solution.search(new int[]{3, 1}, 1));
        }
    }
}