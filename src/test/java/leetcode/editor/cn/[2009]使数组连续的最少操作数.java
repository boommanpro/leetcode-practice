package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest2009 {
//给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。
//
// 如果 nums 满足以下条件，那么它是 连续的 ：
//
//
// nums 中所有元素都是 互不相同 的。
// nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。
//
//
// 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。
//
// 请你返回使 nums 连续 的 最少 操作次数。
//
//
//
// 示例 1：
//
// 输入：nums = [4,2,5,3]
//输出：0
//解释：nums 已经是连续的了。
//
//
// 示例 2：
//
// 输入：nums = [1,2,3,5,6]
//输出：1
//解释：一个可能的解是将最后一个元素变为 4 。
//结果数组为 [1,2,3,5,4] ，是连续数组。
//
//
// 示例 3：
//
// 输入：nums = [1,10,100,1000]
//输出：3
//解释：一个可能的解是：
//- 将第二个元素变为 2 。
//- 将第三个元素变为 3 。
//- 将第四个元素变为 4 。
//结果数组为 [1,2,3,4] ，是连续数组。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁹
//
//
// Related Topics数组 | 哈希表 | 二分查找 | 滑动窗口
//
// 👍 42, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            int n = nums.length, ans = 0;
            Arrays.sort(nums);
            int j = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[j++] = nums[i];
                }
            }
            for (int l = 0, r = 0; r < j; r++) {
                while (nums[r] - nums[l] > n - 1) {
                    l++;
                }
                ans = Math.max(ans, r - l + 1);
            }
            return n - ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.minOperations(new int[]{1, 1, 2, 2, 3, 4}));
            Assert.assertEquals(0, solution.minOperations(new int[]{4, 2, 5, 3}));
            Assert.assertEquals(1, solution.minOperations(new int[]{1, 2, 3, 5, 6}));
            Assert.assertEquals(3, solution.minOperations(new int[]{1, 10, 100, 1000}));
        }

    }
}
