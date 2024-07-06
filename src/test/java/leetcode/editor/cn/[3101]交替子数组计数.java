package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest3101 {
//给你一个二进制数组 nums 。
//
// 如果一个子数组中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。
//
// 返回数组 nums 中交替子数组的数量。
//
//
//
// 示例 1：
//
//
// 输入： nums = [0,1,1,1]
//
//
// 输出： 5
//
// 解释：
//
//
// 以下子数组是交替子数组：[0] 、[1] 、[1] 、[1] 以及 [0,1] 。
//
// 示例 2：
//
//
// 输入： nums = [1,0,1,0]
//
//
// 输出： 10
//
// 解释：
//
//
// 数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// nums[i] 不是 0 就是 1 。
//
//
// Related Topics数组 | 数学
//
// 👍 24, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countAlternatingSubarrays(int[] nums) {
            long ans = 1;
            int n = nums.length;
            int l = 0;
            int r = 1;
            while (r < n) {
                if (nums[r] == nums[r - 1]) {
                    l = r;
                }
                ans += r - l + 1;
                r++;
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
            Assert.assertEquals(5, solution.countAlternatingSubarrays(new int[]{0, 1, 1, 1}));
            Assert.assertEquals(10, solution.countAlternatingSubarrays(new int[]{1, 0, 1, 0}));
        }

    }
}
