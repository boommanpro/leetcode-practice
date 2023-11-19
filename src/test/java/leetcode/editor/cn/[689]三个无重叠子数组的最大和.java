package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest689 {
//给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且全部数字和（3 * k 项）最大的子数组，并返回这三个子数组。
//
// 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,1,2,6,7,5,1], k = 2
//输出：[0,3,5]
//解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
//也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
//
//
// 示例 2：
//
//
//输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
//输出：[0,2,4]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 10⁴
// 1 <= nums[i] < 2¹⁶
// 1 <= k <= floor(nums.length / 3)
//
//
// Related Topics数组 | 动态规划
//
// 👍 382, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[3];
            int[] sum = new int[3];
            int[] max = new int[3];
            int[] idx = new int[3];
            for (int i = 0; i < n - 2 * k; i++) {
                sum[0] += nums[i];
                sum[1] += nums[i + k];
                sum[2] += nums[i + 2 * k];
                if (i >= k - 1) {
                    if (sum[0] > max[0]) {
                        max[0] = sum[0];
                        idx[0] = i - k + 1;
                    }
                    if (max[0] + sum[1] > max[1]) {
                        max[1] = max[0] + sum[1];
                        idx[1] = idx[0];
                        idx[2] = i + 1;
                    }
                    if (max[1] + sum[2] > max[2]) {
                        max[2] = max[1] + sum[2];
                        ans[0] = idx[1];
                        ans[1] = idx[2];
                        ans[2] = i + k + 1;
                    }
                    sum[0] -= nums[i - k + 1];
                    sum[1] -= nums[i + 1];
                    sum[2] -= nums[i + k + 1];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[0, 3, 5]", Arrays.toString(solution.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
            Assert.assertEquals("[0, 2, 4]", Arrays.toString(solution.maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1}, 2)));
        }

    }
}
