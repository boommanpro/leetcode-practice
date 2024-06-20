package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest2748 {
//给你一个下标从 0 开始的整数数组 nums 。如果下标对 i、j 满足 0 ≤ i < j < nums.length ，如果 nums[i] 的 第一个
//数字 和 nums[j] 的 最后一个数字 互质 ，则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
//
// 返回 nums 中 美丽下标对 的总数目。
//
// 对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。换而言之，如果 gcd(x, y) == 1 ，则认为
//x 和 y 互质，其中 gcd(x, y) 是 x 和 y 的 最大公因数 。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,5,1,4]
//输出：5
//解释：nums 中共有 5 组美丽下标对：
//i = 0 和 j = 1 ：nums[0] 的第一个数字是 2 ，nums[1] 的最后一个数字是 5 。2 和 5 互质，因此 gcd(2,5) ==
//1 。
//i = 0 和 j = 2 ：nums[0] 的第一个数字是 2 ，nums[2] 的最后一个数字是 1 。2 和 1 互质，因此 gcd(2,1) ==
//1 。
//i = 1 和 j = 2 ：nums[1] 的第一个数字是 5 ，nums[2] 的最后一个数字是 1 。5 和 1 互质，因此 gcd(5,1) ==
//1 。
//i = 1 和 j = 3 ：nums[1] 的第一个数字是 5 ，nums[3] 的最后一个数字是 4 。5 和 4 互质，因此 gcd(5,4) ==
//1 。
//i = 2 和 j = 3 ：nums[2] 的第一个数字是 1 ，nums[3] 的最后一个数字是 4 。1 和 4 互质，因此 gcd(1,4) ==
//1 。
//因此，返回 5 。
//
//
// 示例 2：
//
//
//输入：nums = [11,21,12]
//输出：2
//解释：共有 2 组美丽下标对：
//i = 0 和 j = 1 ：nums[0] 的第一个数字是 1 ，nums[1] 的最后一个数字是 1 。gcd(1,1) == 1 。
//i = 0 和 j = 2 ：nums[0] 的第一个数字是 1 ，nums[2] 的最后一个数字是 2 。gcd(1,2) == 1 。
//因此，返回 2 。
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 100
// 1 <= nums[i] <= 9999
// nums[i] % 10 != 0
//
//
// Related Topics数组 | 哈希表 | 数学 | 计数 | 数论
//
// 👍 32, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBeautifulPairs(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (calcGcd(nums[i], nums[j])) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private boolean calcGcd(int num, int num1) {
            int i = num1 % 10;
            int j = 0;
            while (num > 0) {
                j = num % 10;
                num /= 10;
            }
            return gcd(i, j) == 1;
        }

        private int gcd(int a, int b) {
            if (a < b) {
                return gcd(b, a);
            }
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.countBeautifulPairs(new int[]{2, 5, 1, 4}));
            Assert.assertEquals(2, solution.countBeautifulPairs(new int[]{11, 21, 12}));
        }

    }
}
