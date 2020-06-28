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
            //找到旋转点
            int distance = getRotatePosition(nums);
            int l = 0;
            int r = n - 1;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                int actual = (mid + distance) % n;
                if (nums[actual] == target) {
                    return actual;
                }
                if (nums[actual] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return -1;
        }

        /**
         * 这里结合 153 寻找旋转数组中的最小值  只不过这里返回的是坐标
         */
        private int getRotatePosition0(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return 0;
            }
            int l = 0;
            int r = nums.length - 1;
            while (nums[l] > nums[r]) {
                l++;
            }
            return l;
        }

        private int getRotatePosition(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return nums[0];
            }
            int target = nums[0];
            int l = 1;
            int r = n - 1;
            if (target < nums[r]) {
                return 0;
            }
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[mid] < target) {
                    r = mid;
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
            Assert.assertEquals(0, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
            Assert.assertEquals(1, solution.search(new int[]{3, 4, 5, 1, 2}, 4));
            Assert.assertEquals(1, solution.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 2));
            Assert.assertEquals(0, solution.search(new int[]{0, 1, 2, 4, 5, 6, 7,}, 0));
            Assert.assertEquals(6, solution.search(new int[]{0, 1, 2, 4, 5, 6, 7,}, 7));
            Assert.assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
            Assert.assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
            Assert.assertEquals(-1, solution.search(new int[]{0, 1, 2, 4, 5, 6, 7,}, 3));
            Assert.assertEquals(2, solution.search(new int[]{4, 5, 1, 2, 3}, 1));
            Assert.assertEquals(1, solution.search(new int[]{3,1}, 1));
        }
    }
}