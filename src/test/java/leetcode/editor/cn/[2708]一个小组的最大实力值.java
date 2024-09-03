package leetcode.editor.cn;

import org.junit.Test;

class SolutionTest2708 {
//给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值
//最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[
//i2] * ... * nums[ik] 。
//
// 请你返回老师创建的小组能得到的最大实力值为多少。
//
//
//
// 示例 1：
//
// 输入：nums = [3,-1,-5,2,5,-9]
//输出：1350
//解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这
//是可以得到的最大实力值。
//
//
// 示例 2：
//
// 输入：nums = [-4,-5,-4]
//输出：20
//解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 13
// -9 <= nums[i] <= 9
//
//
// Related Topics贪心 | 位运算 | 数组 | 动态规划 | 回溯 | 枚举 | 排序
//
// 👍 54, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maxStrength(int[] nums) {
            long mn = nums[0];
            long mx = nums[0];
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                long v = nums[i];
                long temp = mn;
                mn = Math.min(Math.min(mn, v), Math.min(mn * v, mx * v));
                mx = Math.max(Math.max(mx, v), Math.max(mx * v, temp * v));
            }
            return mx;
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

    }
}
