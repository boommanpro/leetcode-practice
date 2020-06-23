package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest153 {
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            //即寻找前面大于 num[0] 后面小于num[0]的点
            int n = nums.length;
            if (n < 2) {
                return nums[0];
            }

            int target = nums[0];
            int l = 1;
            int r = n - 1;
            if (target < nums[r]) {
                return target;
            }
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                if (nums[mid] < target) {
                    r = mid;
                } else {
                    l = mid + 1;
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
            Assert.assertEquals(0, solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
            Assert.assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
            Assert.assertEquals(1, solution.findMin(new int[]{1, 2, 3, 4, 5, 6, 7}));
        }
    }
}