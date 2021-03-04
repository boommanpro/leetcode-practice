package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest354 {
//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 333 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) {
                return 0;
            }
            int len = envelopes.length;
            Arrays.sort(envelopes, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            });
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < len; i++) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.maxEnvelopes(new int[][]{
                    {5, 4}, {6, 4}, {6, 7}, {2, 3}
            }));
        }
    }
}