package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionTest2845 {
//给你一个下标从 0 开始的整数数组 nums ，以及整数 modulo 和整数 k 。
//
// 请你找出并统计数组中 趣味子数组 的数目。
//
// 如果 子数组 nums[l..r] 满足下述条件，则称其为 趣味子数组 ：
//
//
// 在范围 [l, r] 内，设 cnt 为满足 nums[i] % modulo == k 的索引 i 的数量。并且 cnt % modulo == k 。
//
//
//
// 以整数形式表示并返回趣味子数组的数目。
//
// 注意：子数组是数组中的一个连续非空的元素序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,2,4], modulo = 2, k = 1
//输出：3
//解释：在这个示例中，趣味子数组分别是：
//子数组 nums[0..0] ，也就是 [3] 。
//- 在范围 [0, 0] 内，只存在 1 个下标 i = 0 满足 nums[i] % modulo == k 。
//- 因此 cnt = 1 ，且 cnt % modulo == k 。
//子数组 nums[0..1] ，也就是 [3,2] 。
//- 在范围 [0, 1] 内，只存在 1 个下标 i = 0 满足 nums[i] % modulo == k 。
//- 因此 cnt = 1 ，且 cnt % modulo == k 。
//子数组 nums[0..2] ，也就是 [3,2,4] 。
//- 在范围 [0, 2] 内，只存在 1 个下标 i = 0 满足 nums[i] % modulo == k 。
//- 因此 cnt = 1 ，且 cnt % modulo == k 。
//可以证明不存在其他趣味子数组。因此，答案为 3 。
//
// 示例 2：
//
//
//输入：nums = [3,1,9,6], modulo = 3, k = 0
//输出：2
//解释：在这个示例中，趣味子数组分别是：
//子数组 nums[0..3] ，也就是 [3,1,9,6] 。
//- 在范围 [0, 3] 内，只存在 3 个下标 i = 0, 2, 3 满足 nums[i] % modulo == k 。
//- 因此 cnt = 3 ，且 cnt % modulo == k 。
//子数组 nums[1..1] ，也就是 [1] 。
//- 在范围 [1, 1] 内，不存在下标满足 nums[i] % modulo == k 。
//- 因此 cnt = 0 ，且 cnt % modulo == k 。
//可以证明不存在其他趣味子数组，因此答案为 2 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 10⁹
// 1 <= modulo <= 10⁹
// 0 <= k < modulo
//
//
// 👍 16, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
            int n = nums.size();
            int sum = 0;
            long ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < n; i++) {
                int v = nums.get(i) % mod == k ? 1 : 0;
                sum += v;
                int remain = (sum - k + mod) % mod;
                ans += map.getOrDefault(remain, 0);
                map.put(sum % mod, map.getOrDefault(sum % mod, 0) + 1);
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
            Assert.assertEquals(3, solution.countInterestingSubarrays(Arrays.asList(3, 2, 4), 2, 1));
            Assert.assertEquals(2, solution.countInterestingSubarrays(Arrays.asList(3, 1, 9, 6), 3, 0));
            Assert.assertEquals(5, solution.countInterestingSubarrays(Arrays.asList(11, 12, 21, 31), 10, 1));
        }

    }
}
