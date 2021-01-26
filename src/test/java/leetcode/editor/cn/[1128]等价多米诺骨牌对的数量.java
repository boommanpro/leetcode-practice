package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

class SolutionTest1128 {
//给你一个由一些多米诺骨牌组成的列表 dominoes。 
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 
//b==c。 
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。 
//
// 
//
// 示例： 
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dominoes.length <= 40000 
// 1 <= dominoes[i][j] <= 9 
// 
// Related Topics 数组 
// 👍 58 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            for (int[] dominoe : dominoes) {
                if (dominoe[0] <= dominoe[1]) {
                    continue;
                }
                int temp = dominoe[0];
                dominoe[0] = dominoe[1];
                dominoe[1] = temp;
            }
            Arrays.sort(dominoes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
            });
            int ans = 0;
            int cnt = 1;
            for (int i = 1; i < dominoes.length; i++) {
                if (dominoes[i][0] == dominoes[i - 1][0] && dominoes[i][1] == dominoes[i - 1][1]) {
                    cnt++;
                } else {
                    ans += cnt * (cnt - 1) / 2;
                    cnt = 1;
                }
            }
            ans += cnt * (cnt - 1) / 2;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
            Assert.assertEquals(3, solution.numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
            Assert.assertEquals(5, solution.numEquivDominoPairs(new int[][]{{1, 1}, {1, 1}, {1, 2}, {1, 2}, {1, 2}, {2, 2}, {2, 2}}));
        }
    }
}