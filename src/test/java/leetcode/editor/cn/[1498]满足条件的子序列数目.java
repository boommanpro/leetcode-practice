package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1498 {
//给你一个整数数组 nums 和一个整数 target 。
//
// 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
//
// 由于答案可能很大，请将结果对 10^9 + 7 取余后返回。
//
//
//
// 示例 1：
//
// 输入：nums = [3,5,6,7], target = 9
//输出：4
//解释：有 4 个子序列满足该条件。
//[3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
//[3,5] -> (3 + 5 <= 9)
//[3,5,6] -> (3 + 6 <= 9)
//[3,6] -> (3 + 6 <= 9)
//
//
// 示例 2：
//
// 输入：nums = [3,3,6,8], target = 10
//输出：6
//解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
//[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
//
// 示例 3：
//
// 输入：nums = [2,3,3,4,6,7], target = 12
//输出：61
//解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
//有效序列总数为（63 - 2 = 61）
//
//
// 示例 4：
//
// 输入：nums = [5,2,4,1,7,6,8], target = 16
//输出：127
//解释：所有非空子序列都满足条件 (2^7 - 1) = 127
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^6
// 1 <= target <= 10^6
//
// Related Topics 排序 Sliding Window
// 👍 46 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final int MOD = (int) (1e9 + 7);

        static final int MAX_N = 100001;

        private final int[] CACHE = new int[100001];

        public int numSubseq(int[] nums, int target) {
            fillCache();
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length && nums[i] * 2 <= target; i++) {
                int maxValue = target - nums[i];
                int p = binarySearch(nums, i, maxValue) - 1;
                int contribute = p >= i ? CACHE[p - i] : 0;
                ans = (ans + contribute) % MOD;
            }
            return ans;
        }

        public int binarySearch(int[] nums, int start, int target) {
            int low = start, high = nums.length;
            while (low < high) {
                int mid = (high - low >> 1) + low;
                if (mid == nums.length) {
                    return mid;
                }
                int num = nums[mid];
                if (num <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        private void fillCache() {
            CACHE[0] = 1;
            for (int i = 1; i < MAX_N; ++i) {
                CACHE[i] = (CACHE[i - 1] << 1) % MOD;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.numSubseq(new int[]{3, 5, 6, 7}, 9));
            Assert.assertEquals(6, solution.numSubseq(new int[]{3, 3, 6, 8}, 10));
            Assert.assertEquals(61, solution.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
            Assert.assertEquals(127, solution.numSubseq(new int[]{5, 2, 4, 1, 7, 6, 8}, 16));
            Assert.assertEquals(272187084, solution.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22));
        }
    }
}