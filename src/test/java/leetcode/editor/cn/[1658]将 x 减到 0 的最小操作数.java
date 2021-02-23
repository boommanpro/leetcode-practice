package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1658 {
//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
// 数组以供接下来的操作使用。 
//
// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 104 
// 1 <= x <= 109 
// 
// Related Topics 贪心算法 双指针 二分查找 Sliding Window 
// 👍 51 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums, int x) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int target = sum - x;
            if (target < 0) {
                return -1;
            }
            int ans = Integer.MIN_VALUE;
            for (int curr = 0, l = 0, r = 0; r < nums.length; r++) {
                curr += nums[r];
                while (curr > target) {
                    curr -= nums[l];
                    l++;
                }
                if (curr == target) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
            return ans == Integer.MIN_VALUE ? -1 : nums.length - ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
            Assert.assertEquals(-1, solution.minOperations(new int[]{5, 6, 7, 8, 9}, 4));
            Assert.assertEquals(5, solution.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
            Assert.assertEquals(5, solution.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
        }

    }
}