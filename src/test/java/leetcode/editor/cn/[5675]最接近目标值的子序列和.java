package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest5675 {
//给你一个整数数组 nums 和一个目标值 goal 。 
//
// 你需要从 nums 中选出一个子序列，使子序列元素总和最接近 goal 。也就是说，如果子序列元素和为 sum ，你需要 最小化绝对差 abs(sum -
// goal) 。 
//
// 返回 abs(sum - goal) 可能的 最小值 。 
//
// 注意，数组的子序列是通过移除原始数组中的某些元素（可能全部或无）而形成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [5,-7,3,5], goal = 6
//输出：0
//解释：选择整个数组作为选出的子序列，元素和为 6 。
//子序列和与目标值相等，所以绝对差为 0 。
// 
//
// 示例 2： 
//
// 输入：nums = [7,-9,15,-2], goal = -5
//输出：1
//解释：选出子序列 [7,-9,-2] ，元素和为 -4 。
//绝对差为 abs(-4 - (-5)) = abs(1) = 1 ，是可能的最小值。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3], goal = -7
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 40 
// -107 <= nums[i] <= 107 
// -109 <= goal <= 109 
// 
// Related Topics 分治算法 
// 👍 12 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minAbsDifference(int[] nums, int goal) {
            int len = nums.length;
            int len1 = (len + 1) / 2;
            int len2 = len - len1;
            int[] f1 = getAllCombination(nums, 0, len1);
            int[] f2 = getAllCombination(nums, len1, len2);
            Arrays.sort(f2);
            int ans = Math.abs(goal);
            for (int v : f1) {
                int target = goal - v;
                int index = binarySearch(f2, target);    //二分查找f2
                if (index < f2.length) {
                    ans = Math.min(ans, Math.abs(v + f2[index] - goal));
                }
                if (index - 1 >= 0) {
                    ans = Math.min(ans, Math.abs(v + f2[index - 1] - goal));
                }
            }
            return ans;
        }

        private int[] getAllCombination(int[] nums, int p, int len) {
            int[] ans = new int[1 << len];
            for (int i = 0; i < 1 << len; i++) {
                for (int j = 0; j < len; j++) {
                    if (((i >> j) & 1) == 1) {
                        ans[i] += nums[j + p];
                    }
                }
            }
            return ans;
        }


        private int binarySearch(int[] nums, int target) {
            int l = 0, r = nums.length;
            //if(target>g[r-1])return r;
            while (l + 1 < r) {
                int mid = l + (r - 1 - l) / 2;
                if (nums[mid] < target) {
                    l = mid + 1;
                } else if (nums[mid] >= target) {
                    r = mid + 1;
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
            Assert.assertEquals(0, solution.minAbsDifference(new int[]{5, -7, 3, 5}, 6));
            Assert.assertEquals(1, solution.minAbsDifference(new int[]{7, -9, 15, -2}, -5));
            Assert.assertEquals(7, solution.minAbsDifference(new int[]{1, 2, 3}, -7));
            Assert.assertEquals(7, solution.minAbsDifference(new int[]{1, 2, 3, 1, 2, 3}, -7));
        }
    }
}