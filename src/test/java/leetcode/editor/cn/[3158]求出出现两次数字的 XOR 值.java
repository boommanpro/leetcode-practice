package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest3158 {
//给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。
//
// 请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,1,3]
//
//
// 输出：1
//
// 解释：
//
// nums 中唯一出现过两次的数字是 1 。
//
// 示例 2：
//
//
// 输入：nums = [1,2,3]
//
//
// 输出：0
//
// 解释：
//
// nums 中没有数字出现两次。
//
// 示例 3：
//
//
// 输入：nums = [1,2,2,1]
//
//
// 输出：3
//
// 解释：
//
// 数字 1 和 2 出现过两次。1 XOR 2 == 3 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50
// 1 <= nums[i] <= 50
// nums 中每个数字要么出现过一次，要么出现过两次。
//
//
// Related Topics位运算 | 数组 | 哈希表
//
// 👍 8, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int duplicateNumbersXOR(int[] nums) {
            int[] cnt = new int[51];
            for (int num : nums) {
                cnt[num]++;
            }
            int ans = 0;
            for (int i = 0; i < 51; i++) {
                if (cnt[i] == 2) {
                    ans ^= i;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(24, solution.duplicateNumbersXOR(new int[]{10, 18, 7, 10, 18}));
        }

    }
}
