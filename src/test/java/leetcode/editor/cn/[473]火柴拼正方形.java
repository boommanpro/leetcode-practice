package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.function.IntPredicate;

class SolutionTest473 {
//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 10⁸ 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 328 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean makesquare(int[] matchsticks) {
            if (matchsticks.length < 4) {
                return false;
            }
            long sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0) {
                return false;
            }
            long len = sum / 4;
            Arrays.sort(matchsticks);
            if (Arrays.stream(matchsticks).filter(value -> value > len).findAny().isPresent()) {
                return false;
            }
            int[] edges = new int[4];
            return dfs(matchsticks.length - 1, matchsticks, edges, len);
        }

        private boolean dfs(int idx, int[] matchsticks, int[] edges, long len) {
            if (idx == -1) {
                return true;
            }
            for (int i = 0; i < edges.length; i++) {
                edges[i] += matchsticks[idx];
                if (edges[i] <= len && dfs(idx - 1, matchsticks, edges, len)) {
                    return true;
                }
                edges[i] -= matchsticks[idx];
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.makesquare(new int[]{1, 1, 2, 2, 2}));
            Assert.assertFalse(solution.makesquare(new int[]{3, 3, 3, 3, 4}));
            Assert.assertFalse(solution.makesquare(new int[]{5969561, 8742425, 2513572, 3352059, 9084275, 2194427, 1017540, 2324577, 6810719, 8936380, 7868365, 2755770, 9954463, 9912280, 4713511}));
            Assert.assertTrue(solution.makesquare(new int[]{13, 11, 1, 8, 6, 7, 8, 8, 6, 7, 8, 9, 8}));
            Assert.assertFalse(solution.makesquare(new int[]{99, 37, 37, 37, 37, 37, 37, 37, 37, 5}));
        }

    }
}