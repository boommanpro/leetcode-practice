package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

class SolutionTest456 {
//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// -109 <= nums[i] <= 109
// Related Topics 栈 
// 👍 418 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            if (n < 3) {
                return false;
            }
            int vI = nums[0];
            TreeMap<Integer, Integer> rightMap = new TreeMap<>();
            for (int k = 2; k < n; k++) {
                rightMap.put(nums[k], rightMap.getOrDefault(nums[k], 0) + 1);
            }
            for (int j = 1; j < n - 1; j++) {
                int vJ = nums[j];
                if (vJ > vI) {
                    Integer vK = rightMap.ceilingKey(vI + 1);
                    if (vK != null && vK < vJ) {
                        return true;
                    }
                }
                vI = Math.min(vI, vJ);
                rightMap.put(nums[j + 1], rightMap.get(nums[j + 1]) - 1);
                if (rightMap.get(nums[j + 1]) == 0) {
                    rightMap.remove(nums[j + 1]);
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
            Assert.assertFalse(solution.find132pattern(new int[]{1, 2, 3, 4}));
            Assert.assertTrue(solution.find132pattern(new int[]{3, 1, 4, 2}));
            Assert.assertTrue(solution.find132pattern(new int[]{-1, 3, 2, 0}));
            Assert.assertTrue(solution.find132pattern(new int[]{3, 5, 0, 3, 4}));
        }

    }
}