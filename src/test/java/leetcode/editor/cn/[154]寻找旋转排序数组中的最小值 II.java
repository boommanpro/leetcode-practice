package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest154 {
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            //如果是递增序列那么就还是0
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            //二分查找
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else {
                    r--;
                }
            }
            return nums[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals(1, solution.findMin(new int[]{1, 3, 5}));
            Assert.assertEquals(0, solution.findMin(new int[]{2, 2, 2, 0, 1}));

        }
    }
}