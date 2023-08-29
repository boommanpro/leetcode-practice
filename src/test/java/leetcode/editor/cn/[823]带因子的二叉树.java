package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest823 {
//给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
//
// 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
//
// 满足条件的二叉树一共有多少个？答案可能很大，返回 对 10⁹ + 7 取余 的结果。
//
//
//
// 示例 1:
//
//
//输入: arr = [2, 4]
//输出: 3
//解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]
//
// 示例 2:
//
//
//输入: arr = [2, 4, 5, 10]
//输出: 7
//解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 1000
// 2 <= arr[i] <= 10⁹
// arr 中的所有值 互不相同
//
//
// Related Topics数组 | 哈希表 | 动态规划 | 排序
//
// 👍 204, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final long MOD = (int) 1e9 + 7;

        public int numFactoredBinaryTrees(int[] A) {
            int n = A.length;
            long[] dp = new long[n];
            Arrays.fill(dp, 1);
            Arrays.sort(A);
            long ans = 0;
            for (int i = 0; i < n; i++) {
                long target = A[i];
                for (int left = 0, right = i - 1; left <= right; left++) {
                    while (right >= left && (long) A[left] * A[right] > target) {
                        right--;
                    }
                    if (right >= left && (long) A[left] * A[right] == target) {
                        if (right == left) {
                            dp[i] = (dp[i] + dp[left] * dp[right]) % MOD;
                        } else {
                            dp[i] = (dp[i] + dp[left] * dp[right] * 2) % MOD;
                        }
                    }
                }
                ans = (ans + dp[i]) % MOD;
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.numFactoredBinaryTrees(new int[]{2, 4}));
            Assert.assertEquals(7, solution.numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
            Assert.assertEquals(509730797, solution.numFactoredBinaryTrees(new int[]{46,144,5040,4488,544,380,4410,34,11,5,3063808,5550,34496,12,540,28,18,13,2,1056,32710656,31,91872,23,26,240,18720,33,49,4,38,37,1457,3,799,557568,32,1400,47,10,20774,1296,9,21,92928,8704,29,2162,22,1883700,49588,1078,36,44,352,546,19,523370496,476,24,6000,42,30,8,16262400,61600,41,24150,1968,7056,7,35,16,87,20,2730,11616,10912,690,150,25,6,14,1689120,43,3128,27,197472,45,15,585,21645,39,40,2205,17,48,136}));
        }

    }
}
