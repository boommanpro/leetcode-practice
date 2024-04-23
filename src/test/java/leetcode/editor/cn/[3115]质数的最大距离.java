package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest3115 {
//给你一个整数数组 nums。
//
// 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
//
//
//
// 示例 1：
//
//
// 输入： nums = [4,2,9,5,3]
//
//
// 输出： 3
//
// 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。
//
// 示例 2：
//
//
// 输入： nums = [4,8,2,8]
//
//
// 输出： 0
//
// 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁵
// 1 <= nums[i] <= 100
// 输入保证 nums 中至少有一个质数。
//
//
// Related Topics数组 | 数学 | 数论
//
// 👍 2, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumPrimeDifference(int[] nums) {
            int MX = 101;
            boolean[] prime = getPrimeArray(MX);
            List<Integer> idx = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (prime[nums[i]]) {
                    idx.add(i);
                }
            }
            if (idx.isEmpty()) {
                return 0;
            }
            return idx.get(idx.size() - 1) - idx.get(0);
        }

        public static boolean[] getPrimeArray(int n) {
            int MX = n + 1;
            boolean[] PRIME = new boolean[MX];
            Arrays.fill(PRIME, true);
            PRIME[1] = false;
            for (int i = 2; i * i < MX; i++) {
                if (!PRIME[i]) continue;
                for (int j = i * i; j < MX; j += i) {
                    PRIME[j] = false; // j 是质数 i 的倍数
                }
            }
            return PRIME;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
            Assert.assertEquals(0, solution.maximumPrimeDifference(new int[]{4, 8, 2, 8}));
        }

    }
}
