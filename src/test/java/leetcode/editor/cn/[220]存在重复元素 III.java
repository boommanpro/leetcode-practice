package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

class SolutionTest220 {
//在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的
//绝对值也小于等于 ķ 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            // |nums[i]-nums[j]|<=t
            // |i-j| <=k
            TreeSet<Long> set = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                Long value = set.ceiling((long) nums[i] - t);
                if (value != null && value - t <= nums[i]) {
                    return true;
                }
                set.add((long) nums[i]);
                if (set.size() == k + 1) {
                    set.remove((long) nums[i - k]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
            Assert.assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
            Assert.assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        }
    }
}