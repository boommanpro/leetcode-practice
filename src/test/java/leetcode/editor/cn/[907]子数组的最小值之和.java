package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

class SolutionTest907 {
//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。
//
//
//
// 示例 1：
//
//
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
//
// 示例 2：
//
//
//输入：arr = [11,81,94,43,3]
//输出：444
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 3 * 10⁴
// 1 <= arr[i] <= 3 * 10⁴
//
//
//
//
// Related Topics栈 | 数组 | 动态规划 | 单调栈
//
// 👍 761, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = (int) ((1e9) + 7);
        public int sumSubarrayMins(int[] arr) {
            int[][] boundaries = minBoundaries(arr);
            int n = arr.length;
            long ans = 0;
            for (int i = 0; i < n; i++) {
                long add = ((long) arr[i] * (i - boundaries[i][0]) * (boundaries[i][1] - i)) % MOD;
                ans = (ans + add) % MOD;
            }
            return (int) (ans % MOD);
        }

        public int[][] minBoundaries(int[] arr) {
            int n = arr.length;
            int[][] res = new int[n][2];
            Stack<Integer> stack = new Stack<>();
            // 0为左边界 1为右边界
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    res[stack.pop()][1] = i;
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                res[stack.pop()][1] = n;
            }
            for (int i = n-1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    res[stack.pop()][0] = i;
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                res[stack.pop()][0] = -1;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(17, solution.sumSubarrayMins(new int[]{3, 1, 2, 4}));
            Assert.assertEquals(444, solution.sumSubarrayMins(new int[]{11,81,94,43,3}));
            Assert.assertEquals(593, solution.sumSubarrayMins(new int[]{71,55,82,55}));
        }

    }
}
