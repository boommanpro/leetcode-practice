package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest219 {

    //给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (nums == null) {
                return false;
            }
            Map<Integer, Integer> positionMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (positionMap.containsKey(nums[i])) {
                    if (i - positionMap.get(nums[i]) <= k) {
                        return true;
                    }
                    positionMap.put(nums[i], i);
                } else {
                    positionMap.put(nums[i], i);
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
            Assert.assertTrue(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
            Assert.assertTrue(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
            Assert.assertFalse(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
            Assert.assertTrue(solution.containsNearbyDuplicate(new int[]{99, 99}, 2));
        }
    }
}