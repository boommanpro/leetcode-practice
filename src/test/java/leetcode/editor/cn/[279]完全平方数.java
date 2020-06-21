package leetcode.editor.cn;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest279 {
//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        @SuppressWarnings("all")
        public int numSquares(int n) {
            List<Integer> squareList = calcSquareList(n);
            int depth = 0;
            Queue<Integer> queue = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            visited.add(n);
            queue.add(n);
            while (!queue.isEmpty()) {
                int l = queue.size();

                for (int t = 0; t < l; t++) {
                    Integer curr = queue.poll();
                    if (curr == 0) {
                        return depth;
                    }
                    for (Integer i : squareList) {
                        int v = curr - i;
                        if (v >= 0) {
                            if (!visited.contains(v)) {
                                visited.add(v);
                                queue.offer(v);
                            }
                        }
                    }
                }
                depth++;
            }
            return -1;
        }

        private List<Integer> calcSquareList(int n) {
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                result.add(i * i);
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.numSquares(1));
            Assert.assertEquals(3, solution.numSquares(12));
            Assert.assertEquals(2, solution.numSquares(13));
            Assert.assertEquals(4, solution.numSquares(7168));
        }
    }
}