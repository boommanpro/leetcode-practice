package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SolutionTest805 {
//给定你一个整数数组
// nums 
//
// 我们要将
// nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和
// B 数组不为空，并且
// average(A) == average(B) 。 
//
// 如果可以完成则返回true ， 否则返回 false 。 
//
// 注意：对于数组
// arr , 
// average(arr) 是
// arr 的所有元素的和除以
// arr 长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7,8]
//输出: true
//解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
// 
//
// 示例 2: 
//
// 
//输入: nums = [3,1]
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 30 
// 0 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 状态压缩 👍 244 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return false;
            }
            int n = nums.length;
            int m = n / 2;
            int sum = Arrays.stream(nums).sum();
            for (int i = 0; i < n; i++) {
                nums[i] = nums[i] * n - sum;
            }
            Set<Integer> left = new HashSet<>();
            for (int i = 1; i < (1 << m); i++) {
                int tot = 0;
                for (int j = 0; j < m; j++) {
                    if ((i & (1 << j)) != 0) {
                        tot += nums[j];
                    }
                }
                if (tot == 0) {
                    return true;
                }
                left.add(tot);
            }
            int rSum = 0;
            for (int i = m; i < n; i++) {
                rSum += nums[i];
            }
            for (int i = 1; i < (1 << (n - m)); i++) {
                int tot = 0;
                for (int j = m; j < n; j++) {
                    if ((i & (1 << (j - m))) != 0) {
                        tot += nums[j];
                    }
                }
                if (tot == 0 || (tot != rSum && left.contains(-tot))) {
                    return true;
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
//            Assert.assertFalse(solution.splitArraySameAverage(new int[]{3, 1}));
//            Assert.assertFalse(solution.splitArraySameAverage(new int[]{0}));
//            Assert.assertTrue(solution.splitArraySameAverage(new int[]{73,37,34,95,4,97,22,53,55,52,46,44,71,24,26,35,96,3}));
            Assert.assertTrue(solution.splitArraySameAverage(new int[]{3, 1, 2}));
        }

    }
}