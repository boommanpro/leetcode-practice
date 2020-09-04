package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SolutionTest967 {
//返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。 
//
// 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。 
//
// 你可以按任何顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：N = 3, K = 7
//输出：[181,292,707,818,929]
//解释：注意，070 不是一个有效的数字，因为它有前导零。
// 
//
// 示例 2： 
//
// 输入：N = 2, K = 1
//输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98] 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 9 
// 0 <= K <= 9 
// 
// Related Topics 动态规划 
// 👍 23 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numsSameConsecDiff(int N, int K) {
            Set<Integer> dict = IntStream.range(1, 10).boxed().collect(Collectors.toSet());

            for (int i = 1; i < N; i++) {
                Set<Integer> temp = new HashSet<>();
                for (Integer x : dict) {
                    int d = x % 10;
                    if (d - K >= 0) {
                        temp.add(10 * x + (d - K));
                    }
                    if (d + K <= 9) {
                        temp.add(10 * x + (d + K));
                    }
                    dict = temp;
                }
            }
            if (N == 1) {
                dict.add(0);
            }
            return dict.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[181, 292, 707, 818, 929]", Arrays.toString(solution.numsSameConsecDiff(3, 7)));
            Assert.assertEquals("[181818181, 292929292, 707070707, 818181818, 929292929]", Arrays.toString(solution.numsSameConsecDiff(9, 7)));
            Assert.assertEquals("[10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98]", Arrays.toString(solution.numsSameConsecDiff(2, 1)));
            Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(solution.numsSameConsecDiff(1, 1)));
            Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(solution.numsSameConsecDiff(1, 5)));
        }
    }
}