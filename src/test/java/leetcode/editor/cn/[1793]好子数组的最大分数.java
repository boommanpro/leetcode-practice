package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1793 {
//给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
//
// 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个
// 好 子数组的两个端点下标需要满足 i <= k <= j 。
//
// 请你返回 好 子数组的最大可能 分数 。
//
//
//
// 示例 1：
//
// 输入：nums = [1,4,3,7,4,5], k = 3
//输出：15
//解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
//
//
// 示例 2：
//
// 输入：nums = [5,5,4,5,4,1,1,1], k = 0
//输出：20
//解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 2 * 10⁴
// 0 <= k < nums.length
//
//
// Related Topics栈 | 数组 | 双指针 | 二分查找 | 单调栈
//
// 👍 122, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumScore(int[] nums, int k) {
            int l= k ;
            int r = k;
            int ans = nums[k];
            int min = nums[k];
            int n = nums.length;
            for (int i = 0; i < n - 1; i++) {
                if (r == n - 1 || l > 0 && nums[l - 1] > nums[r + 1]) {
                    min = Math.min(min, nums[--l]);
                }else {
                    min = Math.min(min, nums[++r]);
                }
                ans = Math.max(ans, min*(r - l + 1));
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
            Assert.assertEquals(15, solution.maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));
            Assert.assertEquals(20, solution.maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));
        }

    }
}
