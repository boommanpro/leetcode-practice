package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1291 {
//我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。 
//
// 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。 
//
// 
//
// 示例 1： 
//
// 输出：low = 100, high = 300
//输出：[123,234]
// 
//
// 示例 2： 
//
// 输出：low = 1000, high = 13000
//输出：[1234,2345,3456,4567,5678,6789,12345]
// 
//
// 
//
// 提示： 
//
// 
// 10 <= low <= high <= 10^9 
// 
// Related Topics 回溯算法 
// 👍 16 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Integer> result;

        public List<Integer> sequentialDigits(int low, int high) {
            result = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                dfs(0, i, low, high);
            }
            Collections.sort(result);
            return result;
        }

        private void dfs(int value, int p, int low, int high) {
            if (value >= low && value <= high) {
                result.add(value);
            }
            if (value > high) {
                return;
            }
            if (p < 10) {
                value = value * 10 + p;
                dfs(value, p + 1, low, high);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[123, 234]", solution.sequentialDigits(100, 300).toString());
            Assert.assertEquals("[1234, 2345, 3456, 4567, 5678, 6789, 12345]", solution.sequentialDigits(1000, 13000).toString());
        }
    }
}