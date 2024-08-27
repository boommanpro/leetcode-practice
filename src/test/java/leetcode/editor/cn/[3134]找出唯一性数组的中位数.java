package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest3134 {
//给你一个整数数组 nums 。数组 nums 的 唯一性数组 是一个按元素从小到大排序的数组，包含了 nums 的所有非空 子数组 中不同元素的个数。
//
// 换句话说，这是由所有 0 <= i <= j < nums.length 的 distinct(nums[i..j]) 组成的递增数组。
//
// 其中，distinct(nums[i..j]) 表示从下标 i 到下标 j 的子数组中不同元素的数量。
//
// 返回 nums 唯一性数组 的 中位数 。
//
// 注意，数组的 中位数 定义为有序数组的中间元素。如果有两个中间元素，则取值较小的那个。
//
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,3]
//
//
// 输出：1
//
// 解释：
//
// nums 的唯一性数组为 [distinct(nums[0..0]), distinct(nums[1..1]), distinct(nums[2..2]
//), distinct(nums[0..1]), distinct(nums[1..2]), distinct(nums[0..2])]，即 [1, 1, 1,
// 2, 2, 3] 。唯一性数组的中位数为 1 ，因此答案是 1 。
//
// 示例 2：
//
//
// 输入：nums = [3,4,3,4,5]
//
//
// 输出：2
//
// 解释：
//
// nums 的唯一性数组为 [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答
//案是 2 。
//
// 示例 3：
//
//
// 输入：nums = [4,3,5,4]
//
//
// 输出：2
//
// 解释：
//
// nums 的唯一性数组为 [1, 1, 1, 1, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答案是 2 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
//
//
// Related Topics数组 | 哈希表 | 二分查找 | 滑动窗口
//
// 👍 35, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int medianOfUniquenessArray(int[] nums) {
            int n = nums.length;
            long k = (((long) (n + 1) * n) / 2 + 1) / 2;
            int left = 0, right = n;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (check(nums, mid, k)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;

        }

        private boolean check(int[] nums, int mid, long k) {
            int count = 0;
            int l = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int r = 0; r < nums.length; r++) {
                map.merge(nums[r], 1, Integer::sum);
                while (map.size() > mid) {
                    int out = nums[l++];
                    map.merge(out, -1, Integer::sum);
                    if (map.get(out) == 0) {
                        map.remove(out);
                    }
                }
                count += r - l + 1;
                if (count >= k) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testMedianOfUniquenessArray1() {
            int[] nums = {1, 2, 3};
            int expected = 1;
            Assert.assertEquals(expected, solution.medianOfUniquenessArray(nums));
        }

        @Test
        public void testMedianOfUniquenessArray2() {
            int[] nums = {3, 4, 3, 4, 5};
            int expected = 2;
            Assert.assertEquals(expected, solution.medianOfUniquenessArray(nums));
        }

        @Test
        public void testMedianOfUniquenessArray3() {
            int[] nums = {4, 3, 5, 4};
            int expected = 2;
            Assert.assertEquals(expected, solution.medianOfUniquenessArray(nums));
        }
    }
}
